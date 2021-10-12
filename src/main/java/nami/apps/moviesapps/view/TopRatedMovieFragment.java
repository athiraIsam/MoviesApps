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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import nami.apps.moviesapps.R;
import nami.apps.moviesapps.adapter.MovieListAdapter;
import nami.apps.moviesapps.adapter.PaginationAdapter;
import nami.apps.moviesapps.contract.TopRatedMoviesContract;
import nami.apps.moviesapps.gson.GetMovieResponse;
import nami.apps.moviesapps.model.TopRatedMovieModel;
import nami.apps.moviesapps.presenter.TopRatedMoviePresenter;

public class TopRatedMovieFragment extends Fragment implements TopRatedMoviesContract.View,PaginationAdapter.PageinationOnListerner{

    RecyclerView mMovieRv,mPaginationRv;
    TopRatedMoviePresenter presenter;
    private MovieListAdapter mMovieAdapter;
    private PaginationAdapter mPaginationAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_rated_movies,container,false);
        mMovieRv = view.findViewById(R.id.recyclerView);
        mPaginationRv = view.findViewById(R.id.pageNumber);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mMovieRv.setLayoutManager(new GridLayoutManager(getContext(),2));
        mMovieAdapter = new MovieListAdapter(getContext());
        mMovieRv.setAdapter(mMovieAdapter);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);

        mPaginationRv.setLayoutManager(layoutManager);
        mPaginationAdapter = new PaginationAdapter(getContext());
        mPaginationRv.setAdapter(mPaginationAdapter);
        mPaginationAdapter.setOnPaginationListener(this);

        presenter = new TopRatedMoviePresenter(this,new TopRatedMovieModel());
        presenter.getTopRatedMovies();

    }

    @Override
    public void onSuccess(List<GetMovieResponse> getMovieResponses) {
        mMovieAdapter.setMovieList(getMovieResponses);

    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void totalPageNumber(String pageNumber) {
        setTotalPageNumber(pageNumber);
    }


    private void setTotalPageNumber (String totalPage)
    {
        List<String> allPageNumber = new ArrayList<>();

        if(totalPage!=null) {
            for (int i = 1; i <= Integer.parseInt(totalPage); i++) {
                allPageNumber.add(String.valueOf(i));
            }
            mPaginationAdapter.setListPageNumber(allPageNumber);
        }
    }

    @Override
    public void onClick(int position) {
        presenter.updateTopRatedMovies(String.valueOf(position+1));
    }
}
