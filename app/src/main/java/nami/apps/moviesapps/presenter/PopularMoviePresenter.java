package nami.apps.moviesapps.presenter;

import java.util.List;

import nami.apps.moviesapps.gson.GetMovieResponse;
import nami.apps.moviesapps.contract.PopularMoviesContract;

public class PopularMoviePresenter implements PopularMoviesContract.Presenter, PopularMoviesContract.Model.OnListener {
    //creating object of View interface
    private PopularMoviesContract.View mainView;

    //creating object of Model interface
    private PopularMoviesContract.Model model;

    public PopularMoviePresenter(PopularMoviesContract.View mainView, PopularMoviesContract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void getPopularMovies() {
        this.model.getMovieList(this);
    }

    @Override
    public void updatePopularMovies(String pageNumber) {
        this.model.setPageNumber(pageNumber);
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


}
