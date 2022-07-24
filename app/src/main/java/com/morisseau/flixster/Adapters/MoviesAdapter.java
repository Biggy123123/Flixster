package com.morisseau.flixster.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Configuration;

import com.bumptech.glide.Glide;
import com.morisseau.flixster.Models.Movie;
import com.morisseau.flixster.Models.Movie;
import com.morisseau.flixster.R;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.VideoAdapter> {

    Context context;
    List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public VideoAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter","onCreateViewHolder");
        View movieView= LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        return new VideoAdapter(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter holder, int position) {
        Log.d("MovieAdapter","onBindViewHolder"+ position);
        Movie movie=movies.get(position);
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class VideoAdapter extends RecyclerView.ViewHolder{

    TextView tvTitle;
    ImageView ivPoster;
    TextView tvOverview;


    public VideoAdapter(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }
    }
}
