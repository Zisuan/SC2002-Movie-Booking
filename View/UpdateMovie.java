package View;

import java.util.*;
import java.io.IOException;
import Controller.MovieManager;
import Model.Movie;

public class UpdateMovie {

    public static final String FILEPATH = "./database/";

    public static void updateMovie() throws SecurityException, ClassNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        ArrayList<String> cast = new ArrayList<String>();
        String dbPath = FILEPATH + "Movies.csv";
        movieDB = mm.loadMovie(dbPath, "Model.Movie");

        int select;
        System.out.println("UPDATE CURRENT MOVIE LISTING");
        System.out.println("Select Update case");
        System.out.println("1. Update Movie Type");
        System.out.println("2. Update Movie Title");
        System.out.println("3. Update Movie Code");
        System.out.println("4. Update Movie Rating");
        System.out.println("5. Update Movie Status");
        System.out.println("6. Update Movie Synopsis");
        System.out.println("7. Update Movie Director");
        System.out.println("8. Update Movie Cast");
        System.out.println("9. Update Movie Review");
        System.out.println("10. Update Overall Rating");
        System.out.println("11. Update Everything");
        System.out.println("12. Exit");
        select = sc.nextInt();
        switch (select) {
            case 1:
                System.out.println("UPDATE MOVIE TYPE");
                System.out.println("Enter Movie ID: ");
                int movieID1 = sc.nextInt();
                System.out.println("Enter Movie Type: ");
                String movieType1 = sc.next();
                mm.updateMovie(select, movieDB, movieID1, movieType1, dbPath, dbPath, dbPath, dbPath,
                        dbPath, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 2:
                System.out.println("UPDATE MOVIE TITLE");
                System.out.println("Enter Movie ID: ");
                int movieID2 = sc.nextInt();
                System.out.println("Enter Movie Title: ");
                String movieTitle2 = sc.next();
                mm.updateMovie(select, movieDB, movieID2, dbPath, movieTitle2, dbPath, dbPath, dbPath,
                        dbPath, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 3:
                System.out.println("UPDATE MOVIE CODE");
                System.out.println("Enter Movie ID: ");
                int movieID3 = sc.nextInt();
                System.out.println("Enter Movie Code: ");
                String movieCode3 = sc.next();
                mm.updateMovie(select, movieDB, movieID3, dbPath, dbPath, movieCode3, dbPath, dbPath,
                        dbPath, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 4:
                System.out.println("UPDATE MOVIE RATING");
                System.out.println("Enter Movie ID: ");
                int movieID4 = sc.nextInt();
                System.out.println("Enter Movie Rating: ");
                String movieRating4 = sc.next();
                mm.updateMovie(select, movieDB, movieID4, dbPath, dbPath, dbPath, movieRating4, dbPath,
                        dbPath, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 5:
                System.out.println("UPDATE MOVIE STATUS");
                System.out.println("Enter Movie ID: ");
                int movieID5 = sc.nextInt();
                System.out.println("Enter Movie Status: ");
                String movieStatus5 = sc.next();
                mm.updateMovie(select, movieDB, movieID5, dbPath, dbPath, dbPath, dbPath, movieStatus5,
                        dbPath, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 6:
                System.out.println("UPDATE MOVIE SYNOPSIS");
                System.out.println("Enter Movie ID: ");
                int movieID6 = sc.nextInt();
                System.out.println("Enter Movie Synopsis: ");
                String movieSynopsis6 = sc.next();
                mm.updateMovie(select, movieDB, movieID6, dbPath, dbPath, dbPath, dbPath,
                        dbPath, movieSynopsis6, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 7:
                System.out.println("UPDATE MOVIE DIRECTOR");
                System.out.println("Enter Movie ID: ");
                int movieID7 = sc.nextInt();
                System.out.println("Enter Movie Director: ");
                String movieDirector7 = sc.next();
                mm.updateMovie(select, movieDB, movieID7, dbPath, dbPath, dbPath, dbPath,
                        dbPath, dbPath, movieDirector7, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 8:
                System.out.println("UPDATE MOVIE CAST");
                System.out.println("Enter Movie ID: ");
                int movieID8 = sc.nextInt();
                System.out.println("Enter Number of Movie Cast: ");
                int numCast = sc.nextInt();
                for (int i = 0; i < numCast; i++) {
                    System.out.println("Enter Movie Cast: ");
                    String movieCast8 = sc.next();
                    cast.add(movieCast8);
                }
                mm.updateMovie(select, movieDB, movieID8, dbPath, dbPath, dbPath, dbPath, dbPath,
                        dbPath, dbPath, cast, dbPath, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 9:
                System.out.println("UPDATE MOVIE REVIEW");
                System.out.println("Enter Movie ID: ");
                int movieID9 = sc.nextInt();
                System.out.println("Enter Movie Review: ");
                String movieReview9 = sc.next();
                mm.updateMovie(select, movieDB, movieID9, dbPath, dbPath, dbPath, dbPath, dbPath,
                        dbPath, dbPath, cast, movieReview9, dbPath);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 10:
                System.out.println("UPDATE OVERALL RATING");
                System.out.println("Enter Movie ID: ");
                int movieID10 = sc.nextInt();
                System.out.println("Enter Overall Rating: ");
                String overallRating10 = sc.next();
                mm.updateMovie(select, movieDB, movieID10, dbPath, dbPath, dbPath, dbPath,
                        dbPath, dbPath, dbPath, cast, dbPath, overallRating10);
                mm.saveMovie(dbPath, movieDB);
                break;
            case 11:
                System.out.println("UPDATE EVERYTHING");
                System.out.println("Enter Movie ID: ");
                int movieID11 = sc.nextInt();
                System.out.println("Enter Movie Type: ");
                String movieType11 = sc.next();
                System.out.println("Enter Movie Title: ");
                String movieTitle11 = sc.next();
                System.out.println("Enter Movie Code: ");
                String movieCode11 = sc.next();
                System.out.println("Enter Movie Rating: ");
                String movieRating11 = sc.next();
                System.out.println("Enter Movie Status: ");
                String movieStatus11 = sc.next();
                System.out.println("Enter Movie Synopsis: ");
                String movieSynopsis11 = sc.next();
                System.out.println("Enter Movie Director: ");
                String movieDirector11 = sc.next();
                System.out.println("Enter Number of Movie Cast: ");
                int numOfCast = sc.nextInt();
                for (int i = 0; i < numOfCast; i++) {
                    System.out.println("Enter Movie Cast: ");
                    String movieCast8 = sc.next();
                    cast.add(movieCast8);
                }
                System.out.println("Enter Movie Review: ");
                String movieReview11 = sc.next();
                System.out.println("Enter Overall Rating: ");
                String overallRating11 = sc.next();
                mm.updateMovie(select, movieDB, movieID11, movieType11, movieTitle11, movieCode11,
                        movieRating11, movieStatus11, movieSynopsis11, movieDirector11, cast,
                        movieReview11, overallRating11);
                mm.saveMovie(dbPath, movieDB);
                break;
            default:
                System.out.println("Invalid Input");
                break;

        }
        sc.close();
    }
}