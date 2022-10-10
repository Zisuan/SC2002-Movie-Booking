import java.util.*;

public class Movie {

    // create movie type
    private String movieType;
    // create movie name
    private String movieName;
    // create movie rating
    private String movieRating;
    // create movie status
    private String movieStatus;

    // create movie constructor
    public Movie(String movieType, String movieName, String movieRating, String movieStatus) {
        this.movieType = movieType;
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieStatus = movieStatus;
    }

    // create movie type getter
    public String getMovieType() {
        return movieType;
    }

    // create movie name getter
    public String getMovieName() {
        return movieName;
    }

    // create movie rating getter
    public String getMovieRating() {
        return movieRating;
    }

    // create movie status getter
    public String getMovieStatus() {
        return movieStatus;
    }

    // create movie type setter
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    // create movie name setter
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    // create movie rating setter
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    // create movie status setter
    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }
}