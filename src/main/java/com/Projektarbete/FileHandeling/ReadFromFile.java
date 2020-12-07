package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ListMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public class ReadFromFile {

    private String filePath = "contactList.txt";

    public ListMethods readFromFile() throws IOException, ClassNotFoundException {

        ListMethods list = null;

        try {
            FileInputStream fin = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fin);
            list = (ListMethods) in.readObject();

        } catch (InvalidObjectException e) {
            e.printStackTrace();
            System.out.println("Något gick fel");
        }

        return list;
    }
}
