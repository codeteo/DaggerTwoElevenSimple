package teo.example.com.myapplication.features.fragments.popular.di;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import teo.example.com.myapplication.di.FragmentScope;
import teo.example.com.myapplication.features.fragments.popular.PopularFragment;
import teo.example.com.myapplication.features.fragments.popular.PopularMVP;
import teo.example.com.myapplication.features.fragments.popular.PopularPresenter;

/**
 * Dagger Module for {@link PopularFragment}.
 */

@Module
public abstract class PopularModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract PopularFragment bindsPopularFragment();

    @FragmentScope
    @Binds
    abstract PopularMVP.Presenter providesPopularPresenter(PopularPresenter presenter);

    @FragmentScope
    @Binds
    abstract PopularMVP.View providesPopularFragment(PopularFragment fragment);

}
