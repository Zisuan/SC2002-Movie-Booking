package Model;

import java.io.Serializable;
import java.util.*;
import java.util.random.RandomGenerator;

import Controller.Helpers.DateHelper;
import Controller.ReviewControl.ReviewManager;

public class Movie implements Serializable {

    public enum MovieStatus {
        COMING_SOON {
            @Override
            public String toString() {
                return "Coming Soon";
            }
        },
        PREVIEW {
            @Override
            public String toString() {
                return "Preview";
            }
        },
        NOW_SHOWING {
            @Override
            public String toString() {
                return "Now Showing";
            }
        },
        END_OF_SHOWING {
            @Override
            public String toString() {
                return "End of Showing";
            }
        }
    }

    public enum MovieType {
        THREE_D {
            @Override
            public String toString() {
                return "3D";
            }
        },
        BLOCKBUSTER {
            @Override
            public String toString() {
                return "Blockbuster";
            }
        },
        NORMAL {
            @Override
            public String toString() {
                return "Normal";
            }
        }
    }

    public enum MovieRating {
        G, PG, PG13, NC16, M18, R21
    }

    private int movieID;
    // create movie type
    private MovieType movieType;
    // create movie name
    private String movieTitle;
    // create movie status
    private MovieStatus movieStatus;
    // create movie synopsis
    private String movieSynopsis;
    // create movie director
    private String movieDirector;
    // create movie cast
    private ArrayList<String> movieCast;
    // create movie rating
    private ArrayList<Review> reviewsDB;
    // create movie code
    private String movieCode;

    private MovieRating movieRating;

    // create movie constructor

    public Movie(String movieType,
            String movieTitle,
            String movieStatus, String movieSynopsis,
            String movieDirector, ArrayList<String> movieCast,
            ArrayList<Review> reviewsDB, String movieRating) {
        this.movieTitle = movieTitle;
        this.movieSynopsis = movieSynopsis;
        this.movieCast = movieCast;
        this.reviewsDB = reviewsDB;
        this.movieDirector = movieDirector;
        setMovieCode(movieTitle);
        setMovieType(movieType);
        setMovieStatus(movieStatus);
        setMovieRating(movieRating);

    }

    public Movie(String movieType,
            String movieTitle,
            String movieStatus, String movieCode, String movieSynopsis,
            String movieDirector, ArrayList<String> movieCast, String movieRating) {
        this.movieTitle = movieTitle;
        this.movieSynopsis = movieSynopsis;
        this.movieCast = movieCast;
        this.reviewsDB = null;
        this.movieDirector = movieDirector;
        setMovieCode(movieTitle);
        setMovieType(movieType);
        setMovieStatus(movieStatus);
        setMovieRating(movieRating);

    }

    // create movie reviewsDB getter and setter
    public ArrayList<Review> getReviewsDB() {
        return reviewsDB;
    }

    public void setReviewsDB(ArrayList<Review> reviewsDB) {
        this.reviewsDB = reviewsDB;
    }

    // create movie rating getter
    public double getMovieOverallRating() {
        ReviewManager rm = new ReviewManager();
        return rm.movieOverallRating(this.reviewsDB, this.movieTitle);
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    // create movie rating setter
    public void setMovieRating(String movieRating) {
        switch (Integer.parseInt(movieRating)) {
            case 1:
                this.movieRating = MovieRating.G;
                break;
            case 2:
                this.movieRating = MovieRating.PG;
                break;
            case 3:
                this.movieRating = MovieRating.PG13;
                break;
            case 4:
                this.movieRating = MovieRating.NC16;
                break;
            case 5:
                this.movieRating = MovieRating.M18;
                break;
            case 6:
                this.movieRating = MovieRating.R21;
                break;
        }
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    // create movie code getter
    public String getMovieCode() {
        return movieCode;
    }

    // create movie code setter
    public void setMovieCode(String movieTtitle) {
        String splitTitle = movieTtitle.split(" ")[0];
        if (splitTitle.length() > 4) {
            this.movieCode = splitTitle.substring(0, 4);
        } else {
            this.movieCode = splitTitle + DateHelper.getAlphaNumericString(2);
        }
    }

    public void setMovieCodeManually(String movieCode) {
        this.movieCode = movieCode;
    }

    // create movie type getter
    public MovieType getMovieType() {
        return movieType;
    }

    // create movie type setter
    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public void setMovieType(String movieType) {
        switch (Integer.parseInt(movieType)) {
            case 1:
                this.movieType = MovieType.THREE_D;
                break;
            case 2:
                this.movieType = MovieType.BLOCKBUSTER;
                break;
            case 3:
                this.movieType = MovieType.NORMAL;
                break;
        }
    }

    // create movie name getter
    public String getMovieTitle() {
        return movieTitle;
    }

    // create movie name setter
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    // create movie status getter
    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    // create movie status setter
    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        switch (Integer.parseInt(movieStatus)) {
            case 1:
                this.movieStatus = MovieStatus.COMING_SOON;
                break;
            case 2:
                this.movieStatus = MovieStatus.PREVIEW;
                break;
            case 3:
                this.movieStatus = MovieStatus.NOW_SHOWING;
                break;
            case 4:
                this.movieStatus = MovieStatus.END_OF_SHOWING;
                break;
        }
    }

    // create movie synopsis getter
    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    // create movie synopsis setter
    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    // create movie director getter
    public String getMovieDirector() {
        return movieDirector;
    }

    // create movie director setter
    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    // create movie cast getter
    public ArrayList<String> getMovieCast() {
        return movieCast;
    }

    // create movie cast setter
    public void setMovieCast(ArrayList<String> movieCast) {
        this.movieCast = movieCast;
    }

    @Override
    public String toString() {
        String overallReviewRating = "NA";
        ReviewManager rm = new ReviewManager();
        if (getMovieOverallRating() != -1) {
            overallReviewRating = String.valueOf(getMovieOverallRating());
        }
        return "Movie Title: " + getMovieTitle() + "\n" +
                "Movie Status: " + getMovieStatus().toString() + "\n" +
                "Movie Synopsis: " + getMovieSynopsis() + "\n" +
                "Movie Director: " + getMovieDirector() + "\n" +
                "Movie Cast: " + getMovieCast() + "\n" +
                "Movie Rating: " + getMovieRating().toString() + "\n" +
                "Overall Movie Review Rating: " + overallReviewRating + "\n" +
                "Movie Type: " + getMovieType().toString() + "\n" +
                "Movie Code: " + getMovieCode() + "\n" +
                "=========================================================\n" +
                "                  Movie Review Rating\n" +
                "=========================================================\n" +
                rm.getLast3Reviews(reviewsDB);

    }

}
