package teo.example.com.myapplication.data.repository;


import java.util.List;

import io.reactivex.Observable;
import teo.example.com.myapplication.data.database.dao.PopularMovieDao;
import teo.example.com.myapplication.domain.entities.PopularMovie;
import teo.example.com.myapplication.domain.repository.PopularMoviesRepository;

/**
 * {@link PopularMoviesRepository} for retrieving popular movies.
 */

public class PopularMoviesDataRepository implements PopularMoviesRepository {

    private PopularMovieDao dao;


    @Override
    public Observable<List<PopularMovie>> popularMovies() {
        return null;
    }

}
