package teo.example.com.myapplication.features.fragments.popular.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import teo.example.com.myapplication.data.api.MoviesService;
import teo.example.com.myapplication.data.database.dao.PopularMovieDao;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieDataMapper;
import teo.example.com.myapplication.data.entities.mappers.PopularMovieEntityMapper;
import teo.example.com.myapplication.data.repository.PopularMoviesDataRepository;
import teo.example.com.myapplication.data.repository.sources.PopularMoviesDataSource;
import teo.example.com.myapplication.data.repository.sources.local.PopularMoviesLocalDataSource;
import teo.example.com.myapplication.data.repository.sources.local.mapper.PopularMovieLocalMapper;
import teo.example.com.myapplication.data.repository.sources.remote.PopularMoviesRemoteDataSource;
import teo.example.com.myapplication.data.repository.sources.remote.mapper.PopularMovieRemoteMapper;
import teo.example.com.myapplication.di.scopes.FragmentScope;
import teo.example.com.myapplication.domain.GetPopularMoviesUseCase;
import teo.example.com.myapplication.domain.GetPopularMoviesUseCaseImpl;
import teo.example.com.myapplication.domain.repository.PopularMoviesRepository;
import teo.example.com.myapplication.utils.NetworkUtils;
import teo.example.com.myapplication.utils.schedulers.BaseSchedulerProvider;

import static teo.example.com.myapplication.utils.Qualifiers.API_KEY;

/**
 * Dagger module to provide data-related dependencies
 * for popular movies feature.
 */

@Module
public class PopularDataModule {

    @FragmentScope
    @Provides
    GetPopularMoviesUseCase providesGetPopularMoviesUseCase(PopularMoviesRepository repository,
                                                            BaseSchedulerProvider schedulerProvider) {

        return new GetPopularMoviesUseCaseImpl(repository, schedulerProvider);
    }

    @FragmentScope
    @Provides
    PopularMoviesRepository providesPopularMoviesDataRepository(
            PopularMoviesLocalDataSource localDataSource,
            PopularMoviesRemoteDataSource remoteDataSource,
            PopularMovieDataMapper mapper, PopularMovieEntityMapper entityMapper,
            BaseSchedulerProvider schedulerProvider, NetworkUtils networkUtils) {

        return new PopularMoviesDataRepository(localDataSource, remoteDataSource,
                mapper, entityMapper, schedulerProvider, networkUtils);
    }

    @FragmentScope
    @Provides
    PopularMoviesDataSource providesPopularMoviesLocalDataSource(
                PopularMovieDao dao, PopularMovieLocalMapper mapper) {

        return new PopularMoviesLocalDataSource(dao, mapper);
    }

    @FragmentScope
    @Provides
    PopularMoviesDataSource providesPopularMoviesRemoteDataSource(
            MoviesService service, @Named(API_KEY) String apiKey, PopularMovieRemoteMapper mapper) {

        return new PopularMoviesRemoteDataSource(service, apiKey, mapper);
    }

}
