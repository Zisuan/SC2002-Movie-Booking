import java.util.*;

public class Login {
    public static void adminLogin() {
        // create admin login
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login successful!");
            Staff.adminMenu();
        } else {
            System.out.println("Login failed!");
            System.out.println("Please try again!");
            adminLogin();
        }
    }

    public static void CustomerLogin() {
        // create customer login
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        if (username.equals("customer") && password.equals("customer")) {
            System.out.println("Login successful!");
            Customer.CustomerMenu();
        } else {
            System.out.println("Login failed!");
            System.out.println("Please try again!");
            CustomerLogin();
        }
    }
}
