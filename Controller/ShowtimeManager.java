package Controller;

import java.util.ArrayList;

import Model.Cinema;
import Model.Movie;
import Model.Showtime;

public class ShowtimeManager {
    // add showtime
    public void addShowtime(ArrayList<Showtime> showtimeDB, Movie movie, Cinema cinema, String movieDate,
            String movieTime) {
        Showtime newShowtime = new Showtime(movie, cinema, movieDate, movieTime);
        showtimeDB.add(newShowtime);
    }

    // update showtime
    public static void updateShowtime(int updateCase, ArrayList<Showtime> showtimeDB, String movieCode,
            String updateVariable) {
        {
            switch (updateCase) {
                case 1:
                    for (Showtime showtime : showtimeDB) {
                        if (showtime.getMovie().getMovieCode().equals(movieCode)) {
                            showtime.setMovieDate(updateVariable);
                            break;
                        }
                    }
                    break;
                case 2:
                    for (Showtime showtime : showtimeDB) {
                        if (showtime.getMovie().getMovieCode().equals(movieCode)) {
                            showtime.setMovieTime(updateVariable);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    // remove showtime
    public static void removeShowtime(ArrayList<Showtime> showtimeDB, String movieCode) {
        for (Showtime showtime : showtimeDB) {
            if (showtime.getMovie().getMovieCode().equals(movieCode)) {
                showtimeDB.remove(showtime);
                break;
            }
        }
    }

    public void saveShowtime(String filename, ArrayList<Showtime> showtimeDB) throws IOException {
        DatabaseManager.writeSerializedObject(filename, showtimeDB);

    }

    public ArrayList<Showtime> loadShowtime(String filename)
            throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<Showtime> ShowtimeDB = DatabaseManager.readSerializedObject(filename);
        if (ShowtimeDB == null) {
            ShowtimeDB = new ArrayList<Showtime>();
        }
        return ShowtimeDB;
    }

}
