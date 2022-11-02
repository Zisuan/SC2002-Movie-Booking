package Controller.CinemaControl;

import java.util.ArrayList;

import Controller.ObjectControl.*;
import Model.*;

public class CinemaPrinter implements ObjectPrinter<Cinema> {

    @Override
    public void printObjects(ArrayList<Cinema> listOfObjects) {
        if (listOfObjects == null) {
            System.out.println("No cinema in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                printObject(listOfObjects.get(i));
                System.out.println();
            }
        }
    }

    @Override
    public void printObject(Cinema object) {
        System.out.println("Cinema Name: " + object.getCinemaName());
        System.out.println("Cinema Code: " + object.getCinemaCode());
        System.out.println("Cinema Type: " + object.getCinemaType());
        System.out.println("Cinema Seat: " + object.getCinemaSeatDB());
    }

    public ArrayList<Integer> printCinemaNamesWithMovie(ArrayList<Cinema> cinemaDB, String movieName) {
        int i = 0;
        for (Cinema c : cinemaDB) {
            ArrayList<Movie> movieDB = c.getCinemaMovieDB();
            for (Movie m : movieDB) {
                if (m.getMovieName().equals(movieName)) {
                    i++;
                    System.out.println(i + ". " + c.getCinemaName() + "- " + c.getCinemaType());

                }

            }
        }
    }
}