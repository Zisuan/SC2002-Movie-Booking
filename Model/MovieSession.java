package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import Controller.SeatControl.SeatManager;

public class MovieSession implements Serializable {
    // Movie object
    private Movie movie;
    // Cinema object
    private Cinema cinema;

    // movie date
    private LocalDate movieDate;
    // movie time
    private String movieTime;

    private ArrayList<Seat> sessionSeats;

    // create showtime constructor
    public MovieSession(Movie movie, Cinema cinema, LocalDate movieDate, String movieTime,
            ArrayList<Seat> sessionSeats) {
        this.movie = movie;
        this.cinema = cinema;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
        this.sessionSeats = sessionSeats;

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
    public LocalDate getMovieDate() {
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
    public void setMovieDate(LocalDate movieDate) {
        this.movieDate = movieDate;

    }

    // create movie time setter
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public ArrayList<Seat> getSessionSeats() {
        return sessionSeats;
    }

    public void setSessionSeats(ArrayList<Seat> sessionSeats) {
        this.sessionSeats = sessionSeats;
    }

    // to string method
    public String toString() {
        return "Movie Session Movie: " + getMovie().getMovieTitle() + "\n" +
                "Movie Session Cinema: " + getCinema().getCinemaName() + "\n" +
                "Movie Session Date: " + getMovieDate() + "\n" +
                "Movie Session Time: " + getMovieTime() + "\n" +
                "Movie Session Seats: \n" + SeatManager.getSessionSeatsInGrid(getSessionSeats());
    }

}
