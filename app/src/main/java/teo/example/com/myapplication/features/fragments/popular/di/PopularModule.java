package teo.example.com.myapplication.features.fragments.popular.di;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import teo.example.com.myapplication.common.mappers.Mapper;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieDataMapper;
import teo.example.com.myapplication.data.repository.sources.local.mapper.PopularMovieLocalMapper;
import teo.example.com.myapplication.data.repository.sources.remote.mapper.PopularMovieRemoteMapper;
import teo.example.com.myapplication.di.scopes.FragmentScope;
import teo.example.com.myapplication.features.fragments.popular.PopularFragment;
import teo.example.com.myapplication.features.fragments.popular.PopularMVP;
import teo.example.com.myapplication.features.fragments.popular.PopularPresenter;

/**
 * Dagger Module for {@link PopularFragment}.
 */

@Module
public abstract class PopularModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = PopularDataModule.class)
    abstract PopularFragment bindsPopularFragment();

    @FragmentScope
    @Binds
    abstract PopularMVP.Presenter providesPopularPresenter(PopularPresenter presenter);

    @FragmentScope
    @Binds
    abstract PopularMVP.View providesPopularFragment(PopularFragment fragment);

    @FragmentScope
    @Binds
    abstract Mapper providesPopularMovieDataMapper(PopularMovieDataMapper mapper);

    @FragmentScope
    @Binds
    abstract Mapper providesPopularMovieLocalMapper(PopularMovieLocalMapper mapper);

    @FragmentScope
    @Binds
    abstract Mapper providesPopularMovieRemoteMapper(PopularMovieRemoteMapper mapper);

}
