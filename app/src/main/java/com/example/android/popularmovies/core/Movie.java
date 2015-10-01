package com.example.android.popularmovies.core;

public class Movie {

    private String originalTitle;
    private Integer posterImage;
    private String synopsis;
    private Integer userRating;
    private String releaseDate;

    public Movie() { }

    public Movie(String originalTitle, Integer posterImage, String synopsis, Integer userRating, String releaseDate) {
        this.originalTitle = originalTitle;
        this.posterImage = posterImage;
        this.synopsis = synopsis;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setPosterImage(Integer posterImage) {
        this.posterImage = posterImage;
    }

    public Integer getPosterImage() {
        return posterImage;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}
