package View.SelectionView;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.CinemaControl.CinemaManager;
import Controller.MovieControl.MovieManager;
import Controller.MovieSessionControl.MovieSessionManager;
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

    public static Movie fullMoviePrompt() {
        System.out.println(ANSI_BLUE + "Enter 0 to return to main menu." + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Enter Movie Type: \n 1. 3D \n 2. Blockbuster \n 3. Normal" + ANSI_RESET);
        String movieType = sc.nextLine();
        if (movieType.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Title: " + ANSI_RESET);
        String movieTitle = sc.nextLine();
        if (movieTitle.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Rating: \n 1. G \n 2. PG \n 3. PG13 \n 4. NC16 \n 5. M18 \n 6. R21"
                + ANSI_RESET);
        String movieRating = sc.nextLine();
        if (movieRating.equals("0")) {
            return null;
        }
        System.out
                .println(ANSI_BLUE + "Enter Movie Status: \n 1. Coming Soon \n 2. Preview \n 3. Now Showing"
                        + ANSI_RESET);
        String movieStatus = sc.nextLine();
        if (movieStatus.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Synopsis: " + ANSI_RESET);
        String movieSynopsis = sc.nextLine();
        if (movieSynopsis.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Movie Director: " + ANSI_RESET);
        String movieDirector = sc.nextLine();
        if (movieDirector.equals("0")) {
            return null;
        }
        System.out.println(ANSI_BLUE + "Enter Number of Movie Casts: " + ANSI_RESET);
        ArrayList<String> movieCast = new ArrayList<String>();
        ArrayList<Review> reviewsDB = new ArrayList<Review>();
        int cast = sc.nextInt();
        sc.nextLine();
        if (cast == 0) {
            return null;
        }
        for (int i = 0; i < cast; i++) {
            System.out.println(ANSI_BLUE + "Enter Movie Cast: " + ANSI_RESET);
            String castName = sc.nextLine();
            movieCast.add(castName);
        }
        Movie newMovie = new Movie(movieType, movieTitle, movieStatus, movieSynopsis, movieDirector, movieCast,
                reviewsDB, movieRating);
        System.out.println();
        System.out.println(ANSI_RESET);
        return newMovie;
    }
    
}
