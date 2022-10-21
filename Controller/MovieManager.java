package Controller;

import java.util.*;

import Model.Movie;

public class MovieManager extends Movie {

    // add movie
    public static void addMovie(ArrayList<Movie> movieDB, String movieType, String movieTitle, String movieRating,
            String movieStatus, String movieSynopsis,
            String movieDirector, String[] movieCast, String movieReview, String overallRating) {
        int newID = movieDB.size() + 1;
        Movie movie = new Movie(newID, movieType, movieTitle, movieRating, movieStatus, movieSynopsis, movieDirector,
                movieCast, movieReview, overallRating);
        movieDB.add(movie);
    }

    // update movie
    public static void updateMovie() {

    }

    // remove movie
    public static void removeMovie() {
        Scanner sc = new Scanner(System.in);
        String movieType, movieName, movieRating, movieStatus;
        System.out.println("Enter movie type: ");
        movieType = sc.nextLine();
        System.out.println("Enter movie name: ");
        movieName = sc.nextLine();
        System.out.println("Enter movie rating: ");
        movieRating = sc.nextLine();
        System.out.println("Enter movie status: ");
        movieStatus = sc.nextLine();
        // Movie movie = new Movie(movieType, movieName, movieRating, movieStatus);
        System.out.println("Movie removed successfully");
        sc.close();
    }
}
