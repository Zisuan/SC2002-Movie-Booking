package Controller.ObjectControl;

import java.io.IOException;
import java.util.ArrayList;

import Controller.Helpers.DatabaseManager;

public abstract class ObjectManager<T> {
    public DatabaseManager<T> dbManager = new DatabaseManager<T>();
    public ObjectPrinter<T> objPrinter = new ObjectPrinter<T>();

    public abstract boolean objectExists(ArrayList<T> objectDB, T object);

    // TODO: Add method to search for object

    public void addObject(ArrayList<T> objectDB, T object) {
        if (!objectExists(objectDB, object) || objectDB == null) {
            objectDB.add(object);
            System.out.println(object.getClass().getSimpleName() + " successfully added!");
        } else {
            System.out.println(object.getClass().getSimpleName() + " already exists!");
        }
    }

    // public void removeObject(ArrayList<T> objectDB, T object) {
    // objectDB.remove(object);
    // }

    // public void updateObject(ArrayList<T> objectDB, T oldObject, T newObject) {
    // int i = 0;
    // boolean exists = false;
    // for (i = 0; i < objectDB.size(); i++) {
    // if (objectDB.get(i).equals(oldObject)) {
    // exists = true;
    // break;
    // }
    // }
    // if (exists) {
    // objectDB.set(i, newObject);
    // System.out.println("Object succesfully updated!");
    // } else
    // System.out.println("Object does not exist!");
    // }

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
