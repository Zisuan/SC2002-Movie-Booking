package View.MovieView;

import java.util.*;

import javax.xml.crypto.Data;

import Controller.Helpers.DatabaseFilePath;
import Controller.MovieControl.MovieManager;

import java.io.IOException;

import Model.Movie;
import Model.Movie.MovieStatus;
import Model.Movie.MovieType;

public class UpdateMovie {

    public static final Scanner sc = new Scanner(System.in);

    // TODO: poor ui
    public static void updateMovie(MovieManager mm)
            throws SecurityException, ClassNotFoundException, IOException {
        ArrayList<Movie> movieDB = new ArrayList<Movie>();
        movieDB = mm.loadObjects(DatabaseFilePath.Movies.getFilePath());
        int select;
        boolean updated = false;
        do {
            System.out.println("UPDATE CURRENT MOVIE LISTING");
            System.out.println("Enter Movie Code to update movie: ");
            MovieManager.printMovieTitlesAndCode(movieDB);
            String movieCode = sc.nextLine();
            System.out.println("---------------Select Update case---------------");
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
                    System.out.println("---------------UPDATE MOVIE TYPE---------------");
                    System.out.println("Enter Movie Type: \n 1. 3D \n 2. Blockbuster \n 3. Normal");
                    String movieType = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, MovieType.valueOf(movieType), null);
                    System.out.println("Movie Type Updated!");
                    updated = true;
                    break;
                case 2:
                    System.out.println("---------------UPDATE MOVIE TITLE---------------");
                    System.out.println("Enter Movie Title: ");
                    String movieTitle2 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieTitle2, null);
                    System.out.println("Movie Title Updated!");
                    updated = true;
                    break;
                case 3:
                    System.out.println("---------------UPDATE MOVIE CODE---------------");
                    System.out.println("Enter Movie Code: ");
                    String movieCode3 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieCode3, null);
                    System.out.println("Movie Code Updated!");
                    updated = true;
                    break;
                case 4:
                    System.out.println("---------------UPDATE MOVIE RATING---------------");
                    System.out
                            .println("Enter Movie Rating: \n 1. G \n 2. PG \n 3. PG13 \n 4. NC16 \n 5. M18 \n 6. R21");
                    String movieRating4 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieRating4, null);
                    System.out.println("Movie Rating Updated!");
                    updated = true;
                    break;
                case 5:
                    System.out.println("---------------UPDATE MOVIE STATUS---------------");
                    System.out.println(
                            "Enter Movie Status: \n 1. Coming Soon \n 2. Preview \n 3. Now Showing \n 4. End of Showing");
                    String movieStatus5 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, MovieStatus.valueOf(movieStatus5), null);
                    System.out.println("Movie Status Updated!");
                    updated = true;
                    break;
                case 6:
                    System.out.println("---------------UPDATE MOVIE SYNOPSIS---------------");
                    System.out.println("Enter Movie Synopsis: ");
                    String movieSynopsis6 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieSynopsis6, null);
                    System.out.println("Movie Synopsis Updated!");
                    updated = true;
                    break;
                case 7:
                    System.out.println("---------------UPDATE MOVIE DIRECTOR---------------");
                    System.out.println("Enter Movie Director: ");
                    String movieDirector7 = sc.nextLine();
                    mm.updateMovie(select, movieDB, movieCode, movieDirector7, null);
                    System.out.println("Movie Director Updated!");
                    updated = true;
                    break;
                case 8:
                    System.out.println("---------------UPDATE MOVIE CAST---------------");
                    System.out.println("Enter Number of Movie Cast: ");
                    int numCast = sc.nextInt();
                    ArrayList<String> movieCast = new ArrayList<String>();
                    for (int i = 0; i < numCast; i++) {
                        System.out.println("Enter Movie Cast: ");
                        String movieCast8 = sc.nextLine();
                        movieCast.add(movieCast8);
                    }
                    mm.updateMovie(select, movieDB, movieCode, null, movieCast);
                    System.out.println("Movie Cast Updated!");
                    updated = true;
                    break;
                case 9:
                    System.out.println("---------------UPDATE EVERYTHING---------------");

                    Movie oldMovie = MovieManager.searchMovieByCode(movieDB, movieCode);
                    Movie updatedMovie = CreateMovie.fullMoviePrompt();
                    mm.updateWholeMovie(movieDB, updatedMovie, oldMovie);
                    mm.printMovies(movieDB);
                    System.out.println("Movie Updated!");
                    updated = true;
                    break;
                case 10:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (updated == false && select != 10);
        mm.saveObjects(DatabaseFilePath.Movies.getFilePath(), movieDB);
    }
}