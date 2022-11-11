package Controller.ReviewControl;

import java.util.*;

import Controller.Helpers.DateHelper;
import Controller.ObjectControl.ObjectManager;
import Model.*;

public class ReviewManager extends ObjectManager<Review> {

    public void addReview(ArrayList<Review> reviewDB, String movieReview, String customerName, String movieTitle,
            int movieRating) {
        Review review = new Review(movieReview, customerName, movieTitle, movieRating);
        addObject(reviewDB, review);
    }

    public void updateReview(ArrayList<Review> reviewDB, String movieReview, String customerName, String movieTitle,
            int movieRating) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int i = 0;
        boolean exists = false;
        for (i = 0; i < reviewDB.size(); i++) {
            if (reviewDB.get(i).getCustomerName().equals(customerName)
                    && reviewDB.get(i).getMovieTitle().equals(movieTitle)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            reviewDB.get(i).setMovieTitle(movieTitle);
            reviewDB.get(i).setMovieRating(movieRating);
            System.out.println(ANSI_BLUE + "Review successfully updated!" + ANSI_RESET);
        } else
            System.out.println(ANSI_BLUE + "Review does not exist!" + ANSI_RESET);
    }

    public void removeReview(ArrayList<Review> reviewDB, String movieTitle, String customerName) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int i = 0;
        boolean exists = false;
        for (i = 0; i < reviewDB.size(); i++) {
            if (reviewDB.get(i).getCustomerName().equals(customerName)
                    && reviewDB.get(i).getMovieTitle().equals(movieTitle)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            reviewDB.remove(i);
            System.out.println(ANSI_BLUE + "Review successfully removed!" + ANSI_RESET);
        } else
            System.out.println(ANSI_BLUE + "Review does not exist!" + ANSI_RESET);
    }

    public boolean searchReview(ArrayList<Review> reviewDB, String movieTitle, String customerName) {
        Review tempReview = new Review("", customerName, movieTitle, 0);
        if (objectExists(reviewDB, tempReview)) {
            // System.out.println("Review found!");
            // printObject(reviewDB.get(i));
            return true;
        } else
            return false;
        // System.out.println("Review does not exist!");
    }

    public void searchByMovie(ArrayList<Review> reviewDB, String movieTitle) {
        boolean exists = false;
        for (int i = 0; i < reviewDB.size(); i++) {
            if (reviewDB.get(i).getMovieTitle().equals(movieTitle)) {
                System.out.printf("Rating: %d/5\n", reviewDB.get(i).getMovieRating());
                System.out.printf("Review by %s:\n", reviewDB.get(i).getCustomerName());
                System.out.println(reviewDB.get(i).getMovieReview() + "\n");
                exists = true;
            }
        }
        if (!exists)
            System.out.println("No reviews have been made yet.");
    }

    public void searchByCustomer(ArrayList<Review> reviewDB, String customerName) {
        boolean exists = false;
        for (int i = 0; i < reviewDB.size(); i++) {
            if (reviewDB.get(i).getCustomerName().equals(customerName)) {
                System.out.printf("Rating: %d/5\n", reviewDB.get(i).getMovieRating());
                System.out.printf("Movie Title: %s\n", reviewDB.get(i).getMovieTitle());
                System.out.println(reviewDB.get(i).getMovieReview() + "\n");
                exists = true;
            }
        }
        if (!exists)
            System.out.println("No reviews have been made yet.");
    }

    public double movieOverallRating(ArrayList<Review> reviewDB, String movieTitle) {
        double overallRating = 0;
        int count = 0;
        for (int i = 0; i < reviewDB.size(); i++) {
            if (reviewDB.get(i).getMovieTitle().equals(movieTitle)) {
                overallRating += reviewDB.get(i).getMovieRating();
                count++;
            }
        }
        if (count > 0) {
            overallRating /= count;
            return DateHelper.roundAvoid(overallRating, 1);
        } else {
            // System.out.println("No reviews have been made yet.");
            return -1;
        }
    }

    public String getReviews(ArrayList<Review> reviewDB) {
        String reviews = "";
        int count = 0;
        for (int i = reviewDB.size() - 1; i >= 0; i--) {
            count++;
            reviews += count + ". " + reviewDB.get(i).toString() + "\n\n";
        }
        if (count == 0)
            return "No reviews have been made yet.";
        return reviews;
    }

    @Override
    public boolean objectExists(ArrayList<Review> objectDB, Review object) {
        if (objectDB != null) {
            for (Review r : objectDB) {
                if (r.getCustomerName().equals(object.getCustomerName())
                        && r.getMovieTitle().equals(object.getMovieTitle())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean objectExistsInMovie(ArrayList<Review> objectDB, Review object) {
        if (objectDB != null) {
            for (Review r : objectDB) {
                if (r.getMovieTitle().equalsIgnoreCase(object.getMovieTitle())) {
                    return true;
                }
            }
        }
        return false;
    }

}
