package teo.example.com.myapplication.data.repository.sources.remote.mapper;

import javax.inject.Inject;

import teo.example.com.myapplication.common.mappers.Mapper;
import teo.example.com.myapplication.data.api.entities.MoviesResponseNestedResults;
import teo.example.com.myapplication.data.entities.PopularMovieModel;

/**
 * Mapper class to transform data from the network layer to items
 * in the domain layer.
 */

public class PopularMovieRemoteMapper implements Mapper<MoviesResponseNestedResults, PopularMovieModel> {

    @Inject
    public PopularMovieRemoteMapper() {
        // required for constructor injection
    }

    @Override
    public PopularMovieModel transform(MoviesResponseNestedResults results) {
        PopularMovieModel model = new PopularMovieModel();

        model.setId(Integer.valueOf(results.getId()));
        model.setBackdropPath(results.getBackdropPath());
        model.setOverview(results.getOverview());
        model.setPosterPath(results.getPosterPath());
        model.setReleaseDate(results.getReleaseDate());
        model.setTitle(results.getTitle());
        model.setVoteAverage(results.getVoteAverage());
        model.setVoteCount(results.getVoteCount());
        model.setAdult(results.getAdult());
        model.setOriginalLanguage(results.getOriginalLanguage());
        model.setVideo(results.getVideo());

        return model;
    }
}

