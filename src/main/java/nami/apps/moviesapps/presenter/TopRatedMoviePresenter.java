package nami.apps.moviesapps.presenter;

import java.util.List;

import nami.apps.moviesapps.contract.TopRatedMoviesContract;
import nami.apps.moviesapps.gson.GetMovieResponse;

public class TopRatedMoviePresenter implements TopRatedMoviesContract.Presenter, TopRatedMoviesContract.Model.OnListener {
    //creating object of View interface
    private TopRatedMoviesContract.View mainView;

    //creating object of Model interface
    private TopRatedMoviesContract.Model model;

    public TopRatedMoviePresenter(TopRatedMoviesContract.View mainView, TopRatedMoviesContract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void getTopRatedMovies() {
        this.model.getMovieList(this);
    }


    @Override
    public void onSuccess(List<GetMovieResponse> getMovieResponses) {
        mainView.onSuccess(getMovieResponses);

    }

    @Override
    public void onFailure(String error) {
        mainView.onFailure(error);
    }

    @Override
    public void totalPageNumber(String pageNumber) {
        this.mainView.totalPageNumber(pageNumber);
    }

    @Override
    public void updateTopRatedMovies(String pageNumber) {
       this.model.setPageNumber(pageNumber);
       this.model.getMovieList(this);
    }
}
