package nami.apps.moviesapps.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import nami.apps.moviesapps.gson.Movie;
import nami.apps.moviesapps.R;
import nami.apps.moviesapps.adapter.MovieListAdapter;
import nami.apps.moviesapps.contract.MovieMainContract;
import nami.apps.moviesapps.model.MovieMainModel;
import nami.apps.moviesapps.presenter.MovieMainPresenter;

public class MovieMainActivity extends AppCompatActivity implements MovieMainContract.View {

    RecyclerView mRecyclerView;
    MovieMainPresenter presenter;
    private MovieListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter = new MovieListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        presenter = new MovieMainPresenter(this,new MovieMainModel());
        presenter.getPopularMovies();
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        mAdapter.setMovieList(movies);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}
