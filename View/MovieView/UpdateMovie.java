package View.MovieView;

import java.util.*;

import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class UpdateMovie {

    public static final String FILEPATH = "./database/";

    public static void updateMovie(MovieManager mm, Scanner sc)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        String dbPath = FILEPATH + "Movies.dat";
        movieDB = mm.loadObjects(dbPath);
        int select;
        do {
            System.out.println("UPDATE CURRENT MOVIE LISTING");
            System.out.println("Enter Movie Code to update movie: ");
            String movieCode = sc.nextLine();
            System.out.println("Select Update case");
            System.out.println("1. Update Movie Type");
            System.out.println("2. Update Movie Title");
            System.out.println("3. Update Movie Code");
            System.out.println("4. Update Movie Rating");
            System.out.println("5. Update Movie Status");
            System.out.println("6. Update Movie Synopsis");
            System.out.println("7. Update Movie Director");
            System.out.println("8. Update Movie Cast");
            System.out.println("9. Update Everything");
            System.out.println("10. Exit");
            select = sc.nextInt();
            sc.nextLine();
            switch (select) {
                case 1:
                    System.out.println("UPDATE MOVIE TYPE");
                    System.out.println("Enter Movie Type: ");
                    String movieType = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, MovieType.valueOf(movieType), null);
                    break;
                case 2:
                    System.out.println("UPDATE MOVIE TITLE");
                    System.out.println("Enter Movie Title: ");
                    String movieTitle2 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieTitle2, null);
                    break;
                case 3:
                    System.out.println("UPDATE MOVIE CODE");
                    System.out.println("Enter Movie Code: ");
                    String movieCode3 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieCode3, null);
                    break;
                case 4:
                    System.out.println("UPDATE MOVIE RATING");
                    System.out.println("Enter Movie Rating: ");
                    String movieRating4 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieRating4, null);
                    break;
                case 5:
                    System.out.println("UPDATE MOVIE STATUS");
                    System.out.println("Enter Movie Status: ");
                    String movieStatus5 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, MovieStatus.valueOf(movieStatus5), null);
                    break;
                case 6:
                    System.out.println("UPDATE MOVIE SYNOPSIS");
                    System.out.println("Enter Movie Synopsis: ");
                    String movieSynopsis6 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieSynopsis6, null);
                    break;
                case 7:
                    System.out.println("UPDATE MOVIE DIRECTOR");
                    System.out.println("Enter Movie Director: ");
                    String movieDirector7 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieDirector7, null);
                    break;
                case 8:
                    System.out.println("UPDATE MOVIE CAST");
                    System.out.println("Enter Number of Movie Cast: ");
                    int numCast = sc.nextInt();
                    ArrayList<String> movieCast = new ArrayList<String>();
                    for (int i = 0; i < numCast; i++) {
                        System.out.println("Enter Movie Cast: ");
                        String movieCast8 = sc.nextLine();
                        movieCast.add(movieCast8);
                    }
                    mm.updateMovie(select, movieDB, movieCode, null, movieCast);
                    break;
                case 9:
                    System.out.println("UPDATE EVERYTHING");
                    System.out.println("Enter Movie Type: ");
                    String movieType11 = sc.nextLine();
                    System.out.println("Enter Movie Title: ");
                    String movieTitle11 = sc.nextLine();
                    System.out.println("Enter Movie Code: ");
                    String movieCode11 = sc.nextLine();
                    System.out.println("Enter Movie Rating: ");
                    String movieRating11 = sc.nextLine();
                    System.out.println("Enter Movie Status: ");
                    String movieStatus11 = sc.nextLine();
                    System.out.println("Enter Movie Synopsis: ");
                    String movieSynopsis11 = sc.nextLine();
                    System.out.println("Enter Movie Director: ");
                    String movieDirector11 = sc.nextLine();
                    System.out.println("Enter Number of Movie Cast: ");
                    int numOfCast = sc.nextInt();
                    ArrayList<String> movieCastall = new ArrayList<String>();
                    for (int i = 0; i < numOfCast; i++) {
                        System.out.println("Enter Movie Cast: ");
                        String movieCast8 = sc.next();
                        movieCastall.add(movieCast8);
                    }
                    mm.updateWholeMovie(select, movieCode, movieDB, MovieType.valueOf(movieType11), movieTitle11,
                            movieCode11,
                            movieRating11,
                            MovieStatus.valueOf(movieStatus11), movieSynopsis11, movieDirector11, movieCastall);
                    break;
                case 10:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (select != 10);
    }
}