package Controller;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DatabaseManager {
    public static final String SEPARATOR = ",";

    // Reads a csv file and returns an arraylist of the objects
    public static ArrayList readCSV(String filename, String className)
            throws IOException, SecurityException, ClassNotFoundException {
        // read String from text file
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store Professors data

        ArrayList<String> fieldTokens = new ArrayList<String>();
        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            // get individual 'fields' of the string separated by SEPARATOR
            StringTokenizer star = new StringTokenizer(st, SEPARATOR); // pass in the string to the string tokenizer
                                                                       // using delimiter ","
            while (star.hasMoreTokens()) {
                fieldTokens.add(star.nextToken().trim());
            }
        }
        int noOfParameters = Class.forName(className).getDeclaredFields().length;
        int initialFieldSize = fieldTokens.size();
        for (int i = 0; i < initialFieldSize; i += noOfParameters) {
            try {
                Class obj = Class.forName(className);
                Constructor constructor = obj.getConstructors()[0];
                Object instance = constructor.newInstance(fieldTokens);
                alr.add(instance);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < noOfParameters; j++) {
                fieldTokens.remove(0);
            }
        }
        return alr;

    }

    // Saves an arraylist of objects to a csv file
    public static void saveArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store Professors data

        for (Object obj : al) {
            try {
                Class c = obj.getClass();
                Field[] fields = c.getDeclaredFields();
                int noOfFields = fields.length;
                StringBuilder st = new StringBuilder();
                for (int i = 0; i < noOfFields; i++) {
                    // System.out.println("The field is: " + fields[i].getName());
                    Field field = obj.getClass().getDeclaredField(fields[i].getName());
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    st.append(value.toString().trim());
                    if (i != noOfFields - 1) {
                        st.append(SEPARATOR);
                    }
                    // System.out.println("The field value is: " + value);
                    // System.out.println("The field is: " + fields[i].getName());
                    // System.out.println("The field value is: " + obj.fields[i].getName());
                }
                alw.add(st.toString());
                write(filename, alw);
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
    }

    /** Write fixed content to the given file. */
    public static void write(String fileName, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        try {
            for (int i = 0; i < data.size(); i++) {
                out.println((String) data.get(i));
            }
        } finally {
            out.close();
        }
    }

    /** Read the contents of the given file. */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return data;
    }

    // Used for debugging and refferences purposes only
    public static void printAllFields(List al) throws IOException {
        for (Object obj : al) {
            try {
                Class c = obj.getClass();
                Field[] fields = c.getDeclaredFields();
                int noOfFields = fields.length;
                StringBuilder st = new StringBuilder();
                for (int i = 0; i < noOfFields; i++) {
                    Field field = obj.getClass().getDeclaredField(fields[i].getName());
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    System.out.println("The field is: " + fields[i].getName());
                    System.out.println("The field value is: " + value);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

        }
    }
}
