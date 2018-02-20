package teo.example.com.myapplication.features.fragments.popular;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import teo.example.com.myapplication.domain.GetPopularMoviesUseCase;

/**
 * Presenter for {@link PopularFragment}
 */

public class PopularPresenter implements PopularMVP.Presenter {

    private PopularMVP.View view;
    private GetPopularMoviesUseCase getPopularMoviesUseCase;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    PopularPresenter(PopularMVP.View view, GetPopularMoviesUseCase useCase) {
        this.view = view;
        this.getPopularMoviesUseCase = useCase;
    }

    @Override
    public void onLoadData() {
        disposable.add(
                getPopularMoviesUseCase.getMovies()
                    .subscribe(popularMovies -> {
                        if (view != null) {
                            view.showMovies(popularMovies);
                        }
                    }, throwable -> {}));
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }
}
