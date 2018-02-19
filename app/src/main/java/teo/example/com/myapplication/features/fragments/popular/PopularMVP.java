package teo.example.com.myapplication.features.fragments.popular;

/**
 * Contract class for {@link PopularFragment}
 */

public interface PopularMVP {

    interface View {

        void showMessage(String message);

    }

    interface Presenter {

        void onLoadData();

        void unsubscribe();
    }

}
