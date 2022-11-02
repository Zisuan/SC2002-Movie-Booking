package Controller.ObjectControl;

import java.util.ArrayList;

public interface ObjectPrinter<T> {
    public void printObjects(ArrayList<T> listOfObjects);

    public void printObject(T object);

}
