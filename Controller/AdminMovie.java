package Controller;

import java.util.*;

import Model.Movie;

public class AdminMovie extends Movie {

    public AdminMovie(String movieType, String movieTitle, String movieRating, String movieStatus) {
        super(movieType, movieTitle, movieRating, movieStatus);
    }

    // create movie
    public static void addMovie() {
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
        Movie movie = new Movie(movieType, movieName, movieRating, movieStatus);
        System.out.println("Movie added successfully");
        sc.close();
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
        Movie movie = new Movie(movieType, movieName, movieRating, movieStatus);
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
        Movie movie = new Movie(movieType, movieName, movieRating, movieStatus);
        System.out.println("Movie removed successfully");
        sc.close();
    }
}
