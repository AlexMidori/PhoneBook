public class Contact {

    String lname;
    String fname;
    long phoneNumber;
    String email;

    public Contact(String lname, String fname, long phoneNumber, String email) {
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


    public static Contact createList(String lname, String fname, long phoneNumber, String email) {
        return new Contact(lname, fname, phoneNumber, email);
    }
}
