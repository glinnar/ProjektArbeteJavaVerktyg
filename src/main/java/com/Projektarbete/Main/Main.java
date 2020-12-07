package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.ReadFromFile;
import com.Projektarbete.FileHandeling.WriteToFile;
import com.Projektarbete.ListOperations.ListMethods;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ListMethods contactList = new ListMethods();
    private static WriteToFile fileWriter = new WriteToFile();
    private static ReadFromFile fileReader = new ReadFromFile();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Måste lägga metodanropet för filskapandet här utanför while loopen så att vi kan använda filen.
        fileWriter.createFile();
        //Ger contactList data från inläsningen av filen. Måste också ligga utanför while loopen.
        contactList = fileReader.readFromFile();


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
