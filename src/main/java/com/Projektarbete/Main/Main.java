package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.WriteToFile;
import com.Projektarbete.ListOperations.ContactList;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ContactList contact = new ContactList("Gurra","Kungen","kungen@kungen.se","0700-112233");
        ArrayList<ContactList> list = new ArrayList<>();
        list.add(contact);
        System.out.println(list);
        WriteToFile filewriter = new WriteToFile();
        filewriter.createFile();

        filewriter.writeDataToFile(list);



    }
}
