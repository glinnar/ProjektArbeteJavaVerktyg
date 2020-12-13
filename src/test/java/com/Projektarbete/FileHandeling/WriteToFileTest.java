package com.Projektarbete.FileHandeling;
import com.Projektarbete.Contact.Contact;
import com.Projektarbete.ListOperations.ContactList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


public class WriteToFileTest {
    WriteToFile fileWriter = new WriteToFile();

    Contact contactExample = new Contact("Charles", "Bukowski",
            "+46 234 563 123", "charles.bukowski@gmail.com");
    @Test
    void createFileTestObject() throws IOException {
        Assertions.assertNotNull(fileWriter);

    }

    @Test
    void createFileTest() throws IOException {
        File file = new File("ContactList.txt");
       fileWriter.createFile();
       Assertions.assertEquals(file.getPath(),fileWriter.getFilePath());


    }

    @Test
    void writeToFileTest() throws IOException {
        fileWriter.createFile();
        ContactList contacList = new ContactList();
        contacList.addContact(contactExample);
        fileWriter.writeDataToFile(contacList);
        Assertions.assertNotNull(contacList);
        System.out.println(fileWriter.getFilePath());

    }

}
