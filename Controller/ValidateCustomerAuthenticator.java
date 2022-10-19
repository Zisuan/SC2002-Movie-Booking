// package Controller;

// import java.io.*;

// public class ValidateCustomerAuthenticator {

//     public boolean valid = false;
//     public String name;

//     static String path = "/Users/takash/Documents/GitHub/SC2002-Movie-Booking/database/CustomerLoginDetails.csv";

//     public boolean validateLogin(Authenticator a) {

//         try {
//             BufferedReader br = new BufferedReader(new FileReader(path));
//             String line = "";
//             while ((line = br.readLine()) != null) {
//                 String values[] = line.split(",");
//                 if (a.userName.compareTo(values[1].replaceAll("\\s", "")) == 0) {
//                     if (a.passWord.compareTo(values[2].replaceAll("\\s", "")) == 0) {
//                         valid = true;
//                         name = values[0];

//                     }
//                 }

//             }
//             br.close();
//         } catch (FileNotFoundException e) {

//             e.printStackTrace();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return valid;
//     }

// }
