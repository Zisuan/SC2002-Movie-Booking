package Controller;

import java.util.*;
import Model.Cinema;
import java.io.IOException; // Import the IOException class to handle errors

public class CinemaManager implements SeatManager {

    public void addCinema(ArrayList<Cinema> cinemaDB, String cinemaName, String cinemaCode, String cinemaType,
            int cinemaSeatDBID) {
        // int newID = cinemaDB.size() + 1;
        // check for duplicate cinema code
        Cinema newCinema = new Cinema(cinemaName, cinemaCode, cinemaType, cinemaSeatDBID);
        boolean exists = false;
        for (Cinema cinema : cinemaDB) {
            if (cinema.getCinemaCode().equals(cinemaCode)) {
                System.out.println("Cinema code already exists");
                exists = true;
                break;
            }
        }
        if (!exists) {
            cinemaDB.add(newCinema);
        }
    }

    public static void updateCinema(int upadateCase, ArrayList<Cinema> cinemaDB, int cinemaID, String cinemaName,
            String cinemaCode, String cinemaType) {
        switch (upadateCase) {
            case 1:
                cinemaDB.get(cinemaID - 1).setCinemaName(cinemaName);
                break;
            case 2:
                cinemaDB.get(cinemaID - 1).setCinemaCode(cinemaCode);
                break;
            case 3:
                cinemaDB.get(cinemaID - 1).setCinemaType(cinemaType);
                break;
            case 4:
                cinemaDB.get(cinemaID - 1).setCinemaName(cinemaName);
                cinemaDB.get(cinemaID - 1).setCinemaCode(cinemaCode);
                cinemaDB.get(cinemaID - 1).setCinemaType(cinemaType);
                break;
        }
    }

    public static void deleteCinema(ArrayList<Cinema> cinemaDB, int cinemaID) {
        cinemaDB.remove(cinemaID - 1);
    }

    public static Cinema getCinema(ArrayList<Cinema> cinemaDB, int cinemaID) {
        return cinemaDB.get(cinemaID - 1);
    }

    public static void printCinema(Cinema cinema) {
        // System.out.println("Cinema ID: " + cinema.getCinemaID());
        System.out.println("Cinema Name: " + cinema.getCinemaName());
        System.out.println("Cinema Code: " + cinema.getCinemaCode());
        System.out.println("Cinema Type: " + cinema.getCinemaType());
        System.out.println("Cinema Type: " + cinema.getCinemaSeatDBID());
    }

    public void printCinemas(ArrayList<Cinema> cinemaDB) {
        for (int i = 0; i < cinemaDB.size(); i++) {
            printCinema(cinemaDB.get(i));
            System.out.println();
        }
    }

    public void saveCinema(String filename, ArrayList<Cinema> cinemaDB) throws IOException {
        DatabaseManager.saveArray(filename, cinemaDB);

    }

    public ArrayList<Cinema> loadCinema(String filename, String className)
            throws IOException, SecurityException, ClassNotFoundException {
        return DatabaseManager.readCSV(filename, "Model.Cinema");
    }

    // // create cinema
    // public static void addCinema() {

    // File csvFile = new File("Cinemas.csv");
    // try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
    // Scanner sc = new Scanner(System.in);
    // String cinemaName, cinemaCode, cinemaType;
    // System.out.println("Enter cinema name: ");
    // cinemaName = sc.nextLine();
    // System.out.println("Enter cinema code: ");
    // cinemaCode = sc.nextLine();
    // System.out.println("Enter cinema type: ");
    // cinemaType = sc.nextLine();
    // fileWriter.append((System.getProperty("line.separator")));
    // fileWriter.append(cinemaName + "," + cinemaCode + "," + cinemaType);
    // System.out.println("Cinema added successfully");
    // fileWriter.close();
    // Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
    // sc.close();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // }

    // // update cinema
    // public static void updateCinema() {
    // File csvFile = new File("Cinemas.csv");
    // try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
    // Scanner reader = new Scanner(csvFile);
    // Scanner sc = new Scanner(System.in);
    // String cinemaName, cinemaCode, cinemaType;
    // System.out.println("Enter cinema name: ");
    // cinemaName = sc.nextLine();
    // System.out.println("Enter cinema code: ");
    // cinemaCode = sc.nextLine();
    // System.out.println("Enter cinema type: ");
    // cinemaType = sc.nextLine();
    // while (reader.hasNext()) {
    // String data = reader.nextLine();
    // String[] values = data.split(",");
    // if (values[0].equals(cinemaName) && values[1].equals(cinemaCode) &&
    // values[2].equals(cinemaType)) {
    // values[0] = cinemaName;
    // values[1] = cinemaCode;
    // values[2] = cinemaType;
    // fileWriter.append((System.getProperty("line.separator")));
    // fileWriter.append(cinemaName + "," + cinemaCode + "," + cinemaType);
    // }

    // }
    // System.out.println("Cinema updated successfully");
    // sc.close();

    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // remove cinema
    // public static void removeCinema() {
    // Scanner sc = new Scanner(System.in);
    // String cinemaName, cinemaCode, cinemaType;
    // System.out.println("Enter cinema name: ");
    // cinemaName = sc.nextLine();
    // System.out.println("Enter cinema code: ");
    // cinemaCode = sc.nextLine();
    // System.out.println("Enter cinema type: ");
    // cinemaType = sc.nextLine();
    // Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
    // System.out.println("Cinema removed successfully");
    // sc.close();
    // }
}
