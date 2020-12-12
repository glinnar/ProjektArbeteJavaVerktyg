package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ContactList;

import java.io.*;

public class WriteToFile {
    private File fileList = null;
    private String filePath = "ContactList.txt";



    public String getFilePath() {
        return filePath;
    }

    //Skapar ett nytt File Objekt som får värdet av instansvariabeln filePath.
    // Om filen inte finns så skapas en ny,annars så skrivs ett meddelande ut att filen finns.

    public void createFile() throws IOException {
        fileList = new File(this.filePath);
        filePath = fileList.getPath();
        try {
            if (!fileList.exists()) {
                fileList.createNewFile();

                System.out.println("File " + filePath + " created");
            } else {
                System.out.println("File Already exits");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeDataToFile(ContactList list) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(this.fileList);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(list);
            obs.flush();
            obs.close();
            out.close();
        } catch (ObjectStreamException e) {
            e.printStackTrace();
        }


    }
}