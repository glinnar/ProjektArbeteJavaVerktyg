package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.ReadFromFile;
import com.Projektarbete.FileHandeling.WriteToFile;
import com.Projektarbete.ListOperations.ContactList;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList = new ContactList();
    private static WriteToFile fileWriter = new WriteToFile();
    private static ReadFromFile fileReader = new ReadFromFile();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Måste lägga metodanropet för filskapandet här utanför while loopen så att vi kan använda filen.
        fileWriter.createFile();
        //Ger contactList data från inläsningen av filen. Måste också ligga utanför while loopen.
        contactList = fileReader.readFromFile();



        boolean waitingForCorrectInput = true;

        while (waitingForCorrectInput) {
            InputMismatchEx keyEnter = new InputMismatchEx();
            try {
                keyEnter.enterInteger();
                waitingForCorrectInput = false;
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }
        }


        boolean quit = false;
        System.out.println("<<< CONTACT BOOK >>>");
        printActions();

        while (!quit) {
            System.out.print("Choose from menu (6 to show menu): ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nClosing...");
                    quit = true;
                    break;

                case 1:
                    contactList.printContacts();
                    break;

                case 2:
                    //addNewContact();
                    break;

                case 3:
                    //updateContact();
                    break;

                case 4:
                    //removeContact();
                    break;

                case 5:
                    //queryContact();
                    break;

                case 6:
                    printActions();
                    break;

                default:
                    System.out.println("Choose number from menu.");
                    break;

            }
        }
    }



    private static void printActions() {
        System.out.println("========== MENU ==========");
        System.out.println("0: Close Contact Book\n" +
                "1: Show All Contacts\n" +
                "2: Add New Contact\n" +
                "3: Update Existing Contact\n" +
                "4: Search Existing Contact\n" +
                "5: Delete Existing Contact");
        System.out.println("========== **** ==========");
    }

}
