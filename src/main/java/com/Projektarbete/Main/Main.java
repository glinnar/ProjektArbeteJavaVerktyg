package com.Projektarbete.Main;

import com.Projektarbete.Contact.Contact;
import com.Projektarbete.FileHandeling.ReadFromFile;
import com.Projektarbete.FileHandeling.WriteToFile;
import com.Projektarbete.ListOperations.ContactList;

import java.io.File;
import java.io.FileInputStream;
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
        FileInputStream fin = new FileInputStream("ContactList.txt");
        File file = new File("ContactList.txt");
        if (file.length() != 0) {
            contactList = fileReader.readFromFile();
        }

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
                    contactList.listContacts();
                    break;

                case 2:

                    System.out.println("Add contact.");
                    addNewContact();
                    fileWriter.writeDataToFile(contactList);

                    contactList.listContacts();
                    break;

                case 3:
                    System.out.println("Update contact");
                    updateContact();
                    fileWriter.writeDataToFile(contactList);
                    break;

                case 4:
                    System.out.println("Search contact.");
                    searchContact();
                    break;

                case 5:
                    System.out.println("Remove contact.");
                    removeContact();
                    fileWriter.writeDataToFile(contactList);
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

    private static Contact addNewContact() throws IOException, ClassNotFoundException {
        System.out.print("Enter your firstname: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String telNumber = scanner.nextLine();
        System.out.print("Enter your email: ");
        String eMail = scanner.nextLine();

        Contact newContact = new Contact(firstName, lastName, telNumber, eMail);
        if (contactList.addContact(newContact)) {
            System.out.println("Added contact: firstname: " + firstName + "| " +
                    "surname: " + lastName + "| " + "phone number: " + telNumber +
                    " |" + " email:" + eMail
            );

        }

        return newContact;
    }

    private static void removeContact() {
        System.out.println("Enter contact to remove.");
        String contactName = scanner.nextLine();
        Contact contactInList = contactList.searchContact(contactName);
        if (contactInList == null) {
            System.out.println("Could not find contact.");
            return;
        }
        if (contactList.removeContact(contactInList)) {
            System.out.println("The contact was removed.");
        } else {
            System.out.println("Failed to remove contact.");
        }

    }

    private static void searchContact() {
        System.out.println("Enter a contact to search for!");
        String contactName = scanner.nextLine();
        Contact contactInList = contactList.searchContact(contactName);
        if (contactInList == null) {
            System.out.println("Contact does not exist.");
        } else {
            System.out.println("Firstname: " + contactInList.getFirstName() + " Surname: " +
                    contactInList.getLastName() + " Tel: " + contactInList.getTelephoneNumber() +
                    " Email: " + contactInList.getEmailAddress()
            );
        }

    }

    private static void updateContact() {
        System.out.println("Enter contact to update: ");
        String contactName = scanner.nextLine();
        Contact listContact = contactList.searchContact(contactName);
        if (listContact == null) {
            System.out.println("Contact does not exist.");
            return;
        }
        System.out.println("Select what to update");
        System.out.println("1. Update Firstname");
        System.out.println("2. Update Surname");
        System.out.println("3. Update phone number");
        System.out.println("4. Update email");
        int updateChoice = scanner.nextInt();
        scanner.nextLine();

        switch (updateChoice) {
            case 1:

                System.out.println("Enter new firstname for contact");
                String newFirstName = scanner.nextLine();
                Contact updatedContactFirstName = Contact.createContact(newFirstName, listContact.getLastName(),
                        listContact.getTelephoneNumber(), listContact.getEmailAddress());


                if ((contactList.updateContact(listContact, updatedContactFirstName))) {
                    System.out.println("Contact firstname updated.");

                } else {
                    System.out.println("Could not update contact firstname.");
                }

                break;

            case 2:
                System.out.println("Enter new surname for contact");
                String newSurName = scanner.nextLine();
                Contact updatedContactSurName = Contact.createContact(listContact.getFirstName(), newSurName,
                        listContact.getTelephoneNumber(), listContact.getEmailAddress());


                if ((contactList.updateContact(listContact, updatedContactSurName))) {
                    System.out.println("Contact surname updated.");

                } else {
                    System.out.println("Could not update contact surname.");
                }
                break;

            case 3:
                System.out.println("Enter new phone number for contact");
                String newPhoneNumber = scanner.nextLine();
                Contact updatedContactPhone = Contact.createContact(listContact.getFirstName(), listContact.getLastName(),
                        newPhoneNumber, listContact.getEmailAddress());


                if ((contactList.updateContact(listContact, updatedContactPhone))) {
                    System.out.println("Contact phone number updated.");

                } else {
                    System.out.println("Could not update contact phone number.");
                }
                break;

            case 4:
                System.out.println("Enter new email for contact");
                String newEmail = scanner.nextLine();
                Contact updatedContactEmail = Contact.createContact(listContact.getFirstName(), listContact.getLastName(),
                        listContact.getTelephoneNumber(), newEmail);


                if ((contactList.updateContact(listContact, updatedContactEmail))) {
                    System.out.println("Contact email updated.");

                } else {
                    System.out.println("Could not update contact email.");
                }
                break;

        }

    }

}
