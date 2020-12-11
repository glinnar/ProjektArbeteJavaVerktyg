package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ContactList;

import java.io.*;

public class WriteToFile {
    private File fileList = null;
    private String filePath = "ContactList.txt";

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