package Model;

import Model.*;

public class Cineplex {

    //cineplex location
    private String cineplexLocation;
    //cineplex name
    private String cineplexName;
    //cinema halls
    private Cinema[] cinemaHalls;

    //cineplex constructor
    Cineplex(String cineplexLocation, String cineplexName, Cinema[] cinemaHalls){
        this.cineplexLocation=cineplexLocation;
        this.cineplexName=cineplexName;
        this.cinemaHalls=cinemaHalls;
    }

    //getter methods
    public String getCineplexLocation(){
        return cineplexLocation;
    }

    public String getCineplexName(){
        return cineplexName;
    }

    public Cinema[] getCinemaHalls(){
        return cinemaHalls;
    }

    //setter methods
    public void setCineplexLocation(String cineplexLocation){
        this.cineplexLocation=cineplexLocation;
    }

    public void setCineplexName(String cineplexName){
        this.cineplexName=cineplexName;
    }

    public void setCinemaHalls(Cinema[] cinemaHalls){
        this.cinemaHalls=cinemaHalls;
    }
}
