package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ContactList;

import java.io.*;

public class WriteToFile {
    private File contactListFile = null;
    private String filePath = "contactList.txt";

    //Skapar ett nytt File Objekt som får värdet av instansvariabeln filePath.
    // Om filen inte finns så skapas en ny,annars så skrivs ett meddelande ut att filen finns.
    public void createFile() throws IOException {
        contactListFile = new File(this.filePath);
        filePath = contactListFile.getPath();
        try {
            if (!contactListFile.exists()) {
                contactListFile.createNewFile();

                System.out.println("File " + filePath + "created");
            } else {
                System.out.println("File Allready exits");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    // Skickar med ContactList och skriver dess innehåll till fil.
    
    public void writeDataToFile(ContactList contactList) throws IOException {

        try {
            FileOutputStream out = new FileOutputStream(this.contactListFile);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(contactList);
            obs.flush();
            obs.close();
        } catch (ObjectStreamException e) {
            e.printStackTrace();

        }
    }
}
