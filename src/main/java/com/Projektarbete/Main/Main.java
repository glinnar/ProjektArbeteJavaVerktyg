package com.Projektarbete.Main;

import com.Projektarbete.Contact.Contact;
import com.Projektarbete.FileHandeling.WriteToFile;
import com.Projektarbete.ListOperations.ContactList;

import java.io.IOException;
import java.util.ArrayList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // String Msg = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        WriteToFile write = new WriteToFile();


<<<<<<< HEAD
    public static void main(String[] args) throws IOException {
        ContactList contact = new ContactList("Gurra","Kungen","kungen@kungen.se","0700-112233");
        ArrayList<ContactList> list = new ArrayList<>();
        list.add(contact);
        System.out.println(list);
        WriteToFile filewriter = new WriteToFile();
        filewriter.createFile();
=======
>>>>>>> fa3f65b449b59ff7120b99e32cfc16c70fb8816c

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
