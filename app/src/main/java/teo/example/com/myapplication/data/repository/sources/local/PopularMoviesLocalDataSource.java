package teo.example.com.myapplication.data.repository.sources.local;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import teo.example.com.myapplication.data.database.dao.PopularMovieDao;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.data.repository.sources.PopularMoviesDataSource;
import teo.example.com.myapplication.data.repository.sources.local.mapper.PopularMovieLocalMapper;

/**
 * Implementation of a data source that fetches data from
 * the database.
 */

public class PopularMoviesLocalDataSource implements PopularMoviesDataSource {

    private PopularMovieDao dao;
    private PopularMovieLocalMapper mapper;

    @Inject
    public PopularMoviesLocalDataSource(PopularMovieDao dao,
                                        PopularMovieLocalMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<PopularMovieModel>> popularMovies() {
        return dao.getPopularMovies()
                .map(mapToModels())
                .toObservable();
    }

    @Override
    public void saveMovies(List<PopularMovieEntity> movies) {
        dao.saveMovies(movies);
    }

    @NonNull
    private Function<List<PopularMovieEntity>, List<PopularMovieModel>> mapToModels() {
        return entities -> {

            List<PopularMovieModel> modelList = new ArrayList<>();
            for (PopularMovieEntity entity: entities){
                modelList.add(mapper.transform(entity));
            }

            return modelList;
        };
    }
}
