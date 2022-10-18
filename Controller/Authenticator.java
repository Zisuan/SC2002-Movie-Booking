import java.util.*;

public class Authenticator {
    public String userName;
    public String passWord;

    public Authenticator(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.passWord;
    }

}   
