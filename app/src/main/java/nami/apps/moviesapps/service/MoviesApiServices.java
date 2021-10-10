package nami.apps.moviesapps.service;

import nami.apps.moviesapps.gson.Movie;
import retrofit.Callback;
import retrofit.http.GET;

public interface MoviesApiServices {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.MovieResult> cb);

    @GET("/movie/upcoming")
    void getUpcomingMovies(Callback<Movie.MovieResult> cb);
}
