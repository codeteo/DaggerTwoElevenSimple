package teo.example.com.myapplication.domain;

import java.util.List;

import io.reactivex.Observable;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Interactor for getting popular movies.
 */

public interface GetPopularMoviesUseCase {

    Observable<List<PopularMovie>> getMovies();

}
