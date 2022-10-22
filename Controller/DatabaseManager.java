package Controller;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Model.Movie;

public class DatabaseManager {
    public static final String SEPARATOR = ",";

    // an example of reading
    public static ArrayList readArray(String filename) throws IOException {
        // read String from text file
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st, SEPARATOR); // pass in the string to the string tokenizer
                                                                       // using delimiter ","

            int movieID = Integer.parseInt(star.nextToken().trim()); // first token
            String movieType = star.nextToken().trim(); // second token
            String movieTitle = star.nextToken().trim(); // third token
            String movieCode = star.nextToken().trim(); // fourth token
            String movieRating = star.nextToken().trim(); // fifth token
            String movieStatus = star.nextToken().trim(); // sixth token
            String movieSynopsis = star.nextToken().trim(); // seventh token
            String movieDirector = star.nextToken().trim(); // eighth token
            String movieCast = star.nextToken().trim(); // ninth token
            String movieReview = star.nextToken().trim(); // tenth token
            String overallRating = star.nextToken().trim(); // eleventh token

            // create movie object from file data
            Movie movie = new Movie(movieID, movieType, movieTitle, movieCode, movieRating, movieStatus,
                    movieSynopsis,
                    movieDirector, movieCast, movieReview, overallRating);
            // add to Professors list
            alr.add(movie);
        }
        return alr;
    }
    // an example of saving

    public static void saveArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store Professors data

        for (int i = 0; i < al.size(); i++) {
            Movie movie = (Movie) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(movie.getMovieType().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieName().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieCode().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieRating().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieStatus().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieSynopsis().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieDirector().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieCast().trim());
            st.append(SEPARATOR);
            st.append(movie.getMovieReview().trim());
            st.append(SEPARATOR);
            st.append(movie.getOverallRating().trim());
            st.append(SEPARATOR);
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    /** Write fixed content to the given file. */
    public static void write(String fileName, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        try {
            for (int i = 0; i < data.size(); i++) {
                out.println((String) data.get(i));
            }
        } finally {
            out.close();
        }
    }

    /** Read the contents of the given file. */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return data;
    }

}
