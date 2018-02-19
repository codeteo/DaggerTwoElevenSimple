package teo.example.com.myapplication.data.repository;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
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

    @Inject
    public PopularMoviesDataRepository(PopularMoviesLocalDataSource localDataSource,
                                       PopularMoviesRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<PopularMovie>> popularMovies() {
        return localDataSource.popularMovies();
    }

}
