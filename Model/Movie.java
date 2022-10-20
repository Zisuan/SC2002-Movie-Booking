package Model;

import java.util.*;

public class Movie {

    // create movie type
    private String movieType;
    // create movie name
    private String movieTitle;
    // create movie rating
    private String movieRating;
    // create movie status
    private String movieStatus;
    // create movie synopsis
    private String movieSynopsis;
    // create movie director
    private String movieDirector;
    // create movie cast
    private String[] movieCast;
    // create movie review
    private String movieReview;
    // create overall rating
    private String overallRating;

    // create movie constructor
    public Movie(String movieType, String movieTitle, String movieRating, String movieStatus, String movieSynopsis,
            String movieDirector, String[] movieCast, String movieReview, String overallRating) {
        this.movieType = movieType;
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;
        this.movieReview = movieReview;
        this.overallRating = overallRating;
    }

    // create movie type getter
    public String getMovieType() {
        return movieType;
    }

    // create movie type setter
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    // create movie name getter
    public String getMovieName() {
        return movieTitle;
    }

    // create movie name setter
    public void setMovieName(String movieName) {
        this.movieTitle = movieName;
    }

    // create movie rating getter
    public String getMovieRating() {
        return movieRating;
    }

    // create movie rating setter
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    // create movie status getter
    public String getMovieStatus() {
        return movieStatus;
    }

    // create movie status setter
    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    // create movie synopsis getter
    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    // create movie synopsis setter
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    // create movie director getter
    public String getMovieDirector() {
        return movieDirector;
    }

    // create movie director setter
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    // create movie cast getter
    public String[] getMovieCast() {
        return movieCast;
    }

    // create movie cast setter
    public void setMovieCast(String[] movieCast) {
        this.movieCast = movieCast;
    }

    // create movie review getter
    public String getMovieReview() {
        return movieReview;
    }

    // create movie review setter
    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    // create overall rating getter
    public String getOverallRating() {
        return overallRating;
    }

    // create overall rating setter
    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }
}
