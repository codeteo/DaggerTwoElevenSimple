package teo.example.com.myapplication.domain;

import java.util.List;

import io.reactivex.Flowable;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * This class is an implementation of {@link GetPopularMoviesUseCase} that
 * represents a use case for retrieving popular movies ({@link PopularMovie}s).
 */

public class GetPopularMoviesUseCaseImpl implements GetPopularMoviesUseCase {

    @Override
    public Flowable<List<PopularMovie>> getMovies() {
        return null;
    }
}
