package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.WriteToFile;
import com.Projektarbete.ListOperations.ContactList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        ContactList contact = new ContactList("Gurra", "Kungen", "kungen@kungen.se", "0700-112233");
        ArrayList<ContactList> list = new ArrayList<>();
        list.add(contact);
        System.out.println(list);
        WriteToFile filewriter = new WriteToFile();
        filewriter.createFile();


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
