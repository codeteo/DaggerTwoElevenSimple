package teo.example.com.myapplication.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Interface that represents a Repository for getting {@link PopularMovie} related data.
 */

public interface PopularMoviesRepository {

    /**
     * Get an {@link Observable} which will emit a List of {@link PopularMovie}s.
     */
    Observable<List<PopularMovie>> popularMovies();

    /**
     * remove rxJava subscriptions
     */
    void unsubscribe();

}
