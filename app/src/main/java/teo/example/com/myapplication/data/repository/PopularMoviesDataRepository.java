package teo.example.com.myapplication.data.repository;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieDataMapper;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieEntityMapper;
import teo.example.com.myapplication.data.repository.sources.local.PopularMoviesLocalDataSource;
import teo.example.com.myapplication.data.repository.sources.remote.PopularMoviesRemoteDataSource;
import teo.example.com.myapplication.domain.entities.PopularMovie;
import teo.example.com.myapplication.domain.repository.PopularMoviesRepository;
import teo.example.com.myapplication.utils.NetworkUtils;
import teo.example.com.myapplication.utils.schedulers.BaseSchedulerProvider;

/**
 * {@link PopularMoviesRepository} for retrieving popular movies.
 */

public class PopularMoviesDataRepository implements PopularMoviesRepository {

    private PopularMoviesLocalDataSource localDataSource;
    private PopularMoviesRemoteDataSource remoteDataSource;
    private PopularMovieDataMapper mapper;
    private PopularMovieEntityMapper localMapper;
    private BaseSchedulerProvider schedulerProvider;
    private NetworkUtils networkUtils;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public PopularMoviesDataRepository(PopularMoviesLocalDataSource localDataSource,
                                       PopularMoviesRemoteDataSource remoteDataSource,
                                       PopularMovieDataMapper mapper, PopularMovieEntityMapper localMapper,
                                       BaseSchedulerProvider schedulerProvider,
                                       NetworkUtils networkUtils) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.mapper = mapper;
        this.localMapper = localMapper;
        this.schedulerProvider = schedulerProvider;
        this.networkUtils = networkUtils;
    }

    @Override
    public Observable<List<PopularMovie>> popularMovies() {
        if (networkUtils.isOnline()) {
            loadMoviesFromNetwork();
        }

        return loadMoviesFromDB();
    }

    private void loadMoviesFromNetwork() {
        disposable.add(
            remoteDataSource.popularMovies()
                .map(mapMoviesToEntities())
                .doOnNext(movies -> localDataSource.saveMovies(movies))
                .subscribeOn(schedulerProvider.io())
                .subscribe(entities -> {}, throwable -> {}));
    }

    @NonNull
    private Function<List<PopularMovieModel>, List<PopularMovieEntity>> mapMoviesToEntities() {
        return movies -> {

            List<PopularMovieEntity> entities = new ArrayList<>();
            for (PopularMovieModel movieModel : movies) {
                entities.add(localMapper.transform(movieModel));
            }
            return entities;

        };
    }

    private Observable<List<PopularMovie>> loadMoviesFromDB() {
        return localDataSource.popularMovies()
                .map(mapMoviesToModels());
    }

    @NonNull
    private Function<List<PopularMovieModel>, List<PopularMovie>> mapMoviesToModels() {
        return models -> {

            List<PopularMovie> popularMovieList = new ArrayList<>();
            for (PopularMovieModel model : models) {
                popularMovieList.add(mapper.transform(model));
            }

            return popularMovieList;
        };
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }

}
