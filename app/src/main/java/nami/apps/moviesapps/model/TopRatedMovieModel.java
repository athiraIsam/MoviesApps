package nami.apps.moviesapps.model;

import nami.apps.moviesapps.contract.TopRatedMoviesContract;
import nami.apps.moviesapps.gson.GetMovieResponse;
import nami.apps.moviesapps.service.MoviesApiServices;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TopRatedMovieModel implements TopRatedMoviesContract.Model {

    OnListener mListener;
    private RestAdapter restAdapter;
    private MoviesApiServices service;
    private String currentPageNumber;

    public TopRatedMovieModel() {

    }

    private void  initializeRetrofit ()
    {
        if(currentPageNumber==null)
            currentPageNumber = "1";

        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.themoviedb.org/3")
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api_key", "ba0b538cb7dccb78c425120cc7a2a40a");
                        request.addEncodedQueryParam("page",currentPageNumber);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        service = restAdapter.create(MoviesApiServices.class);
    }
    @Override
    public void getMovieList(OnListener listener) {
        this.mListener = listener;
         getTopRatedMoviesResult();

    }

    public void getTopRatedMoviesResult()
    {
        initializeRetrofit();

        service.getTopRatedMovies(new Callback<GetMovieResponse.MovieResult>() {
            @Override
            public void success(GetMovieResponse.MovieResult movieResult, Response response) {
                mListener.onSuccess(movieResult.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                mListener.onFailure(error.toString());
            }
        });

        service.getTopRatedPagesNumber(new Callback<GetMovieResponse.GetPageNumber>() {
            @Override
            public void success(GetMovieResponse.GetPageNumber getPageNumber, Response response) {
                mListener.totalPageNumber(getPageNumber.getTotalPages());
            }

            @Override
            public void failure(RetrofitError error) {
                mListener.onFailure(error.toString());
            }
        });
    }

    @Override
    public void setPageNumber(String pageNumber) {
        this.currentPageNumber = pageNumber;
    }

}
