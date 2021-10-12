package nami.apps.moviesapps.contract;

import java.util.List;

import nami.apps.moviesapps.gson.GetMovieResponse;

public interface PopularMoviesContract {

    interface View
    {
        void onSuccess(List<GetMovieResponse> getMovieResponses);
        void onFailure(String error);
        void totalPageNumber (String pageNumber);

    }
    interface Model
    {
        interface OnListener {
            void onSuccess(List<GetMovieResponse> getMovieResponses);
            void onFailure (String error);
            void totalPageNumber (String pageNumber);
        }
        void getMovieList(Model.OnListener listener);
        void setPageNumber(String pageNumber);


    }
    interface Presenter
    {
       void getPopularMovies();
        void updatePopularMovies(String pageNumber);
    }

}
