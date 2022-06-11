import javax.naming.Name;
import java.util.ArrayList;

public class Contacts {

    String lname;
    String fname;
    long phoneNumber;
    String email;

    public Contacts(String lname, String fname, long phoneNumber, String email) {
        this.lname = lname;
        this.fname = fname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getLName() {
        return lname;
    }

    public String getFName() {
        return fname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return email;
    }


    public static Contacts createList(String lname, String fname, long phoneNumber, String email) {
        return new Contacts(lname, fname, phoneNumber, email);
    }
}
