package Controller.SeatControl;

import java.util.ArrayList;

import Controller.ObjectControl.ObjectPrinter;
import Model.Seat;

public class SeatPrinter implements ObjectPrinter<Seat> {

    @Override
    public void printObjects(ArrayList<Seat> listOfObjects) {
        if (listOfObjects == null) {
            System.out.println("No seats in the database");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                printObject(listOfObjects.get(i));
                System.out.println();
            }
        }
    }

    @Override
    public void printObject(Seat object) {
        System.out.println("Seat ID: " + object.getSeatID());
        System.out.println("Seat Row: " + object.getSeatRow());
        System.out.println("Seat Column: " + object.getSeatColumn());
        System.out.println("Seat Status: " + object.isAssigned());
    }

    public void printSeat3DGrid(ArrayList<Seat> seatDB) {
        int seatCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (seatDB.get(seatCount).isAssigned()) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
                seatCount++;
            }
            System.out.println();
        }
    }

}