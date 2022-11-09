package Controller.Helpers;

public enum DatabaseFilePath {
    Cinemas, Holidays, Movies, MovieSessions, Prices, Seats, Tickets, Users, Bookings;

    public static final String FILEPATH = "./database/";

    public String getFilePath() {
        return FILEPATH + this.toString() + ".dat";
    }

}
