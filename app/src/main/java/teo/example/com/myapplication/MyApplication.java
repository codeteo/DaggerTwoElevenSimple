package teo.example.com.myapplication;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by teo on 14/2/2018.
 */

public class MyApplication extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
