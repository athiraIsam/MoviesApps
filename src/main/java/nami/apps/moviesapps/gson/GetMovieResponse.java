package nami.apps.moviesapps.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMovieResponse {

    public static final String TMDB_IMAGE_PATH = "https://image.tmdb.org/t/p/w500";


    public GetMovieResponse() {}

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("overview")
    private String description;

    @SerializedName("backdrop_path")
    private String backdrop;

    @SerializedName("release_date")
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return TMDB_IMAGE_PATH + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackdrop() {
        return TMDB_IMAGE_PATH  + backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public static  class GetPageNumber
    {
        @SerializedName("total_pages")
        private String totalPages;

        public String getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(String totalPages) {
            this.totalPages = totalPages;
        }
    }
    public static class MovieResult {
        private List<GetMovieResponse> results;

        public List<GetMovieResponse> getResults() {
            return results;
        }

        public GetPageNumber pageNumber;

        public GetPageNumber getPageNumber() {
            return pageNumber;
        }
    }
}
