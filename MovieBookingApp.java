import java.util.*;

public class MovieBookingApp {
    public static void main(String[] args) {
    int option;
    Scanner sc = new Scanner(System.in);
	System.out.println("(1) Use App as Admin");
	System.out.println("(2) Use App as Movie-goer");
	System.out.println("(3) Exit");
	System.out.println();

    do {
		System.out.print("Enter the number of your choice: ");
		option = sc.nextInt();
        if (option == 1) {
            Staff staff = new Staff(null, null, true, null, null, null, null, null);
            System.out.println("Welcome to Staff Menu");
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. Remove Movie");
            System.out.println("4. Add Showtime");
            System.out.println("5. Update Showtime");
            System.out.println("6. Remove Showtime");
            System.out.println("7. Add Cinema");
            System.out.println("8. Update Cinema");
            System.out.println("9. Remove Cinema");
            System.out.println("10. Configure System settings");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    staff.addMovie();
                    break;
                case 2:
                    staff.updateMovie();
                    break;
                case 3:
                    staff.removeMovie();
                    break;
                case 4:
                    staff.addShowtime();
                    break;
                case 5:
                    staff.updateShowtime();
                    break;
                case 6:
                    staff.removeShowtime();
                    break;
                case 7:
                    staff.addCinema();
                    break;
                case 8:
                    staff.updateCinema();
                    break;
                case 9:
                    staff.removeCinema();
                    break;
                case 10:
                    staff.configureSystemSettings();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            
        }
        else if (option == 2) {
            Customer customer = new Customer(null, null, false, null, null, null, null, null);
            System.out.println("Welcome to Customer Menu");
            System.out.println("1. Search Movie");
            System.out.println("2. View Movie Details");
            System.out.println("3. Check Seat Availability");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Booking History");
            System.out.println("6.List the Top 5 ranking movie");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    customer.searchMovie();
                    break;
                case 2:
                    customer.viewMovieDetails();
                    break;
                case 3:
                    customer.checkSeatAvailability();
                    break;
                case 4:
                    customer.bookTicket();
                    break;
                case 5:
                    customer.viewBookingHistory();
                    break;
                case 6:
                    customer.listTop5RankingMovie();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        else if (option == 3) {
            System.out.println("Thank you for using our app!");
            System.exit(0);
        }
        else {
            System.out.println("Invalid option");
        }

    }
}
