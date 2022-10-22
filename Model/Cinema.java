package Model;

import java.util.ArrayList;

public class Cinema {
    // private int cinemaID;
    // create cinema name
    private String cinemaName;
    // create cinema code
    private String cinemaCode;
    // create cinema type
    private String cinemaType;
    // create cinema seat
    private int cinemaSeatDBID;

    // create cinema constructor
    public Cinema(ArrayList<String> fieldTokens) {
        // this.cinemaID = Integer.parseInt(fieldTokens.get(0));
        this.cinemaName = fieldTokens.get(0);
        this.cinemaCode = fieldTokens.get(1);
        this.cinemaType = fieldTokens.get(2);
        this.cinemaSeatDBID = Integer.parseInt(fieldTokens.get(3));

    }

    public Cinema(String cinemaName, String cinemaCode, String cinemaType, int cinemaSeatDBID) {
        // this.cinemaID = cinemaID;
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
        this.cinemaSeatDBID = cinemaSeatDBID;
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

}