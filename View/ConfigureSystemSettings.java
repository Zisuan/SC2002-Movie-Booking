package View;
import java.util.*;

public class ConfigureSystemSettings {
    public static void configureSystemSettings() {
        
            Scanner sc = new Scanner(System.in);
            int choice;
            System.out.println("Configure System Settings:");
            System.out.println("1. Add Holiday");
            System.out.println("2. Delete Holiday");
            System.out.println("3. List Holidays");
            System.out.println("4. Update Movie Type Price");
            System.out.println("5. Update Cinema Type Price");
            System.out.println("6. Update Student Ticket Price");
            System.out.println("7. Update Senior Citizen Ticket Price");
            System.out.println("8. Update Standard Ticket Price");
            System.out.println("9. Update Weekend Ticket Price");
            System.out.println("10. Update Holiday Ticket Price");
            System.out.println("11. Return to Main Menu");
            System.out.println("Option: ");
            choice = sc.nextInt();  

            switch(choice)
            {
                case 1:
                    //addHoliday();
                    break;
                case 2:
                    //deleteHoliday();
                    break;
                case 3:
                    //listHolidays();
                    break;
                case 4:
                    //updateMovieTypePrice();
                    break;
                case 5:
                    //updateCinemaTypePrice();
                    break;
                case 6:
                    //updateStudentTicketPrice();
                    break;
                case 7:
                    //updateSeniorCitizenTicketPrice();
                    break;
                case 8:
                    //updateStandardTicketPrice();
                    break;
                case 9:
                    //updateWeekendTicketPrice();
                    break;
                case 10:
                    //updateHolidayTicketPrice();
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("Please re-enter!");
                    break;

            }
        }
        
}
