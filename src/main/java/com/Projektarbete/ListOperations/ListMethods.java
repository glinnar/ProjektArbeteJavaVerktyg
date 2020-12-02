package com.Projektarbete.ListOperations;

import java.util.ArrayList;

public class ListMethods {

    private ArrayList<ContactList> myContacts;

    // Konstruktor
    public ListMethods() {
        this.myContacts = new ArrayList<>();
    }

    private int findContact(ContactList contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            ContactList contact = this.myContacts.get(i);
            if (contact.getFirstName().equals(contactName) || contact.getLastName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    // När ny person läggs till sker kontroll på att den inte redan finns i arraylistan
    // Kontrollen görs enbart på för- och efternamn.
    public boolean addNewContact(ContactList contact,int index, boolean update) {
        if (findContact(contact.getFirstName()) >= 0 && findContact(contact.getLastName()) >= 0 && !update) {
            System.out.println("Contact already exist.");
            return false;
        }

        if (update) {
            myContacts.add((index-1), contact);
        }
        else {
            myContacts.add(contact);
        }
        return true;

    }

    public boolean deleteContact(int index) {

        if (myContacts.size()>0 && myContacts.size()>(index-1)) {
            myContacts.remove(index - 1);
            return true;
        }
        else {
            return false;
        }

    }

    public void printContacts() {
        System.out.println("List of contacts:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.myContacts.get(i).getFirstName() + " " +
                    this.myContacts.get(i).getLastName() + " " +
                    this.myContacts.get(i).getMail() + " " +
                    this.myContacts.get(i).getPhone());
        }
    }

    public void searchContact() {
        // Added later
    }

}
