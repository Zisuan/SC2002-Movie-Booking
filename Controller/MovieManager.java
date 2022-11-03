package Controller;

import java.io.IOException;
import java.util.*;

import Model.Movie;
import Model.MovieSession;

public class MovieManager {

    // add movie
    public void addMovie(ArrayList<Movie> movieDB, String movieType, String movieTitle, String movieRating,
            String movieCode,
            String movieStatus, String movieSynopsis,
            String movieDirector,
            ArrayList<String> movieCast)
            throws SecurityException, ClassNotFoundException {
        Movie newMovie = new Movie(movieType, movieTitle, movieRating, movieCode, movieStatus,
                movieSynopsis, movieDirector, movieCast);
        boolean exists = false;
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(movieCode)) {
                System.out.println("Movie code already exists");
                exists = true;
                break;
            }
        }
        if (!exists) {
            movieDB.add(newMovie);
        }
    }

    // update movie
    public static void updateMovie(int updateCase, ArrayList<Movie> movieDB, String movieCode, String updateVariable,
            ArrayList<String> movieCast) {
        {
            switch (updateCase) {
                case 1:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieType(updateVariable);
                            break;
                        }
                    }
                    break;
                case 2:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieName(updateVariable);
                            break;
                        }
                    }
                    break;
                case 3:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieCode(updateVariable);
                            break;
                        }
                    }
                    break;
                case 4:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieRating(updateVariable);
                            break;
                        }
                    }
                    break;
                case 5:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieStatus(updateVariable);
                            break;
                        }
                    }
                    break;
                case 6:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieSynopsis(updateVariable);
                            break;
                        }
                    }
                    break;
                case 7:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieDirector(updateVariable);
                            break;
                        }
                    }
                    break;
                case 8:
                    for (Movie movie : movieDB) {
                        if (movie.getMovieCode().equals(movieCode)) {
                            movie.setMovieCast(movieCast);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void updateWholeMovie(int updateCase, String OGmovieCode, ArrayList<Movie> movieDB, String movieType,
            String movieTitle, String movieCode, String movieRating,
            String movieStatus, String movieSynopsis,
            String movieDirector, ArrayList<String> movieCast) {

        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(OGmovieCode)) {
                movie.setMovieType(movieType);
                movie.setMovieName(movieTitle);
                movie.setMovieCode(movieCode);
                movie.setMovieRating(movieRating);
                movie.setMovieStatus(movieStatus);
                movie.setMovieSynopsis(movieSynopsis);
                movie.setMovieDirector(movieDirector);
                movie.setMovieCast(movieCast);
                break;
            }
        }

    }

    // remove movie
    public static void removeMovie(ArrayList<Movie> movieDB, String movieCode) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(movieCode)) {
                movieDB.remove(movie);
                break;
            }
        }
    }

    // search movie
    public Movie searchMovie(ArrayList<Movie> movieSessionDB, String movieName) {
        for (Movie movie : movieSessionDB) {
            if (movie.getMovieName().equals(movieName)) {
                System.out.println("Movie exists");
                return movie;
            }
        }
        System.out.println("Movie does not exist");
        return null;

    }

    // select movie
    public static String selectMovie(ArrayList<Movie> movieDB) {
        printMovieTitles(movieDB);
        String selectedMovie = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String movieTitle = sc.nextLine();
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(movieTitle)) {
                selectedMovie = movie.getMovieName();
                break;
            }
        }
        return selectedMovie;
    }

    // print movies
    public static void printMovie(Movie movie) {
        System.out.println("Movie Type: " + movie.getMovieType());
        System.out.println("Movie Title: " + movie.getMovieName());
        System.out.println("Movie Code: " + movie.getMovieCode());
        System.out.println("Movie Status: " + movie.getMovieStatus());
        System.out.println("Movie Synopsis: " + movie.getMovieSynopsis());
        System.out.println("Movie Director: " + movie.getMovieDirector());
        System.out.println("Movie Cast: " + movie.getMovieCast());
    }

    public void printMovies(ArrayList<Movie> movieDB) {
        for (int i = 0; i < movieDB.size(); i++) {
            printMovie(movieDB.get(i));
            System.out.println();
        }
    }

    // print movie details by movie title
    public static void printMovieDetails(ArrayList<Movie> movieDB, String movieName) {
        for (Movie movie : movieDB) {
            if (movie.getMovieName().equals(movieName)) {
                System.out.println("Movie Type: " + movie.getMovieType());
                System.out.println("Movie Title: " + movie.getMovieName());
                System.out.println("Movie Code: " + movie.getMovieCode());
                System.out.println("Movie Status: " + movie.getMovieStatus());
                System.out.println("Movie Synopsis: " + movie.getMovieSynopsis());
                System.out.println("Movie Director: " + movie.getMovieDirector());
                System.out.println("Movie Cast: " + movie.getMovieCast());
                break;
            }
        }
    }

    // print movie titles
    public static void printMovieTitles(ArrayList<Movie> movieDB) {
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(i + 1 + "." + movieDB.get(i).getMovieName());
        }
    }

    public void saveMovie(String filename, ArrayList<Movie> movieDB) throws IOException {
        DatabaseManager.writeSerializedObject(filename, movieDB);

    }

    public ArrayList<Movie> loadMovie(String filename)
            throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<Movie> movieDB = DatabaseManager.readSerializedObject(filename);
        if (movieDB == null) {
            movieDB = new ArrayList<Movie>();
        }
        return movieDB;
    }
}
