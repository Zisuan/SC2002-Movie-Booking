package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Cinema implements Serializable {

    public enum CinemaType {
        PLATINUM, GOLD, NORMAL
    }

    // private int cinemaID;
    // create cinema name
    private String cinemaName;
    // create cinema code
    private String cinemaCode;
    // create cinema type
    private CinemaType cinemaType;
    // create cinema seat
    private int cinemaSeatDBID;
    // create cinemaSeatDB
    private ArrayList<Seat> cinemaSeatDB;

    private ArrayList<Movie> cinemaMovieDB;

    private int cinemaHall;

    // create cinema constructor
    private ArrayList<String> cinemaTypes = new ArrayList<>(
            Arrays.asList("NormalClass", "PlatinumClassSuite", "GoldClassSuite"));

    public Cinema(String cinemaName, int cinemaHall, String cinemaCode, CinemaType cinemaType) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
        this.cinemaHall = cinemaHall;
        int noOfSeats = 0;
        if (cinemaType.equals(cinemaTypes.get(0))) {
            noOfSeats = 30;
        } else if (cinemaType.equals(cinemaTypes.get(1))) {
            noOfSeats = 20;
        } else if (cinemaType.equals(cinemaTypes.get(2))) {
            noOfSeats = 10;
        }
        this.cinemaSeatDB = new ArrayList<Seat>(noOfSeats);
        this.cinemaMovieDB = new ArrayList<Movie>();
    }

    public Cinema(String cinemaName, int cinemaHall, CinemaType cinemaType) {
        this.cinemaName = cinemaName;
        String[] splitedCinemaName = cinemaName.split("@");
        // hallcannot be more than 9
        this.cinemaCode = splitedCinemaName[0].substring(0, 1) + splitedCinemaName[1].substring(0, 1) + cinemaHall;
        this.cinemaType = cinemaType;
        int noOfSeats = 0;
        if (cinemaType.equals(cinemaTypes.get(0))) {
            noOfSeats = 30;
        } else if (cinemaType.equals(cinemaTypes.get(1))) {
            noOfSeats = 20;
        } else if (cinemaType.equals(cinemaTypes.get(2))) {
            noOfSeats = 10;
        }
        this.cinemaSeatDB = new ArrayList<Seat>(noOfSeats);
        this.cinemaMovieDB = new ArrayList<Movie>();
    }

    public Cinema(String cinemaName, String cinemaCode, CinemaType cinemaType, ArrayList<Seat> cinemaSeatDB) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
        this.cinemaSeatDB = cinemaSeatDB;
    }

    // create cinema name getter
    public String getCinemaName() {
        return cinemaName;
    }

    // create cinema code getter
    public String getCinemaCode() {
        return cinemaCode;
    }

    // create cinema type getter
    public CinemaType getCinemaType() {
        return cinemaType;
    }

    // create cinema name setter
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    // create cinema code setter
    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    // create cinema type setter
    public void setCinemaType(CinemaType cinemaType) {
        this.cinemaType = cinemaType;
    }

    // // create cinema id getter
    // public int getCinemaID() {
    // return cinemaID;
    // }

    // // create cinema id setter
    // public void setCinemaID(int cinemaID) {
    // this.cinemaID = cinemaID;
    // }

    public int getCinemaSeatDBID() {
        return cinemaSeatDBID;
    }

    public void setCinemaSeatDBID(int cinemaSeatDBID) {
        this.cinemaSeatDBID = cinemaSeatDBID;
    }

    public ArrayList<Seat> getCinemaSeatDB() {
        return cinemaSeatDB;
    }

    public void setCinemaSeatDB(ArrayList<Seat> cinemaSeatDB) {
        this.cinemaSeatDB = cinemaSeatDB;
    }

    public ArrayList<Movie> getCinemaMovieDB() {
        return cinemaMovieDB;
    }

    public void setCinemaMovieDB(ArrayList<Movie> cinemaMovieDB) {
        this.cinemaMovieDB = cinemaMovieDB;
    }

    // create cinema toString
    @Override
    public String toString() {
        return "Cinema Name: " + getCinemaName() + "\n" +
                "Cinema Code: " + getCinemaCode() + "\n" +
                "Cinema Type: " + getCinemaType() + "\n" +
                "Cinema Seat: " + getCinemaSeatDB().toString();
    }

}