package nami.apps.moviesapps.contract;

import java.util.List;

import nami.apps.moviesapps.gson.Movie;

public interface MovieMainContract {

    interface View
    {
        void onSuccess(List<Movie> movies);
        void onFailure(String error);
    }
    interface Model
    {
        interface OnListener {
            void onSuccess(List<Movie> movies);
            void onFailure (String error);
        }
        void getMovieResult(Model.OnListener listener);
    }
    interface Presenter
    {
       void getPopularMovies();
    }

}
