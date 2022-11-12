package Controller.MovieControl;

import java.util.*;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieSessionControl.MovieSessionManager;
import Controller.ObjectControl.ObjectManager;
import Model.Movie;
import Model.MovieSession;
import Model.Review;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class MovieManager extends ObjectManager<Movie> {
    public static final Scanner sc = new Scanner(System.in);
    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_CYAN = "\u001B[36m";
    final static String ANSI_BLUE = "\u001B[34m";

    // add movie
    public void addMovie(ArrayList<Movie> movieDB, String movieType, String movieTitle,
            String movieStatus, String movieSynopsis,
            String movieDirector,
            ArrayList<String> movieCast, ArrayList<Review> reviewsDB, String movieRating)
            throws SecurityException, ClassNotFoundException {
        Movie newMovie = new Movie(movieType, movieTitle, movieStatus,
                movieSynopsis, movieDirector, movieCast, reviewsDB, movieRating);
        addObject(movieDB, newMovie);
    }

    public void addMovie(ArrayList<Movie> movieDB, Movie newMovie)
            throws SecurityException, ClassNotFoundException {
        addObject(movieDB, newMovie);
    }

    // update movie
    public static <T> void updateMovie(int updateCase, ArrayList<Movie> movieDB, Movie selectedMovie, T updateVariable,
            ArrayList<String> movieCast, ArrayList<MovieSession> movieSessionDB) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";

        switch (updateCase) {
            case 1:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieType((MovieType) updateVariable);
                        break;
                    }
                }
                break;
            case 2:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieTitle((String) updateVariable);
                        break;
                    }
                }
                break;
            case 3:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieCode((String) updateVariable);
                        break;
                    }
                }
                break;
            case 4:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieRating((String) updateVariable);
                        break;
                    }
                }
                break;
            case 5:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        if (movie.getMovieStatus() != MovieStatus.END_OF_SHOWING) {
                            movie.setMovieStatus((String) updateVariable);
                            break;
                        } else {
                            removeMovie(movieDB, selectedMovie);
                            break;
                        }
                    }
                }
                break;
            case 6:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieSynopsis((String) updateVariable);
                        break;
                    }
                }
                break;
            case 7:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieDirector((String) updateVariable);
                        break;
                    }
                }
                break;
            case 8:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                        movie.setMovieCast(movieCast);
                        break;
                    }
                }
                break;
            default:
                System.out.println(ANSI_BLUE + "Invalid option" + ANSI_RESET);
                break;
        }
        MovieSessionManager.updateMovieSession(3, movieSessionDB, selectedMovie.getMovieCode(), selectedMovie);

    }

    public void updateWholeMovie(ArrayList<Movie> movieDB, Movie updatedMovie, Movie oldMovie) {
        int i = 0;
        for (Movie movie : movieDB) {
            if (movie.equals(oldMovie)) {
                updatedMovie.setReviewsDB(oldMovie.getReviewsDB());
                movieDB.set(i, updatedMovie);
                break;
            }
            i++;
        }
    }

    // updateReviewsDB
    public void updateReviewsDB(ArrayList<Movie> movieDB, String movieTitle, ArrayList<Review> reviewsDB) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(movieTitle)) {
                movie.setReviewsDB(reviewsDB);
                break;
            }
        }
    }

    // remove movie
    public static void removeMovie(ArrayList<Movie> movieDB, Movie selectedMovie) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(selectedMovie.getMovieCode())) {
                movieDB.remove(movie);
                break;
            }
        }
    }

    // search movie
    public static Movie searchMovieByTitle(ArrayList<Movie> movieDB, String movieTitle) {
        for (Movie movie : movieDB) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieTitle)) {
                return movie;
            }
        }
        return null;

    }

    public static Movie searchMovieByCode(ArrayList<Movie> movieDB, String movieCode) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equalsIgnoreCase(movieCode)) {
                return movie;
            }
        }
        return null;

    }

    public static ArrayList<Movie> filterMovieByBookableStatus(ArrayList<Movie> movieDB) {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for (Movie movie : movieDB) {
            if (movie.getMovieStatus().equals(MovieStatus.PREVIEW)
                    || movie.getMovieStatus().equals(MovieStatus.NOW_SHOWING)) {
                movieList.add(movie);
            }
        }
        return movieList;
    }

    // // select movie
    // public static String selectMovie(ArrayList<Movie> movieDB) {
    // printMovieTitles(movieDB);
    // String selectedMovie = "";
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter movie title: ");
    // String movieTitle = sc.nextLine();
    // for (Movie movie : movieDB) {
    // if (movie.getMovieCode().equals(movieTitle)) {
    // selectedMovie = movie.getMovieTitle();
    // break;
    // }
    // }
    // return selectedMovie;
    // }

    // get movie reviews
    public ArrayList<Review> getReviews(ArrayList<Movie> movieDB, String movieTitle) {
        for (Movie movie : movieDB) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieTitle)) {
                return movie.getReviewsDB();
            }
        }
        return null;
    }

    public ArrayList<Review> getReviewsByCode(ArrayList<Movie> movieDB, Movie selectedMovie) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equalsIgnoreCase(selectedMovie.getMovieCode())) {
                return movie.getReviewsDB();
            }
        }
        return null;
    }

    // print movies
    public static void printMovie(Movie movie) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        System.out.println(ANSI_CYAN + "Movie Type: " + movie.getMovieType());
        System.out.println("Movie Title: " + movie.getMovieTitle());
        System.out.println("Movie Code: " + movie.getMovieCode());
        System.out.println("Movie Status: " + movie.getMovieStatus());
        System.out.println("Movie Synopsis: " + movie.getMovieSynopsis());
        System.out.println("Movie Director: " + movie.getMovieDirector());
        System.out.println("Movie Cast: " + movie.getMovieCast() + ANSI_RESET);
    }

    public static void printMovies(ArrayList<Movie> movieDB) {
        for (int i = 0; i < movieDB.size(); i++) {
            printMovie(movieDB.get(i));
            System.out.println();
        }
    }

    // print movie details by movie title
    public static void printMovieDetails(ArrayList<Movie> movieDB, String movieName) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        boolean movieExists = false;
        for (Movie movie : movieDB) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieName)) {
                System.out.println(ANSI_CYAN + movie.toString() + ANSI_RESET);
                movieExists = true;
                break;
            }
        }
        if (movieExists == false) {
            System.out.println(ANSI_CYAN + "Movie does not exist!" + ANSI_RESET);
        }
    }

    // print movie titles
    public static void printMovieTitles(ArrayList<Movie> movieDB) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(ANSI_CYAN + (i + 1) + ". " + movieDB.get(i).getMovieTitle() + ANSI_RESET);
        }
        if (movieDB.size() == 0) {
            System.out.println(ANSI_CYAN + "No movies available" + ANSI_RESET);
        }
    }

    public static void printMovieTitlesAndMovieTypes(ArrayList<Movie> movieDB) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(ANSI_CYAN + (i + 1) + ". " + movieDB.get(i).getMovieTitle() + "("
                    + movieDB.get(i).getMovieType() + ")" + ANSI_RESET);
        }
        if (movieDB.size() == 0) {
            System.out.println(ANSI_CYAN + "No movies available" + ANSI_RESET);
        }
    }

    public static void printMovieTitlesAndOverallRatings(ArrayList<Movie> movieDB) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieDB.size(); i++) {
            double overallRating = movieDB.get(i).getMovieOverallRating();
            if (overallRating > 0) {
                System.out.println(ANSI_CYAN + (i + 1) + ". " + movieDB.get(i).getMovieTitle() + " Overall Rating: "
                        + overallRating + ANSI_RESET);
            }
        }
        if (movieDB.size() == 0) {
            System.out.println(ANSI_CYAN + "No movies available" + ANSI_RESET);
        }
    }

    public static void printMovieTitlesAndSales(ArrayList<Movie> movieDB) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(
                    ANSI_CYAN + (i + 1) + ". " + movieDB.get(i).getMovieTitle() + "(" + movieDB.get(i).getTicketSales()
                            + " ticket(s) sold)" + ANSI_RESET);
        }
        if (movieDB.size() == 0) {
            System.out.println(ANSI_CYAN + "No movies available" + ANSI_RESET);
        }
    }

    // print movie titles + movie code
    public static void printMovieTitlesAndCode(ArrayList<Movie> movieDB) {

        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(ANSI_CYAN +
                    (i + 1) + ". " + movieDB.get(i).getMovieTitle() + " (" + movieDB.get(i).getMovieCode() + ")"
                    + ANSI_RESET);

        }
        if (movieDB.size() == 0) {
            System.out.println(ANSI_CYAN + "No movies available" + ANSI_RESET);
        }
    }

    // print movie titles + movie code + movie status
    public static void printMovieTitlesAndCodeAndStatus(ArrayList<Movie> movieDB) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(
                    ANSI_CYAN + (i + 1) + ". " + movieDB.get(i).getMovieTitle() + " (" + movieDB.get(i).getMovieCode()
                            + ") - " + movieDB.get(i).getMovieStatus() + ANSI_RESET);
        }
        if (movieDB.size() == 0) {
            System.out.println(ANSI_BLUE + "No movies available" + ANSI_RESET);
        }
    }

    @Override
    public boolean objectExists(ArrayList<Movie> objectDB, Movie object) {
        for (Movie movie : objectDB) {
            if (movie.getMovieCode().equals(object.getMovieCode())) {
                // System.out.println("Movie code already exists");
                return true;
            }
        }
        return false;
    }

    public static Movie getMovieByIndex(ArrayList<Movie> movieDB, String movieIndex) {
        return movieDB.get(Integer.parseInt(movieIndex) - 1);
    }

    public ArrayList<Movie> getMoviesByStatus(ArrayList<Movie> movieDB, MovieStatus movieStatus) {
        ArrayList<Movie> moviesByStatus = new ArrayList<>();
        for (Movie movie : movieDB) {
            if (movie.getMovieStatus().equals(movieStatus)) {
                moviesByStatus.add(movie);
            }
        }
        return moviesByStatus;
    }

    public void updateMovie(int select, ArrayList<Movie> movieDB, Movie selectedMovie, String movieType,
            Object object) {
    }

}
