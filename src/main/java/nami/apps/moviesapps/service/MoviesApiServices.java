package nami.apps.moviesapps.service;

import nami.apps.moviesapps.gson.GetMovieResponse;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;

public interface MoviesApiServices {
    @GET("/movie/popular")
    void getPopularMovies(Callback<GetMovieResponse.MovieResult> cb);

    @GET("/movie/popular")
    void getPopularTotalPagesNumber(Callback<GetMovieResponse.GetPageNumber> cb);

    @GET("/movie/upcoming")
    void getUpcomingMovies(Callback<GetMovieResponse.MovieResult> cb);

    @GET("/movie/top_rated")
    void getTopRatedMovies(Callback<GetMovieResponse.MovieResult> cb);
    @GET("/movie/top_rated")
    void getTopRatedPagesNumber(Callback<GetMovieResponse.GetPageNumber> cb);
}
