package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ContactList;

import java.io.*;
import java.util.ArrayList;

public class WriteToFile {
    private File contactList = null;

    private String filePath = "contactList.txt";

    public void createFile() throws IOException {
        contactList = new File(this.filePath);
        filePath = contactList.getPath();
       try {
           if (!contactList.exists()) {
               contactList.createNewFile();

               System.out.println("File " +filePath+ "created");
           } else {
               System.out.println("File Allready exits");
           }
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }

        // contactList = new File(this.filePath);
       /* fileExist = contactList.isFile();
        filePath = contactList.getPath();
        System.out.println("is file? " + fileExist);
*/


    }

    public void writeDataToFile(ArrayList<ContactList> list) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(this.contactList);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(list);
            obs.flush();
            obs.close();
        } catch (ObjectStreamException e) {
            e.printStackTrace();
        }


    }
}
