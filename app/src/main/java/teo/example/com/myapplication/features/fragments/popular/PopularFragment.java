package teo.example.com.myapplication.features.fragments.popular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import teo.example.com.myapplication.R;
import teo.example.com.myapplication.domain.entities.PopularMovie;
import teo.example.com.myapplication.features.fragments.popular.adapter.PopularMoviesAdapter;

/**
 * Screen with popular movies.
 */

public class PopularFragment extends DaggerFragment implements PopularMVP.View {

    private RecyclerView recyclerView;

    private PopularMoviesAdapter adapter;

    @Inject
    PopularMVP.Presenter presenter;

    public static PopularFragment newInstance() {

        Bundle args = new Bundle();

        PopularFragment fragment = new PopularFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.unsubscribe();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        initViews(view);

        presenter.onLoadData();

        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.rv_popular_movies_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void showMovies(List<PopularMovie> movies) {
        if (isAdded()) {
            if (adapter == null) {
                adapter = new PopularMoviesAdapter(movies, getActivity());
                recyclerView.setAdapter(adapter);
            }
        }
    }
}
