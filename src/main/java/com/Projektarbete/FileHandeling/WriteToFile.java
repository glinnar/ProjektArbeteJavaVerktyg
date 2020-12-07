package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ListMethods;

import java.io.*;

public class WriteToFile {
    private File contactList = null;
    private String filePath = "contactList.txt";

    //Skapar ett nytt File Objekt som får värdet av instansvariabeln filePath.
    // Om filen inte finns så skapas en ny,annars så skrivs ett meddelande ut att filen finns.
    public void createFile() throws IOException {
        contactList = new File(this.filePath);
        filePath = contactList.getPath();
        try {
            if (!contactList.exists()) {
                contactList.createNewFile();

                System.out.println("File " + filePath + "created");
            } else {
                System.out.println("File Allready exits");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    // Skickar med ContactList och skriver dess innehåll till fil.
    
    public void writeDataToFile(ListMethods contactList) throws IOException {

        try {
            FileOutputStream out = new FileOutputStream(this.contactList);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(contactList);
            obs.flush();
            obs.close();
        } catch (ObjectStreamException e) {
            e.printStackTrace();

        }
    }
}
