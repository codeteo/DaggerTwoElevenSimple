package teo.example.com.myapplication;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import teo.example.com.myapplication.di.DaggerApplicationComponent;

/**
 * Main class of the application.
 */

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder()
                .app(this)
                .build();
    }
}
