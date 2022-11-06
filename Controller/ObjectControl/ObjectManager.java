package Controller.ObjectControl;

import java.io.IOException;
import java.util.ArrayList;

import Controller.DatabaseManager;

public abstract class ObjectManager<T> {
    public DatabaseManager<T> dbManager = new DatabaseManager<T>();
    public ObjectPrinter<T> objPrinter = new ObjectPrinter<T>();

    public ArrayList<T> loadObjects(String filename)
            throws IOException, SecurityException, ClassNotFoundException {
        ArrayList<T> database = dbManager.readSerializedObject(filename);
        if (database == null) {
            database = new ArrayList<T>();
        }
        return database;
    }

    public void saveObjects(String filename, ArrayList<T> database) throws IOException {
        dbManager.writeSerializedObject(filename, database);
    }

    public void printObjects(ArrayList<T> database) {
        objPrinter.printObjects(database);
    }

    public void printObject(T object) {
        objPrinter.printObject(object);
    }

}
