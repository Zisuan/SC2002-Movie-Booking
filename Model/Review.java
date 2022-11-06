package Model;

public class Review {
    // text content of the review
    private String movieReview;
    // name of customer
    private String customerName;
    // movie title
    private String movieTitle;
    // movie rating given by customer
    private double movieRating;

    public Review(String movieReview, String customerName, String movieTitle, double movieRating) {
        this.movieReview = movieReview;
        this.customerName = customerName;
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return "Review: " + movieReview + "\n" +
                "Rating: " + movieRating + "/5" + "\n" +
                "Reviewed by: " + customerName;
    }
}
