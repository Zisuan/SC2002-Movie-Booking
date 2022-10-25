package Controller;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import Model.*;

public class PriceManager{

    // create a pricing model
    public static void createPrice(ArrayList<Price> priceDB, double threeDSurcharge, double blkBusterSurcharge, double platinumSurcharge, double goldSurcharge,
        double seniorBasePrice, double studentBasePrice, double adultBasePrice, double weekendPHSurcharge){

        Price price=new Price(threeDSurcharge, blkBusterSurcharge, platinumSurcharge,
            goldSurcharge, seniorBasePrice, studentBasePrice, adultBasePrice, weekendPHSurcharge);

        priceDB.clear(); //remove old price model
        priceDB.add(price);
    }

    //update various fields of the price model

    public static void updatePrice(int updateCase, ArrayList<Price> priceDB, int priceModelID, double newValue){
        switch(updateCase){ //1=threeDSurcharge, 2=blkBusterSurcharge, 3=platinumSurcharge, 4=goldSurcharge, 
            // 5=seniorBasePrice, 6=studentBasePrice, 7=adultBasePrice, 8=weekendPHSurcharge
            case 1:
                priceDB.get(priceModelID-1).setThreeDSurcharge(newValue);
                break;
            case 2:
                priceDB.get(priceModelID-1).setBlkBusterSurcharge(newValue);
                break;
            case 3:
                priceDB.get(priceModelID-1).setPlatinumSurcharge(newValue);
                break;
            case 4:
                priceDB.get(priceModelID-1).setGoldSurcharge(newValue);
                break;
            case 5:
                priceDB.get(priceModelID-1).setSeniorBasePrice(newValue);
                break;
            case 6:
                priceDB.get(priceModelID-1).setStudentBasePrice(newValue);
                break;
            case 7:
                priceDB.get(priceModelID-1).setAdultBasePrice(newValue);
                break;
            case 8:
                priceDB.get(priceModelID-1).setWeekendPHSurcharge(newValue);
                break;
        }
    }

    public void listPrices(Price price){
        System.out.println("3D surcharge: " + price.getThreeDSurcharge());
        System.out.println("Blockbuster Surcharge: " + price.getBlkBusterSurcharge());
        System.out.println("Platinum Class Surcharge: " + price.getPlatinumSurcharge());
        System.out.println("Gold Class Surcharge: " + price.getGoldSurcharge());
        System.out.println("Senior Base Price: " + price.getSeniorBasePrice());
        System.out.println("Student Base Price: " + price.getStudentBasePrice());
        System.out.println("Adult Base Price: " + price.getAdultBasePrice());
        System.out.println("Weekend/Public Holiday Surcharge: " + price.getWeekendPHSurcharge());
    }

    public void savePrice(String fileName, ArrayList<Price> priceDB) throws IOException {
        DatabaseManager.saveArray(fileName, priceDB);
    }

    public ArrayList<Price> loadPrice(String fileName, String className)
            throws IOException, SecurityException, ClassNotFoundException {
        return DatabaseManager.readCSV(fileName, className);
    }
}
// //TODO this probably(?) doesn't belong here but idk where to put it for now
// //placeholder stuff
// public static enum AgeGroup{STUDENT,ADULT,SENIOR};
// public static enum CinemaType{GOLD, PLATINUM,DEFAULT};
// public static enum MovieType{_3D,BLOCKBUSTER,DEFAULT};

// static String baseURI = "./database/";
// static String filenames[] = { "PublicHolidays.csv" };

// //placeholder args, S.T.C
// public double calculateTicketPrice(Movie movie, Cinema cinema, AgeGroup
// ageGroup, Showtime showtime, Price price){

// //initialize cost
// double cost=0;
// //get type of movie for the booked movie
// MovieType movieType=movie.getMovieType();
// //get class of cinema for the movie screening
// CinemaType cinemaType=cinema.getCinemaType();
// //get date of screening, assuming date is in the form dd/mm/yyyy for now as placeholder
// String movieDate=showtime.getMovieDate();

// //check if any surcharges apply
// if(movieType==MovieType._3D)
// cost+=price.getThreeDSurcharge();
// if(movieType==MovieType.BLOCKBUSTER)
// cost+=price.getBlkBusterSurcharge();
// if(cinemaType==CinemaType.GOLD)
// cost+=price.getGoldSurcharge();
// if(cinemaType==CinemaType.PLATINUM)
// cost+=price.getPlatinumSurcharge();
// if(ageGroup==AgeGroup.STUDENT)
// cost+=price.getStudentBasePrice();
// if(ageGroup==AgeGroup.SENIOR)
// cost+=price.getSeniorBasePrice();
// if(ageGroup==AgeGroup.ADULT){
// cost+=price.getAdultBasePrice();
// //check for weekend/public holiday surcharge (only applicable for adult tickets)
// boolean weekendOrPublicHoliday=false;
// //create calendar
// Calendar c=Calendar.getInstance();
// //format the string input date as Date
// try {
// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
// Date date = format.parse(movieDate);
// //set the date on the calendar
// c.setTime(date);
// //check if movie date is a weekend
// if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY ||
// c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
// weekendOrPublicHoliday=true;
// } catch (java.text.ParseException e1) {
// e1.printStackTrace();
// }
// //placeholder reading of public holidays using csv
// try {
// //read in public holidays
// BufferedReader br = new BufferedReader(new FileReader(baseURI +
// filenames[0]));
// String line = "";
// //check if movie date is a public holiday
// while ((line = br.readLine()) != null){
// if (movieDate.compareTo(line) == 0)
// weekendOrPublicHoliday=true;
// }
// br.close();
// } catch (FileNotFoundException e2) {
// e2.printStackTrace();
// } catch (IOException e2) {
// e2.printStackTrace();
// }
// if(weekendOrPublicHoliday)
// cost+=price.getWeekendPHSurcharge();
// }

// return cost;
// }
// }
