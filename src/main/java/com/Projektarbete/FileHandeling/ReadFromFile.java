package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ContactList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public class ReadFromFile {

    private String filePath = "contactList.txt";

    public ContactList readFromFile() throws IOException, ClassNotFoundException {

        ContactList contactList = null;

        try {
            FileInputStream fin = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fin);
            contactList = (ContactList) in.readObject();

        } catch (InvalidObjectException e) {
            e.printStackTrace();
            System.out.println("Något gick fel");
        }

        return contactList;
    }
}
