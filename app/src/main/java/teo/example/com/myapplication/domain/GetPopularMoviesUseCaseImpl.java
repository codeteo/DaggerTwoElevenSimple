package teo.example.com.myapplication.domain;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import teo.example.com.myapplication.domain.entities.PopularMovie;
import teo.example.com.myapplication.domain.repository.PopularMoviesRepository;
import teo.example.com.myapplication.utils.schedulers.BaseSchedulerProvider;

/**
 * This class is an implementation of {@link GetPopularMoviesUseCase} that
 * represents a use case for retrieving popular movies ({@link PopularMovie}s).
 */

public class GetPopularMoviesUseCaseImpl implements GetPopularMoviesUseCase {

    private PopularMoviesRepository repository;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public GetPopularMoviesUseCaseImpl(PopularMoviesRepository repository,
                                       BaseSchedulerProvider schedulerProvider) {
        this.repository = repository;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Observable<List<PopularMovie>> getMovies() {
        return repository.popularMovies()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }
}
