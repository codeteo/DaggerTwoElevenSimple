package teo.example.com.myapplication.features;

import javax.inject.Inject;

import teo.example.com.myapplication.di.ActivityScope;
import timber.log.Timber;

/**
 * Presenter for {@link MainActivity}
 */

@ActivityScope
public class MainPresenter implements MainMVP.Presenter {

    @Inject
    MainPresenter() {
    }

    @Override
    public void onLoadData() {
        Timber.i("LOAD DATA");
    }
}
