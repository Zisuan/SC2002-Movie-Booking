package Controller.MovieSessionControl;

import java.util.ArrayList;

import Controller.ObjectControl.ObjectPrinter;
import Model.MovieSession;

public class MovieSessionPrinter implements ObjectPrinter<MovieSession> {

    @Override
    public void printObjects(ArrayList<MovieSession> listOfObjects) {
        if (listOfObjects == null) {
            System.out.println("No sessions in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                printObject(listOfObjects.get(i));
                System.out.println();
            }
        }
    }

    @Override
    public void printObject(MovieSession object) {
        System.out.println("Movie Session Movie: " + object.getMovie().getMovieName());
        System.out.println("Movie Session Cinema: " + object.getCinema().getCinemaName());
        System.out.println("Movie Session Date: " + object.getMovieDate());
        System.out.println("Movie Session Time: " + object.getMovieTime());
        System.out.println("Movie Session Seats: ");
        printSessionSeats(object);
    }

    public void printSessionSeats(MovieSession object) {
        System.out.println("Movie Session Seats: " + object.getSessionSeats());

    }

    public void printMovieTitles(ArrayList<MovieSession> listOfObjects) {
        if (listOfObjects == null) {
            System.out.println("No sessions in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                System.out.println(listOfObjects.get(i).getMovie().getMovieName());
            }
        }
    }

}
