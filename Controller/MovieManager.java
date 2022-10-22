package Controller;

import java.io.IOException;
import java.util.*;

import Model.Movie;

public class MovieManager extends Movie {
    // create constructor
    public MovieManager(int movieID, String movieType, String movieTitle, String movieCode, String movieRating,
            String movieStatus, String movieSynopsis, String movieDirector, String movieCast, String movieReview,
            String overallRating) {
        super(movieID, movieType, movieTitle, movieCode, movieRating, movieStatus, movieSynopsis, movieDirector,
                movieCast,
                movieReview, overallRating);
    }

    // add movie
    public static void addMovie(ArrayList<Movie> movieDB, int movieID, String movieType, String movieTitle,
            String movieCode,
            String movieRating,
            String movieStatus, String movieSynopsis,
            String movieDirector, String movieCast, String movieReview, String overallRating)
            throws SecurityException, ClassNotFoundException {
        Movie newMovie = new Movie(movieID, movieType, movieTitle, movieCode, movieRating, movieStatus,
                movieSynopsis, movieDirector, movieCast, movieReview, overallRating);
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
    public static void updateMovie(int updateCase, ArrayList<Movie> movieDB, int movieID, String movieType,
            String movieTitle, String movieCode, String movieRating,
            String movieStatus, String movieSynopsis,
            String movieDirector, String movieCast, String movieReview, String overallRating) {
        switch (updateCase) {
            case 1:
                movieDB.get(movieID - 1).setMovieType(movieType);
                break;
            case 2:
                movieDB.get(movieID - 1).setMovieName(movieTitle);
                break;
            case 3:
                movieDB.get(movieID - 1).setMovieCode(movieCode);
                break;
            case 4:
                movieDB.get(movieID - 1).setMovieRating(movieRating);
                break;
            case 5:
                movieDB.get(movieID - 1).setMovieStatus(movieStatus);
                break;
            case 6:
                movieDB.get(movieID - 1).setMovieSynopsis(movieSynopsis);
                break;
            case 7:
                movieDB.get(movieID - 1).setMovieDirector(movieDirector);
                break;
            case 8:
                movieDB.get(movieID - 1).setMovieCast(movieCast);
                break;
            case 9:
                movieDB.get(movieID - 1).setMovieReview(movieReview);
                break;
            case 10:
                movieDB.get(movieID - 1).setOverallRating(overallRating);
                break;
            case 11:
                movieDB.get(movieID - 1).setMovieType(movieType);
                movieDB.get(movieID - 1).setMovieName(movieTitle);
                movieDB.get(movieID - 1).setMovieCode(movieCode);
                movieDB.get(movieID - 1).setMovieRating(movieRating);
                movieDB.get(movieID - 1).setMovieStatus(movieStatus);
                movieDB.get(movieID - 1).setMovieSynopsis(movieSynopsis);
                movieDB.get(movieID - 1).setMovieDirector(movieDirector);
                movieDB.get(movieID - 1).setMovieCast(movieCast);
                movieDB.get(movieID - 1).setMovieReview(movieReview);
                movieDB.get(movieID - 1).setOverallRating(overallRating);
                break;
        }

    }

    // remove movie
    public static void removeMovie(ArrayList<Movie> movieDB, int movieID) {
        movieDB.remove(movieID - 1);
    }

    // print movies
    public static void printMovie(Movie movie) {
        System.out.println("Movie Type: " + movie.getMovieType());
        System.out.println("Movie Title: " + movie.getMovieName());
        System.out.println("Movie Code: " + movie.getMovieCode());
        System.out.println("Movie Rating: " + movie.getMovieRating());
        System.out.println("Movie Status: " + movie.getMovieStatus());
        System.out.println("Movie Synopsis: " + movie.getMovieSynopsis());
        System.out.println("Movie Director: " + movie.getMovieDirector());
        System.out.println("Movie Cast: " + movie.getMovieCast());
        System.out.println("Movie Review: " + movie.getMovieReview());
        System.out.println("Overall Rating: " + movie.getOverallRating());
    }

    public void printMovies(ArrayList<Movie> movieDB) {
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println("Movie ID: " + (i + 1));
            printMovie(movieDB.get(i));
            System.out.println();
        }
    }

    public void saveMovie(String filename, ArrayList<Movie> movieDB) throws IOException {
        DatabaseManager.saveArray(filename, movieDB);

    }

    public ArrayList<Movie> loadMovie(String filename, String className)
            throws IOException, SecurityException, ClassNotFoundException {
        return DatabaseManager.readCSV(filename, "Model.Movie");
    }
}
