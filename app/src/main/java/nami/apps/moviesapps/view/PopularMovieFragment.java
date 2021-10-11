package nami.apps.moviesapps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nami.apps.moviesapps.R;
import nami.apps.moviesapps.adapter.MovieListAdapter;
import nami.apps.moviesapps.contract.PopularMoviesContract;
import nami.apps.moviesapps.gson.Movie;
import nami.apps.moviesapps.model.PopularMovieModel;
import nami.apps.moviesapps.presenter.PopularMoviePresenter;

public class PopularMovieFragment extends Fragment implements PopularMoviesContract.View {

    RecyclerView mRecyclerView;
    PopularMoviePresenter presenter;
    private MovieListAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_movies,container,false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mAdapter = new MovieListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);

        presenter = new PopularMoviePresenter(this,new PopularMovieModel());
        presenter.getPopularMovies();


    }

    @Override
    public void onSuccess(List<Movie> movies) {
        mAdapter.setMovieList(movies);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }
}
