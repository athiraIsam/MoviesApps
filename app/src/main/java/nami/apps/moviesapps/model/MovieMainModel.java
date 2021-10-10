package nami.apps.moviesapps.model;

import nami.apps.moviesapps.gson.Movie;
import nami.apps.moviesapps.service.MoviesApiServices;
import nami.apps.moviesapps.contract.MovieMainContract;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MovieMainModel implements MovieMainContract.Model {

    OnListener mListener;
    @Override
    public void getMovieResult(OnListener listener) {
        this.mListener = listener;
        getMoviesList();
    }

    public void getMoviesList()
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.themoviedb.org/3")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api_key", "ba0b538cb7dccb78c425120cc7a2a40a");
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MoviesApiServices service = restAdapter.create(MoviesApiServices.class);
        service.getPopularMovies(new Callback<Movie.MovieResult>() {
            @Override
            public void success(Movie.MovieResult movieResult, Response response) {
                mListener.onSuccess(movieResult.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                mListener.onFailure(error.toString());
            }
        });
    }
}
