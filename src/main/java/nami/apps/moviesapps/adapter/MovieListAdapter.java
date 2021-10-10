package nami.apps.moviesapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import nami.apps.moviesapps.gson.Movie;
import nami.apps.moviesapps.R;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<Movie> mMovieList ;

    public MovieListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mMovieList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);

        // This is how we use Picasso to load images from the internet.

        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.view.movieImage);

        holder.view.movieTitle.setText(movie.getTitle());
        holder.view.movieReleaseYear.setText(movie.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return mMovieList ==  null ? 0 : mMovieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        public MovieRow view;
        public MovieViewHolder(View itemView)
        {
            super(itemView);
            view = new MovieRow();
            view.movieImage = (ImageView) itemView.findViewById(R.id.imageView);
            view.movieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
            view.movieReleaseYear = (TextView) itemView.findViewById(R.id.movieReleaseYear);
        }
    }

    public void setMovieList(List<Movie> movieList)
    {
        this.mMovieList.clear();
        this.mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed. If we don't call this, app will crash.
        notifyDataSetChanged();
    }
}


