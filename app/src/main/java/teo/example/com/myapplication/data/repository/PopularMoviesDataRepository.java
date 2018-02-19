package teo.example.com.myapplication.data.repository;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieDataMapper;
import teo.example.com.myapplication.data.repository.sources.local.PopularMoviesLocalDataSource;
import teo.example.com.myapplication.data.repository.sources.remote.PopularMoviesRemoteDataSource;
import teo.example.com.myapplication.domain.entities.PopularMovie;
import teo.example.com.myapplication.domain.repository.PopularMoviesRepository;

/**
 * {@link PopularMoviesRepository} for retrieving popular movies.
 */

public class PopularMoviesDataRepository implements PopularMoviesRepository {

    private PopularMoviesLocalDataSource localDataSource;
    private PopularMoviesRemoteDataSource remoteDataSource;
    private PopularMovieDataMapper mapper;

    @Inject
    public PopularMoviesDataRepository(PopularMoviesLocalDataSource localDataSource,
                                       PopularMoviesRemoteDataSource remoteDataSource,
                                       PopularMovieDataMapper mapper) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<PopularMovie>> popularMovies() {
        return localDataSource.popularMovies()
                .map(models -> {

                    List<PopularMovie> popularMovieList = new ArrayList<>();
                    for (PopularMovieModel model: models){
                        popularMovieList.add(mapper.transform(model));
                    }

                    return popularMovieList;
                });
    }

}
