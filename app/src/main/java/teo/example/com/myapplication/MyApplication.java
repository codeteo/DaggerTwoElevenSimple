package teo.example.com.myapplication;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import teo.example.com.myapplication.di.DaggerApplicationComponent;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

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

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }

}
