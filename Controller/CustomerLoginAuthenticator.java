// package Controller;

// import java.util.*;

// import Model.Customer;

// public class CustomerLoginAuthenticator {

//     public static void CustomerLogin() {
//         // create customer login
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter username: ");
//         String username = sc.nextLine();
//         System.out.println("Enter password: ");
//         String password = sc.nextLine();
//         Authenticator a = new Authenticator(username, password);
//         ValidateCustomerAuthenticator v = new ValidateCustomerAuthenticator();
//         v.validateLogin(a);
//         if (v.valid) {
//             System.out.println("Login successful!" + v.name);
//             Customer.CustomerMenu();
//         } else {
//             System.out.println("Login failed!");
//             System.out.println("Please try again!");
//             CustomerLogin();
//         }
//     }

// }
