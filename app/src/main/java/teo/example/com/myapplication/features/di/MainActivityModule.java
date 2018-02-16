package teo.example.com.myapplication.features.di;

import dagger.Binds;
import dagger.Module;
import teo.example.com.myapplication.di.scopes.ActivityScope;
import teo.example.com.myapplication.features.MainActivity;
import teo.example.com.myapplication.features.MainMVP;
import teo.example.com.myapplication.features.MainPresenter;

/**
 * Dagger module for {@link MainActivity}.
 */

@Module
public abstract class MainActivityModule {

    @ActivityScope
    @Binds
    abstract MainMVP.Presenter providesMainPresenter(MainPresenter presenter);

    @ActivityScope
    @Binds
    abstract MainMVP.View providesMainActivity(MainActivity activity);

}
