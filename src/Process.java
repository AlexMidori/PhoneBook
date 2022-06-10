import com.sun.deploy.cache.BaseLocalApplicationProperties;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {

    private ArrayList<Contacts> contactList;

    public Process() {
        this.contactList = new ArrayList<Contacts>();
    }


    public void addNewContact() {
        Scanner scanner = new Scanner(System.in);
        int i = 5;
        if (i > this.contactList.size()) {
            System.out.println("| Enter Last Name: ");
            String lname = scanner.nextLine();
            System.out.println("| Enter First Name: ");
            String fname = scanner.nextLine();
            System.out.println("| Enter Email Address: ");
            String email = scanner.nextLine();
            System.out.println("| Enter Phone Number: ");
            long phone = scanner.nextLong();
            Contacts newContact = Contacts.createList(lname, fname, phone, email);
            if (addNewContact(newContact)) {
                System.out.println("| \n|     New Contact Added:\n|    Full Name: " + lname + ", " + fname + "\n| Phone Number: "
                        + phone + "\n| Email Address " + email);
            }
        } else {
            System.out.println("         \n|       Maximum Contact!");
        }
    }


    private boolean addNewContact(Contacts contact) {
        contactList.add(contact);
        return true;
    }

    public boolean removeContact(Contacts contact) {
        int find = findContact(contact);
        if (find < 0) {
            System.out.println("|   " + contact.getLName() + " does not exist.");
            return false;
        }
        this.contactList.remove(find);
        System.out.println("|   " + contact.getLName() + " is successfully removed");
        return true;
    }


    private int findContact(Contacts contact) {
        return this.contactList.indexOf(contact);
    }


    private int findContact(String contactName) {
        for (int i = 0; i < contactList.size(); i++) {
            Contacts contacts = this.contactList.get(i);
            if (contacts.getLName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    public String queryContact(Contacts contact) {
        if (findContact(contact) >= 0) {
            return contact.getLName();
        }
        return null;
    }


    public Contacts searchContact(String lname) {
        int position = findContact(lname);
        if (position >= 0) {
            return this.contactList.get(position);
        }

        return null;
    }


    public void printContacts() {
        System.out.println("\n| Contact list");
        if (this.contactList.size() > 0) {
            for (int i = 0; i < this.contactList.size(); i++) {
                System.out.println("|  " + (i + 1) + ". " + "\n| Name       : " +
                        this.contactList.get(i).getLName() + ", " + this.contactList.get(i).getFName() +
                        "\n|    Phone Number : " + this.contactList.get(i).getPhoneNumber() +
                        "\n|    Email Address: " + this.contactList.get(i).getEmailAddress());
            }
        } else {
            System.out.println("|   No contact information listed. ");
        }
    }

}
