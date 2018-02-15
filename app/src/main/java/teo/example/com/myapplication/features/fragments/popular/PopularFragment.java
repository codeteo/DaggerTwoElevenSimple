package teo.example.com.myapplication.features.fragments.popular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import teo.example.com.myapplication.R;

/**
 * Screen with popular movies.
 */

public class PopularFragment extends DaggerFragment implements PopularMVP.View {

    private TextView tvTitle;

    @Inject
    PopularMVP.Presenter presenter;

    public static PopularFragment newInstance() {

        Bundle args = new Bundle();

        PopularFragment fragment = new PopularFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        tvTitle = view.findViewById(R.id.tv_popular_title);

        presenter.onLoadData();

        return view;
    }

    @Override
    public void showMessage(String message) {
        tvTitle.setText(message);
    }
}
