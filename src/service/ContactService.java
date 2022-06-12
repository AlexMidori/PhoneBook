package service;

import model.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactService {

    private ArrayList<Contact> contactList;

    public ContactService() {
        this.contactList = new ArrayList<Contact>();
    }

    public void addNewContact() {
        Scanner scanner = new Scanner(System.in);
        int i = 5;
        if (i > this.contactList.size()) {
            System.out.println("| Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.println("| Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.println("| Enter Email Address: ");
            String email = scanner.nextLine();
            System.out.println("| Enter Phone Number: ");
            long phoneNumber = scanner.nextLong();
            Contact newContact = Contact.createList(lastName, firstName, phoneNumber, email);
            if (addNewContact(newContact)) {
                System.out.println("| \n|     New Contact.Contact Added:\n|    Full Name: " + lastName + ", " + firstName + "\n| Phone Number: "
                        + phoneNumber + "\n| Email Address " + email);
            }
        } else {
            System.out.println("         \n|       Maximum Contact.Contact!");
        }
    }


    private boolean addNewContact(Contact contact) {
        contactList.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int find = findContact(contact);
        if (find < 0) {
            System.out.println("|   " + contact.getLName() + " does not exist.");
            return false;
        }
        this.contactList.remove(find);
        System.out.println("|   " + contact.getLName() + " is successfully removed");
        return true;
    }


    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }


    private int findContact(String contactName) {
        for (int i = 0; i < contactList.size(); i++) {
            Contact contacts = this.contactList.get(i);
            if (contacts.getLName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    public Contact searchContact(String lname) {
        int position = findContact(lname);
        if (position >= 0) {
            return this.contactList.get(position);
        }

        return null;
    }


    public void printContacts() {
        System.out.println("\n| Contact.Contact list");
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
