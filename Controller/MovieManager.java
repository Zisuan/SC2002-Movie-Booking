package Controller;

import java.util.*;

import Model.Movie;

public class MovieManager extends Movie {

    // create constructor
    public MovieManager(String movieType, String movieTitle, String movieRating, String movieStatus,
            String movieSynopsis,
            String movieDirector, String[] movieCast, String movieReview, String overallRating) {
        super(movieType, movieTitle, movieRating, movieStatus, movieSynopsis, movieDirector, movieCast, movieReview,
                overallRating);
    }

    // add movie
    public static void addMovie() {
        // create scanner
        Scanner sc = new Scanner(System.in);
        // create movie type
        System.out.println("Enter movie type: ");
        String movieType = sc.nextLine();
        // create movie name
        System.out.println("Enter movie name: ");
        String movieTitle = sc.nextLine();
        // create movie rating
        System.out.println("Enter movie rating: ");
        String movieRating = sc.nextLine();
        // create movie status
        System.out.println("Enter movie status: ");
        String movieStatus = sc.nextLine();
        // create movie synopsis
        System.out.println("Enter movie synopsis: ");
        String movieSynopsis = sc.nextLine();
        // create movie director
        System.out.println("Enter movie director: ");
        String movieDirector = sc.nextLine();
        // create movie cast
        System.out.println("Enter movie cast: ");
        String[] movieCast = new String[5];
        for (int i = 0; i < movieCast.length; i++) {
            movieCast[i] = sc.nextLine();
        }
        // create movie review
        System.out.println("Enter movie review: ");
        String movieReview = sc.nextLine();
        // create overall rating
        System.out.println("Enter overall rating: ");
        String overallRating = sc.nextLine();
        // create movie object
        Movie movie = new Movie(movieType, movieTitle, movieRating, movieStatus, movieSynopsis, movieDirector,
                movieCast,
                movieReview, overallRating);
        // print movie object
        System.out.println(movie);

    }

    // update movie
    public static void updateMovie() {
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
        System.out.println("Movie updated successfully");
        sc.close();
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
