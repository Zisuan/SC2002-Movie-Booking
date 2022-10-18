import java.util.*;

public class Staff extends User {
    private String staffID;

    // constructor
    public Staff(String username, String password, boolean isStaff, String firstName, String lastName, String email,
            String mobileNumber, String staffID) {
        super(username, password, isStaff, firstName, lastName, email, mobileNumber);
        this.staffID = staffID;
    }

    public static void adminMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to Staff Menu");
        System.out.println("1. Add Movie");
        System.out.println("2. Update Movie");
        System.out.println("3. Remove Movie");
        System.out.println("4. Add Cinema Showtime");
        System.out.println("5. Update Cinema Showtime");
        System.out.println("6. Remove Cinema Showtime");
        System.out.println("7. Add Cinema");
        System.out.println("8. Update Cinema");
        System.out.println("9. Remove Cinema");
        System.out.println("10. Configure System settings");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                AdminMovie.addMovie();
                break;
            case 2:
                AdminMovie.updateMovie();
                break;
            case 3:
                AdminMovie.removeMovie();
                break;
            // case 4:
            // addShowtime();
            // break;
            // case 5:
            // updateShowtime();
            // break;
            // case 6:
            // removeShowtime();
            // break;
            case 7:
                AdminCinema.addCinema();
                break;
            case 8:
                AdminCinema.updateCinema();
                break;
            case 9:
                AdminCinema.removeCinema();
                break;
            // case 10:
            // configureSystemSettings();
            // break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

}
