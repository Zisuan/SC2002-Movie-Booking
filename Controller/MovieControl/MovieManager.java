package Controller.MovieControl;

import java.util.*;

import Controller.ObjectControl.ObjectManager;
import Model.Movie;
import Model.Review;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class MovieManager extends ObjectManager<Movie> {
    public static final Scanner sc = new Scanner(System.in);

    // add movie
    public void addMovie(ArrayList<Movie> movieDB, MovieType movieType, String movieTitle,
            MovieStatus movieStatus,
            String movieCode, String movieSynopsis,
            String movieDirector,
            ArrayList<String> movieCast, ArrayList<Review> reviewsDB, String movieRating)
            throws SecurityException, ClassNotFoundException {
        Movie newMovie = new Movie(movieType, movieTitle, movieStatus, movieCode,
                movieSynopsis, movieDirector, movieCast, reviewsDB, movieRating);
        addObject(movieDB, newMovie);
    }

    // update movie
    public static <T> void updateMovie(int updateCase, ArrayList<Movie> movieDB, String movieCode, T updateVariable,
            ArrayList<String> movieCast) {
        switch (updateCase) {
            case 1:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieType((MovieType) updateVariable);
                        break;
                    }
                }
                break;
            case 2:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieTitle((String) updateVariable);
                        break;
                    }
                }
                break;
            case 3:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieCode((String) updateVariable);
                        break;
                    }
                }
                break;
            case 4:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieRating((String) updateVariable);
                        break;
                    }
                }
                break;
            case 5:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieStatus((MovieStatus) updateVariable);
                        break;
                    }
                }
                break;
            case 6:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieSynopsis((String) updateVariable);
                        break;
                    }
                }
                break;
            case 7:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieDirector((String) updateVariable);
                        break;
                    }
                }
                break;
            case 8:
                for (Movie movie : movieDB) {
                    if (movie.getMovieCode().equals(movieCode)) {
                        movie.setMovieCast(movieCast);
                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void updateWholeMovie(int updateCase, String OGmovieCode, ArrayList<Movie> movieDB,
            MovieType movieType,
            String movieTitle, String movieCode, String movieRating,
            MovieStatus movieStatus, String movieSynopsis,
            String movieDirector, ArrayList<String> movieCast) {

        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(OGmovieCode)) {
                movie.setMovieType(movieType);
                movie.setMovieTitle(movieTitle);
                movie.setMovieCode(movieCode);
                movie.setMovieRating(movieRating);
                movie.setMovieStatus(movieStatus);
                movie.setMovieSynopsis(movieSynopsis);
                movie.setMovieDirector(movieDirector);
                movie.setMovieCast(movieCast);
                break;
            }
        }

    }

    // updateReviewsDB
    public void updateReviewsDB(ArrayList<Movie> movieDB, String movieTitle, ArrayList<Review> reviewsDB) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(movieTitle)) {
                movie.setReviewsDB(reviewsDB);
                break;
            }
        }
    }

    // remove movie
    public static void removeMovie(ArrayList<Movie> movieDB, String movieCode) {
        for (Movie movie : movieDB) {
            if (movie.getMovieCode().equals(movieCode)) {
                movieDB.remove(movie);
                break;
            }
        }
    }

    // search movie
    public static Movie searchMovie(ArrayList<Movie> movieDB, String movieName) {
        for (Movie movie : movieDB) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;

    }

    // // select movie
    // public static String selectMovie(ArrayList<Movie> movieDB) {
    // printMovieTitles(movieDB);
    // String selectedMovie = "";
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter movie title: ");
    // String movieTitle = sc.nextLine();
    // for (Movie movie : movieDB) {
    // if (movie.getMovieCode().equals(movieTitle)) {
    // selectedMovie = movie.getMovieTitle();
    // break;
    // }
    // }
    // return selectedMovie;
    // }

    // get movie reviews
    public ArrayList<Review> getMovieReviews(ArrayList<Movie> movieDB, String movieTitle) {
        for (Movie movie : movieDB) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieTitle)) {
                return movie.getReviewsDB();
            }
        }
        return null;
    }

    // print movies
    public static void printMovie(Movie movie) {
        System.out.println("Movie Type: " + movie.getMovieType());
        System.out.println("Movie Title: " + movie.getMovieTitle());
        System.out.println("Movie Code: " + movie.getMovieCode());
        System.out.println("Movie Status: " + movie.getMovieStatus());
        System.out.println("Movie Synopsis: " + movie.getMovieSynopsis());
        System.out.println("Movie Director: " + movie.getMovieDirector());
        System.out.println("Movie Cast: " + movie.getMovieCast());
    }

    public static void printMovies(ArrayList<Movie> movieDB) {
        for (int i = 0; i < movieDB.size(); i++) {
            printMovie(movieDB.get(i));
            System.out.println();
        }
    }

    // print movie details by movie title
    public static void printMovieDetails(ArrayList<Movie> movieDB, String movieName) {
        boolean movieExists = false;
        for (Movie movie : movieDB) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieName)) {
                System.out.println(movie.toString());
                movieExists = true;
                break;
            }
        }
        if (movieExists == false) {
            System.out.println("Movie does not exist!");
        }
    }

    // print movie titles
    public static void printMovieTitles(ArrayList<Movie> movieDB) {
        for (int i = 0; i < movieDB.size(); i++) {
            System.out.println(i + 1 + ". " + movieDB.get(i).getMovieTitle());
        }
        if (movieDB.size() == 0) {
            System.out.println("No movies available");
        }
    }

    @Override
    public boolean objectExists(ArrayList<Movie> objectDB, Movie object) {
        for (Movie movie : objectDB) {
            if (movie.getMovieCode().equals(object.getMovieCode())) {
                System.out.println("Movie code already exists");
                return true;
            }
        }
        return false;
    }

    public Movie getMovieByIndex(ArrayList<Movie> movieDB, String movieIndex) {
        return movieDB.get(Integer.parseInt(movieIndex) - 1);
    }

}
