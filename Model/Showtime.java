package Model;

import java.util.*;

public class Showtime {
    // Movie object
    private String movie;
    // Cinema object
    private String cinema;

    // movie date
    private String movieDate;
    // movie time
    private String movieTime;

    // create showtime constructor
    public Showtime(String movie, String cinema, String movieDate, String movieTime) {
        this.movie = movie;
        this.cinema = cinema;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
    }

    // create movie getter
    public String getMovie() {
        return movie;
    }

    // create cinema getter
    public String getCinema() {
        return cinema;
    }

    // create movie date getter
    public String getMovieDate() {
        return movieDate;
    }

    // create movie time getter
    public String getMovieTime() {
        return movieTime;
    }

    // create movie setter
    public void setMovie(String movie) {
        this.movie = movie;
    }

    // create cinema setter
    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    // create movie date setter
    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    // create movie time setter
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
}
