// package Controller;

// import java.util.*;
// import java.io.*;
// import java.text.SimpleDateFormat;

// import Model.*;

// public class PriceManager{

// //create constructor
// public PriceManager(){
// }

// //create a pricing model
// public static void createPrice(){

// Scanner sc = new Scanner(System.in);
// //create surcharge for 3D movie
// System.out.println("Enter 3D surcharge: ");
// double threeDSurcharge=sc.nextDouble();
// //create surcharge for blockbuster movie
// System.out.println("Enter blockbuster surcharge: ");
// double blkBusterSurcharge=sc.nextDouble();
// //create surcharge for platinum cinema
// System.out.println("Enter platinum class surcharge: ");
// double platinumSurcharge=sc.nextDouble();
// //create surcharge for gold cinema
// System.out.println("Enter gold class surcharge: ");
// double goldSurcharge=sc.nextDouble();
// //create base price for senior
// System.out.println("Enter senior base price: ");
// double seniorBasePrice=sc.nextDouble();
// //create base price for student
// System.out.println("Enter student base price: ");
// double studentBasePrice=sc.nextDouble();
// //create base price for adult
// System.out.println("Enter adult base price: ");
// double adultBasePrice=sc.nextDouble();
// //create surcharge for weekend/holiday
// System.out.println("Enter weekend/public holiday surcharge: ");
// double weekendPHSurcharge=sc.nextDouble();

// Price price=new Price(threeDSurcharge, blkBusterSurcharge, platinumSurcharge,
// goldSurcharge,
// seniorBasePrice, studentBasePrice, adultBasePrice, weekendPHSurcharge);

// //TODO add in database stuff maybe idk
// }
// //update various fields of the price model

// //TODO add in database stuff for all the stuff below
// //public static void updateMovieTypePrice(){

// //Scanner sc = new Scanner(System.in);

// //System.out.println("Select movie type: ");
// //System.out.println("1. 3D");
// //System.out.println("2. Blockbuster");
// //int sel=sc.nextInt();
// //System.out.println("Enter new price: ");

// //switch (sel){
// // case 1: .setThreeDSurcharge(sc.nextDouble());
// // break;
// // case 2: .setBlkBusterSurcharge(sc.nextDouble());
// // break;
// //}
// //}

// //public static void updateCinemaTypePrice(){

// //Scanner sc = new Scanner(System.in);

// //System.out.println("Select cinema type: ");
// //System.out.println("1. Platinum");
// //System.out.println("2. Gold");
// //int sel=sc.nextInt();
// //System.out.println("Enter new price: ");

// //switch (sel){
// // case 1: .setPlatinumSurcharge(sc.nextDouble());
// // break;
// // case 2: .setGoldSurcharge(sc.nextDouble());
// // break;
// //}
// //}

// //public static void updateAgeGroupPrice(){

// //Scanner sc = new Scanner(System.in);

// //System.out.println("Select age group: ");
// //System.out.println("1. Student");
// //System.out.println("2. Senior");
// //System.out.println("3. Adult");
// //int sel=sc.nextInt();
// //System.out.println("Enter new price: ");

// //switch (sel){
// //case 1: .setStudentBasePrice(sc.nextDouble());
// //break;
// //case 2: .setSeniorBasePrice(sc.nextDouble());
// //break;
// //case 3: .setAdultBasePrice(sc.nextDouble());
// //break;
// //}
// //}

// //public static void updateDayTypePrice(){

// //Scanner sc = new Scanner(System.in);

// //System.out.println("Enter new price: ");

// // .setWeekendPHSurcharge(sc.nextDouble());
// //}

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
// //get date of screening, assuming date is in the form dd/mm/yyyy for now as
// placeholder
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
// //check for weekend/public holiday surcharge (only applicable for adult
// tickets)
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
