package teo.example.com.myapplication.data.repository.sources;

import java.util.List;

import io.reactivex.Observable;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Interface that represents a data store from where data is retrieved.
 */

public interface PopularMoviesDataSource {

    /**
     * Get an {@link Observable} which will emit a List of {@link PopularMovie}s.
     */
    Observable<List<PopularMovieModel>> popularMovies();

    /**
     * Saves list of movies to database.
     */
    void saveMovies(List<PopularMovieEntity> movies);

}
