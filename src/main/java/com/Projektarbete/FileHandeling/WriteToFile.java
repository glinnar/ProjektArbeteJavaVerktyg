package com.Projektarbete.FileHandeling;

import com.Projektarbete.Contact.Contact;

import java.io.*;
import java.util.ArrayList;

public class WriteToFile {
    private File contactList = null;
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

    public void writeToFile(ArrayList<Contact> list) {

            try {
                FileOutputStream out = new FileOutputStream("test.txt");
                ObjectOutputStream obs = new ObjectOutputStream(out);
                obs.writeObject(list);
                obs.flush();
                obs.close();

        } catch (IOException e) {
            System.out.println("An error occured");
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