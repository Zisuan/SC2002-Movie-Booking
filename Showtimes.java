public class Showtimes {
    // create showtime
    private String showtime;
    // Movie object
    private Movie movie;
    // Cinema object
    private Cinema cinema;

    // movie date
    private String movieDate;
    // movie time
    private String movieTime;

    // create showtime constructor
    public Showtimes(String showtime, Movie movie, Cinema cinema, String movieDate, String movieTime) {
        this.showtime = showtime;
        this.movie = movie;
        this.cinema = cinema;
        this.movieDate = movieDate;
        this.movieTime = movieTime;
    }

    // create showtime getter
    public String getShowtime() {
        return showtime;
    }

    // create movie getter
    public Movie getMovie() {
        return movie;
    }

    // create cinema getter
    public Cinema getCinema() {
        return cinema;
    }

    // create movie date getter
    public String getMovieDate() {
        return movieDate;
    }

    // create movie time getter
    public String getMovieTime() {
        return movieTime;
    }

    // create showtime setter
    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    // create movie setter
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // create cinema setter
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    // create movie date setter
    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    // create movie time setter
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
}
