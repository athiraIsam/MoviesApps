package nami.apps.moviesapps.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nami.apps.moviesapps.R;
import nami.apps.moviesapps.gson.GetMovieResponse;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView moviePoster;
    GetMovieResponse movie ;
    TextView movieTitle,movieReleaseDate,moviePopularity,movieVote,movieOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movie = new GetMovieResponse();
        moviePoster = findViewById(R.id.moviePoster);
        movieTitle = findViewById(R.id.movieTitle);
        movieReleaseDate = findViewById(R.id.movieReleaseDate);
        moviePopularity = findViewById(R.id.moviePopularity);
        movieVote = findViewById(R.id.movieVote);
        movieOverview = findViewById(R.id.movieOverview);

        if(getIntent()!=null)
        {
            movie.setPoster(getIntent().getStringExtra("moviePoster"));
            movie.setTitle(getIntent().getStringExtra("movieTitle"));
            movie.setReleaseDate(getIntent().getStringExtra("movieReleaseDate"));
            movie.setPopularity(getIntent().getStringExtra("moviePopularity"));
            movie.setVoteCount(getIntent().getStringExtra("movieVote"));
            movie.setOverview(getIntent().getStringExtra("movieOverview"));

         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 displayMovieDetails(movie);
             }
         });
        }


    }

    private void displayMovieDetails(GetMovieResponse movie)
    {
        if(movie!=null)
        {
            Picasso.with(this)
                    .load(movie.getPoster())
                    .placeholder(R.color.colorAccent)
                    .into(moviePoster);

            movieTitle.setText(movie.getTitle());
            movieReleaseDate.setText("Release Date: " + movie.getReleaseDate());
            moviePopularity.setText("Popularity: " + movie.getPopularity());
            movieVote.setText("Total Vote: " + movie.getVoteCount());
            movieOverview.setText(movie.getOverview());
        }
    }
}
