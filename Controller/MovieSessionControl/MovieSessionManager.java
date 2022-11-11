package Controller.MovieSessionControl;

import java.time.LocalDate;
import java.util.*;

import Controller.MovieControl.MovieManager;
import Controller.ObjectControl.ObjectManager;
import Controller.SeatControl.SeatManager;
import Model.*;

public class MovieSessionManager extends ObjectManager<MovieSession> {
    // add MovieSession
    public void addMovieSession(ArrayList<MovieSession> MovieSessionDB, MovieSession newMovieSession) {
        addObject(MovieSessionDB, newMovieSession);
    }

    // update MovieSession
    public static <T> void updateMovieSession(int updateCase, ArrayList<MovieSession> MovieSessionDB,
            String movieCode,
            T updateVariable) {
        {
            switch (updateCase) {
                case 1:
                    for (MovieSession MovieSession : MovieSessionDB) {
                        if (MovieSession.getMovie().getMovieCode().equals(movieCode)) {
                            MovieSession.setMovieDate((LocalDate) LocalDate.parse((String) updateVariable));
                            break;
                        }
                    }
                    break;
                case 2:
                    for (MovieSession MovieSession : MovieSessionDB) {
                        if (MovieSession.getMovie().getMovieCode().equals(movieCode)) {
                            MovieSession.setMovieTime((String) updateVariable);
                            break;
                        }
                    }
                    break;
                case 3:
                    for (MovieSession MovieSession : MovieSessionDB) {
                        if (MovieSession.getMovie().getMovieCode().equals(movieCode)) {
                            MovieSession.setMovie((Movie) updateVariable);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    // remove MovieSession
    public static void removeMovieSession(ArrayList<MovieSession> MovieSessionDB, MovieSession session) {
        String movieCode = session.getMovie().getMovieCode();
        for (int i = 0; i < MovieSessionDB.size(); i++) {
            if (MovieSessionDB.get(i).getMovie().getMovieCode().equals(session.getMovie().getMovieCode())
                    && MovieSessionDB.get(i).getMovieDate().equals(session.getMovieDate())
                    && MovieSessionDB.get(i).getMovieTime().equals(session.getMovieTime())) {
                MovieSessionDB.remove(i);
                break;
            }
        }
    }

    public ArrayList<Movie> getMoviesInSession(ArrayList<MovieSession> movieDB, MovieManager mm) {
        ArrayList<Movie> listOfMoviesInSession = new ArrayList<Movie>();
        if (movieDB == null) {
            System.out.println("No movies in the database");
        } else {
            for (MovieSession movieSession : movieDB) {
                if (movieSession.getMovie().getMovieStatus().equals(Movie.MovieStatus.NOW_SHOWING)
                        || movieSession.getMovie().getMovieStatus().equals(Movie.MovieStatus.PREVIEW)) {
                    if (!mm.objectExists(listOfMoviesInSession, movieSession.getMovie())) {
                        listOfMoviesInSession.add(movieSession.getMovie());
                    }
                }
            }
        }
        return listOfMoviesInSession;
    }

    public ArrayList<Cinema> getSessionByMovieIndex(ArrayList<MovieSession> listOfMoviesInSession, String movieIndex) {
        ArrayList<Cinema> listOfCinemaWithMovieInSession = new ArrayList<Cinema>();
        if (listOfMoviesInSession == null) {
            System.out.println("No movies in the database");
        } else {
            listOfCinemaWithMovieInSession.add(listOfMoviesInSession.get(Integer.parseInt(movieIndex) - 1).getCinema());
        }
        return listOfCinemaWithMovieInSession;
    }

    public ArrayList<MovieSession> filterSessionsByMovie(ArrayList<MovieSession> movieSessionDB,
            Movie movie) {
        ArrayList<MovieSession> listOfSessionsForMovie = new ArrayList<MovieSession>();
        if (movieSessionDB == null) {
            System.out.println("No movies in the database");
        } else {
            for (MovieSession movieSession : movieSessionDB) {
                if (movieSession.getMovie().getMovieTitle().equals(movie.getMovieTitle())) {
                    listOfSessionsForMovie.add(movieSession);
                }
            }
        }
        return listOfSessionsForMovie;
    }

    public ArrayList<Cinema> getCinemafilterSessionsByMovie(ArrayList<MovieSession> listOfMoviesInSession,
            Movie movie) {
        ArrayList<Cinema> listOfCinemaWithMovieInSession = new ArrayList<Cinema>();
        for (MovieSession movieSession : listOfMoviesInSession) {
            if (movieSession.getMovie().getMovieCode().equals(movie.getMovieCode())) {
                if (!listOfCinemaWithMovieInSession.contains(movieSession.getCinema())) {
                    listOfCinemaWithMovieInSession.add(movieSession.getCinema());

                }

            }
        }
        return listOfCinemaWithMovieInSession;
    }

    public ArrayList<MovieSession> filterSessionsByMovieAndCinema(ArrayList<MovieSession> movieSessionDB,
            String movieTitle,
            String cinemaCode) {
        ArrayList<MovieSession> listOfSessionsInCinemaWithMovie = new ArrayList<MovieSession>();
        if (movieSessionDB == null) {
            System.out.println("No session in the database");
        } else {
            for (int i = 0; i < movieSessionDB.size(); i++) {
                if (movieSessionDB.get(i).getMovie().getMovieTitle().equals(movieTitle)
                        && movieSessionDB.get(i).getCinema().getCinemaCode().equals(cinemaCode)) {
                    listOfSessionsInCinemaWithMovie.add(movieSessionDB.get(i));
                }
            }
        }
        return listOfSessionsInCinemaWithMovie;
    }

    public MovieSession getMovieSession(ArrayList<MovieSession> movieSessionDB, int selectedSession) {
        MovieSession movieSession = null;
        return movieSession = movieSessionDB.get(selectedSession - 1);
    }

    public void printShowtimes(ArrayList<MovieSession> movieSessionDB) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieSessionDB.size(); i++) {
            System.out.println(ANSI_CYAN + (i + 1) + ". " + movieSessionDB.get(i).getMovieDate() + " "
                    + movieSessionDB.get(i).getMovieTime() + ANSI_RESET);
        }
    }

    public void printSessionSeats(MovieSession selectedSesssion) {
        ArrayList<Seat> listOfSeats = selectedSesssion.getSessionSeats();
        SeatManager seatManager = new SeatManager();
        System.out.println(seatManager.getSessionSeatsInGrid(listOfSeats));
    }

    public void printCinemas(ArrayList<Cinema> listOfCinemas) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < listOfCinemas.size(); i++) {
            System.out.println(ANSI_CYAN + (i + 1) + ". " + listOfCinemas.get(i).getCinemaName()
                    + listOfCinemas.get(i).getCinemaCode() + ANSI_RESET);
        }
    }

    public void printAll(ArrayList<MovieSession> movieSessionDB) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        for (int i = 0; i < movieSessionDB.size(); i++) {
            System.out.println(ANSI_CYAN + (i + 1) + ". " + movieSessionDB.get(i).toString(1) + ANSI_RESET);
        }
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
