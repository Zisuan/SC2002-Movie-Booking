package View.ShowtimeView;

import java.util.*;
import java.io.IOException;
import java.time.LocalDate;

import Controller.CinemaControl.CinemaManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;
import Model.Movie;
import Model.MovieSession;
import Model.Seat;
import View.SelectionView.SelectionView;
import Model.Cinema;

public class CreateShowTime {

    public static final Scanner sc = new Scanner(System.in);

    public static void CreateShowTime(MovieSessionManager msm, MovieManager mm, CinemaManager cm, SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
        ArrayList<Movie> movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        movieDB = mm.filterMovieByBookableStatus(movieDB);
        ArrayList<Cinema> cinemaDB = cm.loadObjects(DatabaseFilePath.Cinemas.getFilePath());
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                        Create New Show Time                       ");
        System.out.println("=====================================================================" + ANSI_RESET);
        MovieSession movieSession = fullMovieSessionPrompt(movieDB, cinemaDB, sm);
        if (movieSession == null) {
            System.out.println(ANSI_BLUE + "Showtime creation cancelled" + ANSI_RESET);
            return;
        }
        msm.addMovieSession(movieSessionDB, movieSession);
        msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
        System.out.println(ANSI_BLUE + "Showtime Listing for " + movieSession.getMovie().getMovieTitle() + " Created!"
                + ANSI_RESET);

    }

    public static MovieSession fullMovieSessionPrompt(ArrayList<Movie> movieDB, ArrayList<Cinema> cinemaDB,
            SeatManager sm) throws IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int exit = 0;
        Movie movie = null;
        Cinema cinema = null;
        do {
            System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Choose a movie: " + ANSI_RESET);
            MovieManager.printMovieTitlesAndCode(movieDB);
            // sc.nextLine();
            String movieIndex = sc.nextLine();
            if (movieIndex.equals("0")) {
                exit = 1;
                break;
            }
            movie = MovieManager.getMovieByIndex(movieDB, movieIndex);
        } while (movie == null);
        if (exit == 1) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter New Showtime Date: (YYYY-MM-DD)" + ANSI_RESET);
        String movieDate = sc.nextLine();
        if (movieDate.equals("0")) {
            return null;
        }
        LocalDate showtimeDate = LocalDate.parse(movieDate);
        System.out.print(ANSI_BLUE + "Enter New Showtime Timing: " + ANSI_RESET);
        String movieTime = sc.nextLine();
        if (movieTime.equals("0")) {
            return null;
        }

        cinema = SelectionView.chooseACinema(cinemaDB);
        System.out.println(ANSI_BLUE + "Please enter the number of available seating for this showtime: " + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter number of rows: " + ANSI_RESET);
        int rows = sc.nextInt();
        if (rows == 0) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter number of columns: " + ANSI_RESET);
        int cols = sc.nextInt();
        sc.nextLine();
        if (cols == 0) {
            return null;
        }
        ArrayList<Seat> sessionSeatsDB = sm.generateSeats(rows, cols, cinema);

        MovieSession movieSession = new MovieSession(movie, cinema, showtimeDate, movieTime, sessionSeatsDB);
        return movieSession;
    }

}
