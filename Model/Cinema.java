package Model;

public class Cinema {
    // create cinema name
    private String cinemaName;
    // create cinema code
    private String cinemaCode;
    // create cinema type
    private String cinemaType;

    // create cinema constructor
    public Cinema(String cinemaName, String cinemaCode, String cinemaType) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
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
}