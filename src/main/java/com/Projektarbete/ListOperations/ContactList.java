package com.Projektarbete.ListOperations;

import com.Projektarbete.Contact.Contact;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class ContactList implements Serializable {
    private ArrayList<Contact> myContacts;


    public ContactList() {
        this.myContacts = new ArrayList<>();
    }

    // Skriver ut den vanliga listan.

    public void listContacts() {
        System.out.println("");
        System.out.println(" Firstname " + " | " + " Surname" + " | " + " Tel " + " | "
                + " Email ");

        System.out.println("___________________________________________" +
                "___________________");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.myContacts.get(i).getFirstName() + " | " +
                    this.myContacts.get(i).getLastName() + " | " +
                    this.myContacts.get(i).getTelephoneNumber() + " | " +
                    this.myContacts.get(i).getEmailAddress()
            );

            System.out.println("___________________________________________" +
                    "___________________");

        }


    }
    // Lägger till en kontakt i den vanliga listan.

    public boolean addContact(Contact contact) {
        if (getContact(contact.getFirstName()) >= 0) {
            System.out.println("Contact already exist");
            return false;
        }
        myContacts.add(contact);
        return true;

    }


    // Returnerar index platsen på objektet som skickas in i den vanliga listan.
    public int getContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public int getContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getFirstName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    public boolean removeContact(Contact contact) {
        int listPosition = getContact(contact);
        if (listPosition < 0) {
            System.out.println(contact.getFirstName() + " does not exist in the list");
            return false;
        }
        this.myContacts.remove(listPosition);
        System.out.println(contact.getFirstName() + " has been removed");
        return true;
    }



    public Contact searchContact(String contactName) {
        int listPosition = getContact(contactName);
        if (listPosition >= 0) {
            return this.myContacts.get(listPosition);
        }
        return null;
    }

    public boolean updateContact(Contact contact, Contact upDatedContact) {
        int listPosition = getContact(contact);
        if (listPosition < 0) {
            System.out.println(contact.getFirstName() + " ,does not exist in the list.");
            return false;
        }
        this.myContacts.set(listPosition, upDatedContact);

        System.out.println(contact.getFirstName() + ", has been updated");
        return true;

    }

}