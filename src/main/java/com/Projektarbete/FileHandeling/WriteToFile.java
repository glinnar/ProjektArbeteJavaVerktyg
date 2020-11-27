package com.Projektarbete.FileHandeling;

import com.Projektarbete.Contact.Contact;

import java.io.*;
import java.util.ArrayList;

public class WriteToFile {
    private File contactList = null;
    private String filePath;
    private boolean fileExist = false;

    public void createFile(){
        try{
            contactList = new File("C:");
            fileExist = contactList.isFile();
            filePath = contactList.getPath();
            System.out.println("is file? " + fileExist);

            contactList = new File("test.txt");



        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void writeToFile(ArrayList<Contact>list) throws IOException {
        FileOutputStream out = new FileOutputStream("test.txt");
        ObjectOutputStream obs = new ObjectOutputStream(out);
        obs.writeObject(list);
        obs.flush();
        obs.close();
    }


}
