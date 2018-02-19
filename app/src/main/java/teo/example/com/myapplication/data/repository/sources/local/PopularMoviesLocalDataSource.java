package teo.example.com.myapplication.data.repository.sources.local;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import teo.example.com.myapplication.data.database.dao.PopularMovieDao;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.repository.sources.PopularMoviesDataSource;

/**
 * Implementation of a data source that fetches data from
 * the database.
 */

public class PopularMoviesLocalDataSource implements PopularMoviesDataSource {

    private PopularMovieDao dao;
    private

    @Inject
    public PopularMoviesLocalDataSource(PopularMovieDao dao) {
        this.dao = dao;
    }

    @Override
    public Observable<List<PopularMovieModel>> popularMovies() {
        return dao.getPopularMovies();
    }
}
