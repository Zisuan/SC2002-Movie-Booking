package View.MovieView;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.MovieControl.MovieManager;
import Controller.ReviewControl.ReviewManager;
import Model.Movie;

public class AddMovieReviewView {
    public static void addMovieReview(ArrayList<Movie> movieDB, String movieTitle, String username) {
        // add movie review
        Scanner sc = new Scanner(System.in);
        ArrayList reviewDB = new ArrayList();
        MovieManager mm = new MovieManager();
        ReviewManager rm = new ReviewManager();
        reviewDB = mm.getMovieReviews(movieDB, movieTitle);
        System.out.println("Enter your rating (1-5): ");
        int rating = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your review: ");
        String review = sc.nextLine();
        rm.addReview(reviewDB, review, username, movieTitle, rating);

    }
}
