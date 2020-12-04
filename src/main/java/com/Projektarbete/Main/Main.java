package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.WriteToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.Projektarbete.Contact.Contact;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        Contact contact = new Contact("Gurra","Kungen","kungen@kungen.se","0700-112233");
        ArrayList<Contact> list = new ArrayList<>();
        list.add(contact);
        System.out.println(list);
        WriteToFile filewriter = new WriteToFile();
        filewriter.createFile();

        filewriter.writeDataToFile(list);



    }

    private static void printActions() {
        System.out.println("===== MENU =====");
        System.out.println("0: Close Contact Boo" +
                "1: Show All Contacts\n" +
                "2: Add New Contact\n" +
                "3: Update Existing Contact\n" +
                "4: Search Existing Contact\n" +
                "5: Delete Existing Contact");
    }
}
