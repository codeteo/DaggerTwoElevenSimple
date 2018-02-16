package teo.example.com.myapplication.domain;

import java.util.List;

import io.reactivex.Flowable;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Interactor for getting popular movies.
 */

public interface GetPopularMoviesUseCase {

    Flowable<List<PopularMovie>> getMovies();

}
