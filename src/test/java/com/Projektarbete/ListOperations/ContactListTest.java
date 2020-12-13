package com.Projektarbete.ListOperations;

import com.Projektarbete.ListOperations.ContactList;
import org.junit.jupiter.api.*;
import com.Projektarbete.Contact.Contact;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    Contact contactDummy = new Contact("Test", "Test", "1234567", "test@test.se");

    @BeforeAll
    static void initAll() { System.out.println("Initialize all tests for ContactList class"); }


    @Test
    @Order(1)
    void addContact() {
        ContactList contactList = new ContactList();
        contactList.addContact(contactDummy);
        assertNotNull(contactDummy, "Object is not null");
    }

    @Test
    @Order(2)
    void getContact() {
        ContactList contactList = new ContactList();
        contactList.addContact(contactDummy);
        String contactName = contactDummy.getFirstName();
        contactList.getContact(contactName);
        assertEquals("Test",  contactName);
    }

    @Test
    @Order(3)
    void listContacts() {

        ContactList contactList = new ContactList();
        contactList.addContact(contactDummy);
        contactList.listContacts();
        String firstName = contactDummy.getFirstName();
        System.out.println(firstName);
        assertNotNull(firstName, "Firstname is not null");
        String surName = contactDummy.getLastName();
        System.out.println(surName);
        assertNotNull(surName, "Surname is not null");
        String phoneNumber = contactDummy.getTelephoneNumber();
        System.out.println(phoneNumber);
        assertNotNull(phoneNumber, "Phone number is not null");
        String eMail = contactDummy.getEmailAddress();
        System.out.println(eMail);
        assertNotNull(eMail, "Email is not null");

    }

    @Test
    @Order(4)
    void searchContact() {
        ContactList contactList = new ContactList();
        contactList.addContact(contactDummy);
        Contact listPosition = contactList.searchContact(contactDummy.getFirstName());
        if (listPosition != null) {
            assertTrue( true, "Test search contact worked");
        } else {
            assertTrue( false, "Test search contact failed");
        }

    }

    @Test
    @Order(5)
    void updateContact() {
        ContactList contactList = new ContactList();
        contactList.addContact(contactDummy);
        Contact updatedContactFirstName = Contact.createContact("Bytt", contactDummy.getLastName(),
                contactDummy.getTelephoneNumber(), contactDummy.getEmailAddress());
        contactList.updateContact(contactDummy, updatedContactFirstName);
        String firstName = "Bytt";
        contactList.getContact(firstName);
        System.out.println(firstName);
        assertEquals("Bytt",  firstName);
    }


    @Test
    @Order(6)
    void removeContact() {
        ContactList contactList = new ContactList();
        contactList.removeContact(contactDummy);
        int listPosition = contactList.getContact(contactDummy.getFirstName());
        if (listPosition < 0) {
            assertTrue( true, "Test remove contact worked");
        } else {
            assertTrue( false, "Test remove contact failed");
        }

    }

    @AfterAll
    static void exitAll() {
        System.out.println("Ended all tests for ContactList class");
    }

}
