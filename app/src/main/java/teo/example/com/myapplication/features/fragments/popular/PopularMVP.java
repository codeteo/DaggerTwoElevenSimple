package teo.example.com.myapplication.features.fragments.popular;

import java.util.List;

import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Contract class for {@link PopularFragment}
 */

public interface PopularMVP {

    interface View {

        void showMovies(List<PopularMovie> movies);

    }

    interface Presenter {

        void onLoadData();

        void unsubscribe();
    }

}
