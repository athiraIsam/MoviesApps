package nami.apps.moviesapps.presenter;

import java.util.List;

import nami.apps.moviesapps.gson.Movie;
import nami.apps.moviesapps.contract.MovieMainContract;

public class MovieMainPresenter implements MovieMainContract.Presenter,MovieMainContract.Model.OnListener {
    //creating object of View interface
    private MovieMainContract.View mainView;

    //creating object of Model interface
    private MovieMainContract.Model model;

    public MovieMainPresenter(MovieMainContract.View mainView, MovieMainContract.Model model) {
        this.mainView = mainView;
        this.model = model;
    }

    @Override
    public void getPopularMovies() {
        this.model.getMovieResult(this);
    }


    @Override
    public void onSuccess(List<Movie> movies) {
        mainView.onSuccess(movies);
    }

    @Override
    public void onFailure(String error) {
        mainView.onFailure(error);
    }
}
