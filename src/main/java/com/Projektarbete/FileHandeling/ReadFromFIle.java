package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ListMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public class ReadFromFIle {

    public ListMethods readFromFile(ListMethods contactList) throws IOException, ClassNotFoundException {

        //ArrayList<PlayerList> slist = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream("StrikerList.txt");
            ObjectInputStream in = new ObjectInputStream(fin);
            //list = (PlayerList) in.readObject();

            ListMethods list;
            list=(ListMethods) in.readObject();

            contactList = list;

            //assert list != null;
            contactList.printContacts();

        } catch (InvalidObjectException e){
            e.printStackTrace();
            System.out.println("Något gick fel");
        }

        return contactList;
    }
}
