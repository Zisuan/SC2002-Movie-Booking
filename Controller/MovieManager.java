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
            String movieDirector, String movieCast, String movieReview, String overallRating) {
        int newID = movieDB.size() + 1;
        Movie movie = new Movie(newID, movieType, movieTitle, movieCode, movieRating, movieStatus, movieSynopsis,
                movieDirector,
                movieCast, movieReview, overallRating);
        movieDB.add(movie);
        MovieManager txtDB = new MovieManager(newID, overallRating, overallRating, overallRating, overallRating,
                overallRating, overallRating, overallRating, overallRating, overallRating, overallRating);
        String filename = "movie.txt";
        try {
            // read file containing Professor records.
            ArrayList al = DatabaseManager.readArray(filename);
            for (int i = 0; i < al.size(); i++) {
                Movie moviee = (Movie) al.get(i);
            }
            // al is an array list containing Professor objs
            al.add(movie);
            // write Professor record/s to file.
            DatabaseManager.saveArray(filename, al);
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
