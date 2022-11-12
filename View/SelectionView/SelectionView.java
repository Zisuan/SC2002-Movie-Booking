package View.SelectionView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CinemaControl.CinemaManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;
import Model.Cinema;
import Model.Movie;
import Model.MovieSession;
import Model.Review;

public class SelectionView {
    private static final Scanner sc = new Scanner(System.in);
    private final static String ANSI_BLUE = "\u001B[34m";
    private final static String ANSI_RESET = "\u001B[0m";
    private final static String ANSI_CYAN = "\u001B[36m";

    public static Cinema chooseACinema(ArrayList<Cinema> cinemaDB) {

        Cinema cinema = null;
        do {
            System.out.println(ANSI_BLUE + "Enter Cinema Code: " + ANSI_RESET);
            CinemaManager.printCinemaTitlesAndCode(cinemaDB);
            String cinemaCode = sc.nextLine();
            cinemaCode = cinemaDB.get(Integer.parseInt(cinemaCode) - 1).getCinemaCode();
            cinema = CinemaManager.searchCinemaByCode(cinemaDB, cinemaCode);
        } while (cinema == null);
        return cinema;
    }

    public static Movie chooseAMovie(ArrayList<Movie> movieDB) {
        Movie movie = null;
        do {
            System.out.println(ANSI_BLUE + "Choose a movie: " + ANSI_RESET);
            MovieManager.printMovieTitlesAndCode(movieDB);
            String movieIndex = sc.nextLine();
            if (movieIndex.equals("0")) {
                break;
            }
            movie = MovieManager.getMovieByIndex(movieDB, movieIndex);
        } while (movie == null);
        return movie;
    }

    public static MovieSession chooseAShowtime(ArrayList<MovieSession> movieSessionsByMovie, MovieSessionManager msm) {
        MovieSession movieSession = null;
        do {
            // if no show time for movie

            System.out.println(ANSI_BLUE + "Choose a showtime: " + ANSI_RESET);
            msm.printShowtimes(movieSessionsByMovie);
            int showtimeID = sc.nextInt();
            if (showtimeID == 0) {
                break;
            }
            movieSession = movieSessionsByMovie.get(showtimeID - 1);

        } while (movieSession == null);
        return movieSession;
    }

}
