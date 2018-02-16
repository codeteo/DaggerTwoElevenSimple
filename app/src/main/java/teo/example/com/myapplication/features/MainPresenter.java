package teo.example.com.myapplication.features;

import javax.inject.Inject;

import teo.example.com.myapplication.di.scopes.ActivityScope;

/**
 * Presenter for {@link MainActivity}
 */

@ActivityScope
public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;

    @Inject
    MainPresenter(MainMVP.View view) {
        this.view = view;
    }

    @Override
    public void onLoadData() {
        if (view != null) {
            view.showMessage("LOADED");
        }
    }
}
