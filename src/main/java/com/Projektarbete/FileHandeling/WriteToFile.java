package com.Projektarbete.FileHandeling;

<<<<<<< HEAD
import com.Projektarbete.ListOperations.ContactList;
=======
import com.Projektarbete.Contact.Contact;
>>>>>>> fa3f65b449b59ff7120b99e32cfc16c70fb8816c

import java.io.*;
import java.util.ArrayList;

public class WriteToFile {
    private File contactList = null;
<<<<<<< HEAD

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
=======
    private String filePath;
    private boolean fileExist = false;
    private FileWriter fileWriter;

    public void createFile() throws IOException {
        try {
            contactList = new File("Text.txt");
            filePath = contactList.getPath();
            fileExist = contactList.isFile();

            if (contactList.createNewFile()) {
                System.out.println("File created: " + contactList.getName() + " Finns filen? " + fileExist);
            } else {
                System.out.println("File aldready Exits " + filePath);
            }

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
>>>>>>> fa3f65b449b59ff7120b99e32cfc16c70fb8816c

    public void writeToFile(ArrayList<Contact> list) {

            try {
                FileOutputStream out = new FileOutputStream("test.txt");
                ObjectOutputStream obs = new ObjectOutputStream(out);
                obs.writeObject(list);
                obs.flush();
                obs.close();

<<<<<<< HEAD
    }

    public void writeDataToFile(ArrayList<ContactList> list) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(this.contactList);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(list);
            obs.flush();
            obs.close();
        } catch (ObjectStreamException e) {
=======
        } catch (IOException e) {
            System.out.println("An error occured");
>>>>>>> fa3f65b449b59ff7120b99e32cfc16c70fb8816c
            e.printStackTrace();
        }


    }
}

/*
*    try {
            File file = new File("Text.txt");

            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }
            else {
                System.out.println("File aldready Exits");
            }

        }catch (IIOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }*/