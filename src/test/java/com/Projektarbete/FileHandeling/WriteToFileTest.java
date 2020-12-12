package com.Projektarbete.FileHandeling;

import com.Projektarbete.Contact.Contact;
import com.Projektarbete.ListOperations.ContactList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

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
        /*Path file = fileDir.resolve("test.txt");

        //@TempDir Path fileDir

        String description = "hej";

        Files.write(file,description.getBytes(StandardCharsets.UTF_8));
        Files.readAllLines(file);

        List<String> actualData = Files.readAllLines(file);

        List<String> expected = Collections.singletonList(description);

        assertEquals(expected,actualData);*/

        File file = new File("contactList.txt");
        fileWriter.createFile();
        Assertions.assertEquals(file.getPath(), fileWriter.getFilePath());

    }

    @Test
    void writeToFileTest() throws IOException {
        fileWriter.createFile();
        ContactList contacList = new ContactList();
        contacList.addContact(contactExample);
        fileWriter.writeDataToFile(contacList);
        Assertions.assertNotNull(contacList);

    }

    @Test
    void writeFile(@TempDir File file) throws IOException {
        file = File.createTempFile("contactList.txt", "hej");
        file.canWrite();
    }
}
