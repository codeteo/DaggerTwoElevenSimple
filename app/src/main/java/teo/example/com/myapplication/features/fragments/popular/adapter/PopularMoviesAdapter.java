package teo.example.com.myapplication.features.fragments.popular.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import teo.example.com.myapplication.R;
import teo.example.com.myapplication.domain.entities.PopularMovie;

/**
 * Adapter for displaying a list of popular movies.
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMovieViewHolder> {

    private List<PopularMovie> dataset;
    private Context context;

    public PopularMoviesAdapter(List<PopularMovie> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @Override
    public PopularMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular_movie, parent, false);

        return new PopularMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PopularMovieViewHolder holder, int position) {
        holder.setViewModel(new MovieViewModel(dataset.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

}
