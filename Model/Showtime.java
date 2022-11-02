package Model;

import java.util.*;

public class Showtime {
    // Movie object
    private Movie movie;
    // Cinema object
    private Cinema cinema;

    // movie date
    private String movieDate;
    // movie time
    private String movieTime;

    // create showtime constructor
    public Showtime(Movie movie, Cinema cinema, String movieDate, String movieTime) {
        this.movie = movie;
        this.cinema = cinema;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
    }

    // create movie getter
    public Movie getMovie() {
        return movie;
    }

    // create cinema getter
    public Cinema getCinema() {
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
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // create cinema setter
    public void setCinema(Cinema cinema) {
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
