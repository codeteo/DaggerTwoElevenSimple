package teo.example.com.myapplication.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;

/**
 * Dao class for "popular" movies table.
 */

@Dao
public interface PopularMovieDao {

    /**
     * Select all movies from the "popular" table.
     *
     * @return all popular movies.
     */
    @Query("SELECT * FROM popular_movies")
    Flowable<List<PopularMovieEntity>> getPopularMovies();

    /**
     * Insert list of movies to "popular" table.
     *
     * @param movies to be inserted.
     */
    @Insert
    void saveMovies(List<PopularMovieEntity> movies);

}