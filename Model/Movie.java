package Model;

import java.io.Serializable;
import java.util.*;

public class Movie implements Serializable {
    private int movieID;
    // create movie type
    private String movieType;
    // create movie name
    private String movieTitle;
    // create movie status
    private String movieStatus;
    // create movie synopsis
    private String movieSynopsis;
    // create movie director
    private String movieDirector;
    // create movie cast
    private ArrayList<String> movieCast;
    // create movie rating
    private String movieRating;
    // create movie code
    private String movieCode;

    // create movie constructor

    public Movie(String movieType, String movieTitle, String movieCode, String movieRating,
            String movieStatus,
            String movieSynopsis,
            String movieDirector, ArrayList<String> movieCast) {
        this.movieType = movieType;
        this.movieTitle = movieTitle;
        this.movieCode = movieCode;
        this.movieRating = movieRating;
        this.movieStatus = movieStatus;
        this.movieSynopsis = movieSynopsis;
        this.movieDirector = movieDirector;
        this.movieCast = movieCast;

    }

    // create movie rating getter
    public String getMovieRating() {
        return movieRating;
    }

    // create movie rating setter
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
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

}
