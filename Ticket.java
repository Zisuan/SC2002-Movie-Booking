public class Ticket {
    // create ticket id
    private String ticketId;
    // create ticket price
    private double ticketPrice;
    // create ticket type
    private String ticketType;
    // create ticket status
    private String ticketStatus;
    // create ticket seat
    private String ticketSeat;
    // create ticket showtime
    private Showtimes ticketShowtime;
    // create ticket customer
    private Customer ticketCustomer;

    // create ticket constructor
    public Ticket(String ticketId, double ticketPrice, String ticketType, String ticketStatus, String ticketSeat,
            Showtimes ticketShowtime, Customer ticketCustomer) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.ticketSeat = ticketSeat;
        this.ticketShowtime = ticketShowtime;
        this.ticketCustomer = ticketCustomer;
    }

    // create ticket id getter
    public String getTicketId() {
        return ticketId;
    }

    // create ticket price getter
    public double getTicketPrice() {
        return ticketPrice;
    }

    // create ticket type getter
    public String getTicketType() {
        return ticketType;
    }

    // create ticket status getter
    public String getTicketStatus() {
        return ticketStatus;
    }

    // create ticket seat getter
    public String getTicketSeat() {
        return ticketSeat;
    }

    // create ticket showtime getter
    public Showtimes getTicketShowtime() {
        return ticketShowtime;
    }

    // create ticket customer getter
    public Customer getTicketCustomer() {
        return ticketCustomer;
    }

    // create ticket id setter
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    // create ticket price setter
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // create ticket type setter
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    // create ticket status setter
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    // create ticket seat setter
    public void setTicketSeat(String ticketSeat) {
        this.ticketSeat = ticketSeat;
    }

    // create ticket showtime setter
    public void setTicketShowtime(Showtimes ticketShowtime) {
        this.ticketShowtime = ticketShowtime;
    }

    // create ticket customer setter
    public void setTicketCustomer(Customer ticketCustomer) {
        this.ticketCustomer = ticketCustomer;
    }

}
