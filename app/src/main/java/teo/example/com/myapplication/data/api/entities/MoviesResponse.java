package teo.example.com.myapplication.data.api.entities;


import com.google.gson.annotations.SerializedName;

import teo.example.com.myapplication.data.api.MoviesService;

/**
 * Models the response of GET "/movies/popular" service
 * from {@link MoviesService}.
 */

public class MoviesResponse  {

    private MoviesResponseNestedResults[] results;
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    public MoviesResponseNestedResults[] getResults() {
        return results;
    }

    public void setResults(MoviesResponseNestedResults[] results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}