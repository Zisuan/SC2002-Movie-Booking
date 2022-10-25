package View;

import java.util.*;
import java.io.*;
import Controller.*;
import Model.*;

public class ConfigureSystemSettings {

    public static final String FILEPATH = "./database/";

    public static void configureSystemSettings() throws SecurityException, ClassNotFoundException, IOException{
        
            Scanner sc = new Scanner(System.in);
            int choice;
            do{
            System.out.println("Configure System Settings:");
            System.out.println("1. Add Holiday");
            System.out.println("2. Delete Holiday");
            System.out.println("3. List Holidays");
            System.out.println("4. Configure Price Model");   
            System.out.println("5. Return to Main Menu");

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
                        PriceManager pm=new PriceManager();
                        ArrayList<Price> priceDB=new ArrayList<Price>();
                        String dbPath = FILEPATH + "Prices.csv";
                        priceDB=pm.loadPrice(dbPath, "Model.Price");
                        int sel1;
                        do{
                        System.out.println("PRICE MODEL");
                        System.out.println("1. View Current Price Model");
                        System.out.println("2. Create New Price Model"); //assume only 1 model active at any time
                        System.out.println("3. Update Price Model");
                        System.out.println("4. Exit");
                        sel1=sc.nextInt();
                            switch(sel1){
                                case 1:
                                    if(priceDB.size()>0)
                                        pm.listPrices(priceDB.get(0));
                                    break;
                                case 2:
                                    System.out.println("Enter 3D surcharge: ");
                                    double threeDSurcharge=sc.nextDouble();
                                    System.out.println("Enter Blockbuster Surcharge: ");
                                    double blkBusterSurcharge=sc.nextDouble();
                                    System.out.println("Enter Platinum Class Surcharge: ");
                                    double platinumSurcharge=sc.nextDouble();
                                    System.out.println("Enter Gold Class Surcharge: ");
                                    double goldSurcharge=sc.nextDouble();
                                    System.out.println("Enter Senior Base Price: ");
                                    double seniorBasePrice=sc.nextDouble();
                                    System.out.println("Enter Student Base Price: ");
                                    double studentBasePrice=sc.nextDouble();
                                    System.out.println("Enter Adult Base Price: ");
                                    double adultBasePrice=sc.nextDouble();
                                    System.out.println("Enter Weekend/Public Holiday Surcharge: ");
                                    double weekendPHSurcharge=sc.nextDouble();
                                    pm.createPrice(priceDB, threeDSurcharge, blkBusterSurcharge, platinumSurcharge, goldSurcharge,
                                        seniorBasePrice, studentBasePrice, adultBasePrice, weekendPHSurcharge);
                                    pm.savePrice(dbPath, priceDB);
                                    break;
                                case 3:
                                    int updateCase;
                                    double newValue;
                                    System.out.println("UPDATE PRICE MODEL");
                                    System.out.println("Select Update case");
                                    System.out.println("1. Update 3D Surcharge");
                                    System.out.println("2. Update Blockbuster Surcharge");
                                    System.out.println("3. Update Platinum Class Surcharge");
                                    System.out.println("4. Update Gold Class Surcharge");
                                    System.out.println("5. Update Senior base price");
                                    System.out.println("6. Update Student Base Price");
                                    System.out.println("7. Update Adult Base Price");
                                    System.out.println("8. Update Weekend/Public Holiday Surcharge");
                                    System.out.println("9. Exit");
                                    updateCase=sc.nextInt();
                                    if(updateCase>=1 && updateCase<=8){
                                        System.out.println("Enter New Value: ");
                                        newValue=sc.nextDouble();
                                        pm.updatePrice(updateCase, priceDB, 1, newValue);
                                        pm.savePrice(dbPath, priceDB);
                                    }
                                    break;
                                case 4:
                                    System.out.println("Goodbye!");
                                    break;
                                default:
                                    System.out.println("Invalid option");
                                    System.out.println("Please re-enter!");
                                    break;
                            }
                        } while(sel1!=4);
                    case 5:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option");
                        System.out.println("Please re-enter!");
                        break;
                }
            }while(choice!=5);
        }   
}
