package com.Projektarbete.Main;

import com.Projektarbete.Contact.Contact;
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


        // Felhantering samt JUnit test del.
        // Hanterar felet när man inmatar något annat än siffor.
        // Användaren måste inmata siffror här för att starta programmet.

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


        // While- och switch-satsen för att hantera menyn.
        // Den loopar tills anvämdaren mata in 0.

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
                    addNewContact();
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

    private static void addNewContact() {
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Email Address: ");
        String mail = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phone = scanner.nextLine();

        // Ett objekt direkt där man kommer åt metoden createContact i Contact klassen
        Contact newContact = Contact.createContact(firstName, lastName, mail, phone);

//        if (listMethods.addNewContact(newContact, )) {
//            System.out.println("Ny kontakt tillagd: Namn: " + name + ", Telefon: " + phone);
//        } else {
//            System.out.println("Kan inte lägga till, " + name + " finns redan.");
//        }
    }

//    private static void updateContact() {
//        System.out.println("Skriv in namnet på kontakten som skall uppdateras: ");
//        String name = scanner.nextLine();
//        Contact existingContactRecord = mobilePhone.queryContact(name);
//        if(existingContactRecord == null) {
//            System.out.println("Kan inte hitta kontakten.");
//            return;
//        }
//
//        System.out.print("Skriv in nytt namn för kontakten: ");
//        String newName = scanner.nextLine();
//        System.out.print("Skriv in nytt telefonnummer för kontakten: ");
//        String newNumber = scanner.nextLine();
//        Contact newContact = Contact.createContact(newName, newNumber);
//        if(mobilePhone.updateContact(existingContactRecord, newContact)) {
//            System.out.println("Kontakten är uppdaterad!");
//        } else {
//            System.out.println("Gick inte att updatera.");
//        }
//    }
//
//    private static void removeContact() {
//        System.out.println("Skriv in namnet på kontakten som skall tas bort: ");
//        String name = scanner.nextLine();
//        Contact existingContactRecord = mobilePhone.queryContact(name);
//        if (existingContactRecord == null) {
//            System.out.println("Kan inte hitta kontakten.");
//            return;
//        }
//
//        if(mobilePhone.removeContact(existingContactRecord)) {
//            System.out.println("Kontakten har tagits bort!");
//        } else {
//            System.out.println("Kan inte ta bort kontakten.");
//        }
//    }
//
//    private static void queryContact() {
//        System.out.println("Skriv in namnet på kontakten: ");
//        String name = scanner.nextLine();
//        Contact existingContactRecord = mobilePhone.queryContact(name);
//        if (existingContactRecord == null) {
//            System.out.println("Kan inte hitta kontakten.");
//            return;
//        }
//
//        System.out.println("Namn: " + existingContactRecord.getName() + " telefonnummer är " + existingContactRecord.getPhoneNumber());
//    }



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
