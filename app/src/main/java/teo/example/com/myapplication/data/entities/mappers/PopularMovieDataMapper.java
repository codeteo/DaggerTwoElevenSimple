package teo.example.com.myapplication.data.entities.mappers;

import javax.inject.Inject;

import teo.example.com.myapplication.common.mappers.Mapper;
import teo.example.com.myapplication.data.entities.PopularMovieModel;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Mapper class to transform data from the data layer ({@link PopularMovieModel})
 * to items in the domain layer ({@link PopularMovie}).
 */

public class PopularMovieDataMapper implements Mapper<PopularMovieModel, PopularMovie> {

    @Inject
    public PopularMovieDataMapper() {
        // required for constructor injection
    }

    @Override
    public PopularMovie transform(PopularMovieModel model) {
        PopularMovie movie = new PopularMovie();

        movie.setId(String.valueOf(model.getId()));
        movie.setBackdropPath(model.getBackdropPath());
        movie.setOverview(model.getOverview());
        movie.setPosterPath(model.getPosterPath());
        movie.setReleaseDate(model.getReleaseDate());
        movie.setTitle(model.getTitle());
        movie.setVoteAverage(model.getVoteAverage());
        movie.setVoteCount(model.getVoteCount());
        movie.setAdult(model.getAdult());
        movie.setOriginalLanguage(model.getOriginalLanguage());
        movie.setVideo(model.getVideo());

        return movie;
    }
}
