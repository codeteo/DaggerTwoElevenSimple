package teo.example.com.myapplication.data.repository.sources.remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import teo.example.com.myapplication.data.api.MoviesService;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.repository.sources.PopularMoviesDataSource;

import static teo.example.com.myapplication.utils.Qualifiers.API_KEY;

/**
 * Implementation of a data source that fetches data from
 * the network.
 */

public class PopularMoviesRemoteDataSource implements PopularMoviesDataSource {

    private MoviesService service;
    private String apiKey;

    @Inject
    public PopularMoviesRemoteDataSource(MoviesService service,
                                         @Named(API_KEY) String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<List<PopularMovieModel>> popularMovies() {
        return service.getMostPopular(apiKey);
    }
}
