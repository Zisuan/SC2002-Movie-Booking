package Model;

import java.util.*;

public class Movie {
    private int movieID;
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
    private ArrayList<String> movieCast;
    // create movie review
    private String movieReview;
    // create overall rating
    private String overallRating;
    // create movie code
    private String movieCode;

    // create movie constructor

    public Movie(ArrayList<String> fieldTokens) {
        this.movieID = Integer.parseInt(fieldTokens.get(0));
        this.movieType = fieldTokens.get(1);
        this.movieTitle = fieldTokens.get(2);
        this.movieCode = fieldTokens.get(3);
        this.movieRating = fieldTokens.get(4);
        this.movieStatus = fieldTokens.get(5);
        this.movieSynopsis = fieldTokens.get(6);
        this.movieDirector = fieldTokens.get(7);
        this.movieReview = fieldTokens.get(8);
        this.overallRating = fieldTokens.get(9);
        this.movieCast = new ArrayList<String>();
        this.movieCast.add(fieldTokens.get(10));

    }

    public Movie(int movieID, String movieType, String movieTitle, String movieCode, String movieRating,
            String movieStatus,
            String movieSynopsis,
            String movieDirector, ArrayList<String> movieCast, String movieReview, String overallRating) {
        this.movieID = movieID;
        this.movieType = movieType;
        this.movieTitle = movieTitle;
        this.movieCode = movieCode;
        this.movieRating = movieRating;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;
        this.movieReview = movieReview;
        this.overallRating = overallRating;
    }

    // create movie code getter
    public String getMovieCode() {
        return movieCode;
    }

    // create movie code setter
    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
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
    public ArrayList<String> getMovieCast() {
        return movieCast;
    }

    // create movie cast setter
    public void setMovieCast(ArrayList<String> movieCast) {
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
