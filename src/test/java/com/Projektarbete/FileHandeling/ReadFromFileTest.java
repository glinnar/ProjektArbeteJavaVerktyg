package com.Projektarbete.FileHandeling;


import com.Projektarbete.ListOperations.ContactList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReadFromFileTest {

    ReadFromFile filereader = new ReadFromFile();

    @Test
    void readFromFileTest() throws IOException, ClassNotFoundException {
        ContactList contactList;
        contactList = filereader.readFromFile();
        Assertions.assertNotNull(contactList);
        contactList.listContacts();

    }


}


