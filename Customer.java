import java.util.*;

public class Customer extends User {
    private String mobileNumber; // customer mobile number

    // create customer constructor
    public Customer(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber, Object object) {
        super(username, password, isStaff, firstName, lastName, email, mobileNumber);
        this.mobileNumber = mobileNumber;
    }

    public static void CustomerMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Customer Menu");
        System.out.println("1. Search Movie");
        System.out.println("2. View Movie Details");
        System.out.println("3. Check Seat Availability");
        System.out.println("4. Book Ticket");
        System.out.println("5. View Booking History");
        System.out.println("6.List the Top 5 ranking movie");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                searchMovie();
                break;
            case 2:
                viewMovieDetails();
                break;
            case 3:
                checkSeatAvailability();
                break;
            case 4:
                bookTicket();
                break;
            case 5:
                viewBookingHistory();
                break;
            case 6:
                listTop5RankingMovie();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}
