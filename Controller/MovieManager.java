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
    public static void addMovie(ArrayList<Movie> movieDB, String movieType, String movieTitle, String movieCode,
            String movieRating,
            String movieStatus, String movieSynopsis,
            String movieDirector, String movieCast, String movieReview, String overallRating)
            throws SecurityException, ClassNotFoundException {
        int newID = movieDB.size() + 1;
        Movie movie = new Movie(newID, movieType, movieTitle, movieCode, movieRating, movieStatus, movieSynopsis,
                movieDirector,
                movieCast, movieReview, overallRating);
        movieDB.add(movie);
        String filename = "movie.txt";
        try {
            // read file containing Professor records.
            movieDB = DatabaseManager.readCSV(filename, "movie");
            for (int i = 0; i < movieDB.size(); i++) {
                // put record into arraylist
                movieDB.add(movieDB.get(i));

            }
            // write Professor record/s to file.
            DatabaseManager.saveArray(filename, movieDB);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
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

}
