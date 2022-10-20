package Controller;

import java.io.*;

public class LoginAuthenticator {

    public boolean valid = false;
    public String name;

    static String baseURI = "./database/";
    static String filenames[] = { "LoginDetails.csv" };

    public String userName;

    public String passWord;

    public LoginAuthenticator(String userName, String passWord) {

        this.userName = userName;

        this.passWord = passWord;

    }

    public String getUserName() {

        return this.userName;

    }

    public String getPassword() {

        return this.passWord;

    }

    public boolean validateLogin() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(baseURI + filenames[0]));
            String line = "";
            while ((line = br.readLine()) != null) {
                String values[] = line.split(",");
                if (userName.compareTo(values[1].replaceAll("\\s", "")) == 0) {
                    if (passWord.compareTo(values[2].replaceAll("\\s", "")) == 0) {
                        valid = true;
                        name = values[0];

                    }
                }

            }
            br.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;
    }

    public boolean getRole() {
        boolean staff = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(baseURI + filenames[0]));
            String line = "";
            while ((line = br.readLine()) != null) {
                String values[] = line.split(",");
                if (userName.compareTo(values[1].replaceAll("\\s", "")) == 0) {
                    if (passWord.compareTo(values[2].replaceAll("\\s", "")) == 0) {
                        if (values[3].replaceAll("\\s", "").compareTo("Staff") == 0) {
                            staff = true;
                        } else {
                            staff = false;
                        }
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return staff;

    }
}
