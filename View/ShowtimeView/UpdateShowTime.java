package View.ShowtimeView;

import java.util.*;

import Controller.CinemaControl.CinemaManager;
import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.SeatControl.SeatManager;
import Model.Cinema;
import Model.Movie;
import Model.MovieSession;

import java.io.IOException;
import java.time.LocalDate;

public class UpdateShowTime {

    public static final Scanner sc = new Scanner(System.in);

    public static void updateShowTime(MovieSessionManager msm, CinemaManager cm, MovieManager mm, SeatManager sm)
            throws SecurityException, ClassNotFoundException, IOException {
        // update show time
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        ArrayList<MovieSession> movieSessionDB = msm.loadObjects(DatabaseFilePath.MovieSessions.getFilePath());
        ArrayList<Cinema> cinemaDB = cm.loadObjects(DatabaseFilePath.Cinemas.getFilePath());
        ArrayList<Movie> movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        System.out.println(
                ANSI_BLUE + "=====================================================================");
        System.out.println("                      Update Show Time Listing                     ");
        System.out.println("=====================================================================" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
        Movie movie = CreateShowTime.chooseAMovie(movieDB);
        if (movie == null) {
            System.out.println(ANSI_BLUE + "Showtime update cancelled" + ANSI_RESET);
            return;
        }
        ArrayList<MovieSession> movieSessionsByMovie = msm.filterSessionsByMovie(movieSessionDB, movie);
        if (movieSessionsByMovie.size() == 0) {
            System.out.println(ANSI_BLUE + "No showtime listing for " + movie.getMovieTitle() + " found!" + ANSI_RESET);
            return;
        }
        MovieSession movieSession = chooseAShowtime(movieSessionsByMovie, msm);
        System.out.println(ANSI_BLUE + "Select Update case");
        System.out.println("1. Update Movie Date");
        System.out.println("2. Update Movie Time");
        System.out.println("3. Update Movie Cinema");
        System.out.println("4. Update All");
        System.out.println("5. Back");
        System.out.println("Option: " + ANSI_RESET);
        int updateCase = sc.nextInt();
        sc.nextLine();
        switch (updateCase) {
            case 1:
                System.out.println(ANSI_BLUE + "Enter New Showtime Date: (YYYY-MM-DD)" + ANSI_RESET);
                String movieDate = sc.nextLine();
                LocalDate showtimeDate = LocalDate.parse(movieDate);
                movieSession.setMovieDate(showtimeDate);
                System.out.println(ANSI_BLUE + "Showtime Date Updated!" + ANSI_RESET);
                break;
            case 2:
                System.out.print(ANSI_BLUE + "Enter New Showtime Timing: " + ANSI_RESET);
                String movieTime = sc.nextLine();
                movieSession.setMovieTime(movieTime);
                System.out.println(ANSI_BLUE + "Showtime Time Updated!" + ANSI_RESET);
                break;
            case 3:
                Cinema cinema = CreateShowTime.chooseACinema(cinemaDB);
                movieSession.setCinema(cinema);
                System.out.println(ANSI_BLUE + "Showtime Cinema Updated!" + ANSI_RESET);
                break;
            case 4:
                CreateShowTime.fullMovieSessionPrompt(movieDB, cinemaDB, sm);
                break;
            case 5:
                break;
            default:
                System.out.println(ANSI_BLUE + "Invalid Option" + ANSI_RESET);
                break;
        }
        msm.saveObjects(DatabaseFilePath.MovieSessions.getFilePath(), movieSessionDB);
        // case options for update
        // System.out.println("Showtime Listing for " + showtimeMovie + " Updated!");
    }

    public static MovieSession chooseAShowtime(ArrayList<MovieSession> movieSessionsByMovie, MovieSessionManager msm) {
        MovieSession movieSession = null;
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
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