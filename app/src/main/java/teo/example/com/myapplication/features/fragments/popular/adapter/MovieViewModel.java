package teo.example.com.myapplication.features.fragments.popular.adapter;

import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * ViewModel for the list of movies in {@link PopularMoviesAdapter}
 */

public final class MovieViewModel {

    private PopularMovie movie;

    public MovieViewModel(PopularMovie movie) {
        this.movie = movie;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public String getOverview() {
        return movie.getOverview();
    }

    public String getImageUrl() {
        return movie.getBackdropPath();
    }
}