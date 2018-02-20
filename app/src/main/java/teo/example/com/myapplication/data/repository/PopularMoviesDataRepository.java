package teo.example.com.myapplication.data.repository;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieDataMapper;
import teo.example.com.myapplication.data.repository.sources.local.PopularMoviesLocalDataSource;
import teo.example.com.myapplication.data.repository.sources.remote.PopularMoviesRemoteDataSource;
import teo.example.com.myapplication.domain.entities.PopularMovie;
import teo.example.com.myapplication.domain.repository.PopularMoviesRepository;
import teo.example.com.myapplication.utils.NetworkUtils;

/**
 * {@link PopularMoviesRepository} for retrieving popular movies.
 */

public class PopularMoviesDataRepository implements PopularMoviesRepository {

    private PopularMoviesLocalDataSource localDataSource;
    private PopularMoviesRemoteDataSource remoteDataSource;
    private PopularMovieDataMapper mapper;
    private NetworkUtils networkUtils;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public PopularMoviesDataRepository(PopularMoviesLocalDataSource localDataSource,
                                       PopularMoviesRemoteDataSource remoteDataSource,
                                       PopularMovieDataMapper mapper, NetworkUtils networkUtils) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.mapper = mapper;
        this.networkUtils = networkUtils;
    }

    @Override
    public Observable<List<PopularMovie>> popularMovies() {
        if (networkUtils.isOnline()) {
            disposable.add(
                    remoteDataSource.popularMovies()
                            .subscribe(
                                    movies -> {

                                    },
                                    throwable -> { }));
        }
        return localDataSource.popularMovies()
                .map(models -> {

                    List<PopularMovie> popularMovieList = new ArrayList<>();
                    for (PopularMovieModel model: models){
                        popularMovieList.add(mapper.transform(model));
                    }

                    return popularMovieList;
                });
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }

}
