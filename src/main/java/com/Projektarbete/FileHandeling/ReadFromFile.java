package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ContactList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public class ReadFromFile {

    public ContactList readFromFile() throws IOException, ClassNotFoundException {

        ContactList contact = null;
        try {
            FileInputStream fin = new FileInputStream("ContactList.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            contact =(ContactList) in.readObject();
            in.close();
            fin.close();

        } catch (InvalidObjectException e){
            e.printStackTrace();
            System.out.println("An error occured!");
        }

        return contact;

    }
}