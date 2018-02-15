package teo.example.com.myapplication.features.fragments.popular;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Presenter for {@link PopularFragment}
 */

public class PopularPresenter implements PopularMVP.Presenter {

    private PopularMVP.View view;

    @Inject
    PopularPresenter(PopularMVP.View view) {
        this.view = view;
    }

    @Override
    public void onLoadData() {
        Timber.i("LOADS DATA");
        if (view != null) {
            view.showMessage("POPULAR DATA");
        }
    }
}
