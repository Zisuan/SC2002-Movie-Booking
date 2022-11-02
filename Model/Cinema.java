package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Cinema implements Serializable {
    // private int cinemaID;
    // create cinema name
    private String cinemaName;
    // create cinema code
    private String cinemaCode;
    // create cinema type
    private String cinemaType;
    // create cinema seat
    private int cinemaSeatDBID;
    // create cinemaSeatDB
    private ArrayList<Seat> cinemaSeatDB;

    private ArrayList<Movie> cinemaMovieDB;

    // create cinema constructor
    private ArrayList<String> cinemaTypes = new ArrayList<>(Arrays.asList("NormalClass", "PlatinumClassSuite", "GoldClassSuite"));

    public Cinema(String cinemaName, String cinemaCode, String cinemaType) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
        int noOfSeats = 0;
        if(cinemaType.equals(cinemaTypes.get(0))){
            noOfSeats = 30;
        }else if (cinemaType.equals(cinemaTypes.get(1))){
            noOfSeats = 20; 
        }else if(cinemaType.equals(cinemaTypes.get(2))){
            noOfSeats = 10;
        }
        this.cinemaSeatDB = new ArrayList<Seat>(noOfSeats);
        this.cinemaMovieDB = new ArrayList<Movie>();
    }

    public Cinema(String cinemaName, String cinemaCode, String cinemaType, ArrayList<Seat> cinemaSeatDB) {
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
    public String getCinemaType() {
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
    public void setCinemaType(String cinemaType) {
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

    public void setCinemaMovieDB(ArrayList<Movie> cinemaMovieDB){
        this.cinemaMovieDB = cinemaMovieDB;
    }

}