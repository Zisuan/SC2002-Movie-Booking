package Controller.MovieSessionControl;

import java.util.*;

import Controller.ObjectControl.ObjectManager;
import Controller.SeatControl.SeatManager;
import Model.*;

public class MovieSessionManager extends ObjectManager<MovieSession> {
    // add MovieSession
    public void addMovieSession(ArrayList<MovieSession> MovieSessionDB, Movie movie, Cinema cinema, String movieDate,
            String movieTime, ArrayList<Seat> sessionSeats) {
        MovieSession newMovieSession = new MovieSession(movie, cinema, movieDate, movieTime, sessionSeats);
        addObject(MovieSessionDB, newMovieSession);
    }

    // update MovieSession
    public static void updateMovieSession(int updateCase, ArrayList<MovieSession> MovieSessionDB,
            String movieCode,
            String updateVariable) {
        {
            switch (updateCase) {
                case 1:
                    for (MovieSession MovieSession : MovieSessionDB) {
                        if (MovieSession.getMovie().getMovieCode().equals(movieCode)) {
                            MovieSession.setMovieDate(updateVariable);
                            break;
                        }
                    }
                    break;
                case 2:
                    for (MovieSession MovieSession : MovieSessionDB) {
                        if (MovieSession.getMovie().getMovieCode().equals(movieCode)) {
                            MovieSession.setMovieTime(updateVariable);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    // remove MovieSession
    public static void removeMovieSession(ArrayList<MovieSession> MovieSessionDB, String movieCode) {
        for (MovieSession MovieSession : MovieSessionDB) {
            if (MovieSession.getMovie().getMovieCode().equals(movieCode)) {
                MovieSessionDB.remove(MovieSession);
                break;
            }
        }
    }

    public ArrayList<Movie> getMovies(ArrayList<MovieSession> listOfObjects) {
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        if (listOfObjects == null) {
            System.out.println("No movies in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                listOfMovies.add(listOfObjects.get(i).getMovie());

            }
        }
        return listOfMovies;
    }

    public ArrayList<Cinema> getCinemaByMovie(ArrayList<MovieSession> listOfObjects, String movieCode) {
        ArrayList<Cinema> listOfCinema = new ArrayList<Cinema>();
        if (listOfObjects == null) {
            System.out.println("No movies in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                if (listOfObjects.get(i).getMovie().getMovieCode().equals(movieCode)) {
                    listOfCinema.add(listOfObjects.get(i).getCinema());
                }
            }
        }
        return listOfCinema;
    }

    public ArrayList<MovieSession> getShowtimeByMovieAndCinema(ArrayList<MovieSession> listOfObjects, String movieCode,
            String cinemaCode) {
        ArrayList<MovieSession> listOfShowtime = new ArrayList<MovieSession>();
        if (listOfObjects == null) {
            System.out.println("No movies in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                if (listOfObjects.get(i).getMovie().getMovieCode().equals(movieCode)
                        && listOfObjects.get(i).getCinema().getCinemaCode().equals(cinemaCode)) {
                    listOfShowtime.add(listOfObjects.get(i));
                }
            }
        }
        return listOfShowtime;
    }

    public MovieSession getMovieSession(ArrayList<MovieSession> listOfObjects, int selectedSession) {
        MovieSession movieSession = null;
        return movieSession = listOfObjects.get(selectedSession + 1);
    }

    public void printSessionSeats(MovieSession selectedSesssion) {
        ArrayList<Seat> listOfSeats = selectedSesssion.getSessionSeats();
        SeatManager seatManager = new SeatManager();
        seatManager.printObjects(listOfSeats);
    }

    @Override
    public boolean objectExists(ArrayList<MovieSession> objectDB, MovieSession object) {
        for (MovieSession movieSession : objectDB) {
            if (movieSession.getMovie().getMovieCode().equals(object.getMovie().getMovieCode())
                    && movieSession.getCinema().getCinemaCode().equals(object.getCinema().getCinemaCode())
                    && movieSession.getMovieDate().equals(object.getMovieDate())
                    && movieSession.getMovieTime().equals(object.getMovieTime())) {
                return true;
            }
        }
        return false;
    }

}
