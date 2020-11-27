package com.Projektarbete.FileHandeling;

import java.io.File;

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

            contactList = new File("Test.txt");
            //fileExist





        }catch (Exception e){
            e.printStackTrace();

        }
    }


}
