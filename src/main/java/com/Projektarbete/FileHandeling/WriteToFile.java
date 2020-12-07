package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ListMethods;

import java.io.*;

public class WriteToFile {
    private File contactList = null;
    private String filePath = "contactList.txt";

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

<<<<<<< HEAD
    public void writeDataToFile(ListMethods contactList) throws IOException {
=======
    // contactList = new File(this.filePath);


    // contactList = new File(this.filePath);

       /* fileExist = contactList.isFile();
        filePath = contactList.getPath();
        System.out.println("is file? " + fileExist);
*/


    public void writeDataToFile(ArrayList<ContactList> list) throws IOException {
>>>>>>> ab28db27e48672bb11fbb311c47790263e315953
        try {
            FileOutputStream out = new FileOutputStream(this.contactList);
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(contactList);
            obs.flush();
            obs.close();
        } catch (ObjectStreamException e) {

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }


    }
}
<<<<<<< HEAD

=======
>>>>>>> ab28db27e48672bb11fbb311c47790263e315953
