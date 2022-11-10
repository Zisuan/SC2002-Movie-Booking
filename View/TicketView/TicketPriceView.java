package View.TicketView;

import java.util.*;
import java.io.*;
import Controller.*;
import Controller.PriceControl.PriceManager;
import Model.*;

public class TicketPriceView {
    // TODO : Can remove creating price model since only 1 price model is used.
    // Maybe update whole price model at once?

    public static final String FILEPATH = "./database/";

    public static void PriceMenu(Scanner sc, PriceManager pm) throws SecurityException,
            ClassNotFoundException, IOException {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        int sel1;
        ArrayList<Price> priceDB = new ArrayList<Price>();
        String dbPath = "";
        dbPath = FILEPATH + "Prices.dat";
        priceDB = pm.loadObjects(dbPath);
        do {
            System.out.println(
                    ANSI_BLUE + "=====================================================================");
            System.out.println("                 Configure Price Mdoel Menu                   ");
            System.out.println("=====================================================================" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. View Current Price Model");
            System.out.println("2. Create New Price Model"); // assume only 1 model
            // active at any time
            System.out.println("3. Update Price Model");
            System.out.println("4. Exit" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================================================");
            System.out.println("                           Enter Option:                             ");
            System.out.println("=====================================================================" + ANSI_RESET);
            sel1 = sc.nextInt();
            switch (sel1) {
                case 1:
                    if (priceDB.size() > 0)
                        pm.printPrice(priceDB);
                    break;
                case 2:
                    System.out.println(ANSI_BLUE + "Enter 3D surcharge: " + ANSI_RESET);
                    double threeDSurcharge = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Blockbuster Surcharge: " + ANSI_RESET);
                    double blkBusterSurcharge = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Platinum Class Surcharge: " + ANSI_RESET);
                    double platinumSurcharge = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Gold Class Surcharge: " + ANSI_RESET);
                    double goldSurcharge = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Senior Base Price: " + ANSI_RESET);
                    double seniorBasePrice = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Student Base Price: " + ANSI_RESET);
                    double studentBasePrice = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Adult Base Price: " + ANSI_RESET);
                    double adultBasePrice = sc.nextDouble();
                    System.out.println(ANSI_BLUE + "Enter Weekend/Public Holiday Surcharge: " + ANSI_RESET);
                    double weekendPHSurcharge = sc.nextDouble();
                    Price newPrice = new Price(threeDSurcharge, blkBusterSurcharge,
                            platinumSurcharge, goldSurcharge,
                            seniorBasePrice, studentBasePrice, adultBasePrice, weekendPHSurcharge);

                    priceDB.add(newPrice);
                    // System.out.println(priceDB.get(0));
                    System.out.println(ANSI_BLUE + "Price Model Created!" + ANSI_RESET);
                    pm.saveObjects(dbPath, priceDB);
                    break;
                case 3:
                    int updateCase;
                    double newValue;
                    System.out.println(ANSI_BLUE + "=====UPDATE PRICE MODEL=====");
                    System.out.println("Select Update case" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "1. Update 3D Surcharge");
                    System.out.println("2. Update Blockbuster Surcharge");
                    System.out.println("3. Update Platinum Class Surcharge");
                    System.out.println("4. Update Gold Class Surcharge");
                    System.out.println("5. Update Senior base price");
                    System.out.println("6. Update Student Base Price");
                    System.out.println("7. Update Adult Base Price");
                    System.out.println("8. Update Weekend/Public Holiday Surcharge");
                    System.out.println("9. Exit" + ANSI_RESET);
                    updateCase = sc.nextInt();
                    if (updateCase >= 1 && updateCase <= 8) {
                        System.out.println(ANSI_BLUE + "Enter New Value: " + ANSI_RESET);
                        newValue = sc.nextDouble();
                        pm.updatePrice(updateCase, priceDB, 1, newValue);
                        pm.saveObjects(dbPath, priceDB);
                        System.out.println(ANSI_BLUE + "Price Model Updated!" + ANSI_RESET);
                    }
                    break;
                case 4:
                    System.out.println(ANSI_BLUE + "Exiting..." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_BLUE + "Invalid option");
                    System.out.println("Please re-enter!" + ANSI_RESET);
                    break;
            }
        } while (sel1 != 4);
    }
}
