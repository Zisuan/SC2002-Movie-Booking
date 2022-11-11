package View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Model.Cinema;
import Model.Movie;
import Model.MovieSession;

public class CheckSeatAvailability {
        // TODO : Put boooking after showing seat availabilty.
        // TODO : Not showing all the movies and showtime seats.
        final static String ANSI_BLUE = "\u001B[34m";
        final static String ANSI_RESET = "\u001B[0m";
        public static final Scanner sc = new Scanner(System.in);
        private static String dbPath = DatabaseFilePath.MovieSessions.getFilePath();

        public static void checkSeatAvailability(MovieManager mm, MovieSessionManager msm)
                        throws IOException, ClassNotFoundException {
                ArrayList<Movie> movieDB = new ArrayList<Movie>();
                ArrayList<MovieSession> movieSessionDB = new ArrayList<MovieSession>();
                ArrayList<MovieSession> selectedMovieSessionDB = new ArrayList<MovieSession>();
                ArrayList<Cinema> cinemaDB = new ArrayList<Cinema>();
                movieSessionDB = msm.loadObjects(dbPath);
                System.out.println(
                                ANSI_BLUE + "=====================================================================");
                System.out.println("                      Check Seat Availability                        ");
                System.out.println("=====================================================================");
                System.out.println("Please select the movie you want to check the seat availability for:" + ANSI_RESET);
                movieDB = msm.getMoviesInSession(movieSessionDB, mm);
                if (movieDB.size() == 0) {
                        System.out.println(ANSI_BLUE + "There are no movies in session at the moment.");
                        System.out.println("Please come back later.");
                        System.out.println("Press enter to return to main menu." + ANSI_RESET);
                        sc.nextLine();
                        return;
                }
                mm.printMovieTitles(movieDB);
                // mm.printMovies(movieDB);
                String movieIndex = sc.nextLine();
                Movie selectedMovie = mm.getMovieByIndex(movieDB, movieIndex);
                // cinemaDB = msm.getCinemafilterSessionsByMovie(movieSessionDB, selectedMovie);
                ArrayList<MovieSession> listOfSessionsInCinemaWithMovie = new ArrayList<MovieSession>();
                listOfSessionsInCinemaWithMovie = msm.filterSessionsByMovie(movieSessionDB,
                                selectedMovie);
                // System.out.println(
                // ANSI_BLUE + "Please select the cinema you want to check the seat availability
                // for:"
                // + ANSI_RESET);
                // msm.printCinemas(cinemaDB);
                System.out.println(ANSI_BLUE + "Please select the showtime you want to check the seat"
                                + " availability for:" + ANSI_RESET);
                msm.printAll(listOfSessionsInCinemaWithMovie);
                String showtimeIndex = sc.nextLine();
                // Cinema selectedCinema = cinemaDB.get(Integer.parseInt(showtimeIndex) - 1);
                MovieSession selectedMovieSession = listOfSessionsInCinemaWithMovie
                                .get(Integer.parseInt(showtimeIndex) - 1);
                System.out.println(ANSI_BLUE + "The seat availability for the selected showtime is:"
                                + ANSI_RESET);

                // System.out.println(
                // ANSI_BLUE + "Please select the date you want to check the seat availability
                // for:"
                // + ANSI_RESET);
                // selectedMovieSessionDB = msm.filterSessionsByMovieAndCinema(movieSessionDB,
                // selectedMovie.getMovieTitle(),
                // selectedCinema.getCinemaCode());
                // msm.printShowtimes(selectedMovieSessionDB);
                // String showtime = sc.nextLine();
                // MovieSession seletedShowtime = msm.getMovieSession(selectedMovieSessionDB,
                // Integer.parseInt(showtime));
                msm.printSessionSeats(selectedMovieSession);

        }
}