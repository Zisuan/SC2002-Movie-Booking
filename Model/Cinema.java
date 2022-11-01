package Model;

import java.io.Serializable;
import java.util.ArrayList;

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

    // create cinema constructor

    public Cinema(String cinemaName, String cinemaCode, String cinemaType) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
        this.cinemaSeatDB = new ArrayList<Seat>();
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

}