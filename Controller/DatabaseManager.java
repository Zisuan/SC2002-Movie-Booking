package Controller;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DatabaseManager {
    public static ArrayList readSerializedObject(String filename) {
        ArrayList pDetails = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            File file = new File(filename);
            if (file.exists()) {
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
                pDetails = (ArrayList) in.readObject();
                in.close();
            } else {
                file.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out the size
        // System.out.println(" Details Size: " + pDetails.size());
        // System.out.println();
        return pDetails;
    }

    public static void writeSerializedObject(String filename, ArrayList list) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(list);
            out.close();
            // System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
