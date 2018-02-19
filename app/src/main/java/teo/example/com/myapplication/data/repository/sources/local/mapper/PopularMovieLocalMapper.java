package teo.example.com.myapplication.data.repository.sources.local.mapper;

import javax.inject.Inject;

import teo.example.com.myapplication.common.mappers.Mapper;
import teo.example.com.myapplication.data.database.entities.PopularMovieEntity;
import teo.example.com.myapplication.data.entities.PopularMovieModel;

/**
 * Mapper class to transform data from the database layer to items
 * in the domain layer.
 */

public class PopularMovieLocalMapper implements Mapper<PopularMovieEntity, PopularMovieModel> {

    @Inject
    public PopularMovieLocalMapper() {
        // required for constructor injection
    }

    @Override
    public PopularMovieModel transform(PopularMovieEntity entity) {
        PopularMovieModel model = new PopularMovieModel();

        model.setId(entity.getId());
        model.setBackdropPath(entity.getBackdropPath());
        model.setOverview(entity.getOverview());
        model.setPosterPath(entity.getPosterPath());
        model.setReleaseDate(entity.getReleaseDate());
        model.setTitle(entity.getTitle());
        model.setVoteAverage(entity.getVoteAverage());
        model.setVoteCount(entity.getVoteCount());
        model.setAdult(entity.getAdult());
        model.setOriginalLanguage(entity.getOriginalLanguage());
        model.setVideo(entity.getVideo());

        return model;
    }
}
