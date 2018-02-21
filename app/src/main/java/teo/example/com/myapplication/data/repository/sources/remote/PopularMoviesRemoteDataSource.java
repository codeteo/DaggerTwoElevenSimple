package teo.example.com.myapplication.data.repository.sources.remote;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Response;
import teo.example.com.myapplication.data.api.MoviesService;
import teo.example.com.myapplication.data.api.entities.MoviesResponse;
import teo.example.com.myapplication.data.api.entities.MoviesResponseNestedResults;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.repository.sources.PopularMoviesDataSource;
import teo.example.com.myapplication.data.repository.sources.remote.mapper.PopularMovieRemoteMapper;

import static teo.example.com.myapplication.utils.Qualifiers.API_KEY;

/**
 * Implementation of a data source that fetches data from
 * the network.
 */

public class PopularMoviesRemoteDataSource implements PopularMoviesDataSource {

    private MoviesService service;
    private String apiKey;
    private PopularMovieRemoteMapper mapper;

    @Inject
    public PopularMoviesRemoteDataSource(MoviesService service,
                                         @Named(API_KEY) String apiKey,
                                         PopularMovieRemoteMapper mapper) {
        this.service = service;
        this.apiKey = apiKey;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<PopularMovieModel>> popularMovies() {
        return service.getMostPopular(apiKey)
                .map(mapToModel())
                .toObservable();
    }

    @Override
    public void saveMovies(List<PopularMovieEntity> movies) {
        //do nothing
    }

    @NonNull
    private Function<Response<MoviesResponse>, List<PopularMovieModel>> mapToModel() {
        return response -> {

            if (response.isSuccessful()) {
                MoviesResponse body = response.body();
                if (body != null) {
                    List<PopularMovieModel> movieList = new ArrayList<>();
                    for (MoviesResponseNestedResults movie: body.getResults()){
                        movieList.add(mapper.transform(movie));
                    }

                    return movieList;
                } else {
                    return Collections.emptyList();
                }
            } else {
                return Collections.emptyList();
            }

        };
    }
}
