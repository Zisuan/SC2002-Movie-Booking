package Controller.ObjectControl;

import java.util.ArrayList;

public class ObjectPrinter<T> {
    public void printObjects(ArrayList<T> listOfObjects) {
        if (listOfObjects == null) {
            System.out.println("The database is empty!");
        } else {
            for (int i = 0; i < listOfObjects.size(); i++) {
                System.out.print(i + 1 + ". ");
                printObject(listOfObjects.get(i));
                System.out.println();
            }
        }
    }

    // function that prints the object's attributes
    public void printObject(T object) {
        System.out.println(object.toString());
    }
}
