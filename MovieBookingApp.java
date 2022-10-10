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
        }

    }
}
