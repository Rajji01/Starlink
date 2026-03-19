package com.starlink.backend.lld.district;

public class Movie {
    private int movieId;
    private String movieName;
    private int movieDuartion;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieDuartion() {
        return movieDuartion;
    }

    public void setMovieDuartion(int movieDuartion) {
        this.movieDuartion = movieDuartion;
    }

    public Movie(int movieId, String movieName, int movieDuartion) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDuartion = movieDuartion;
    }
}
