package com.Projektarbete.FileHandeling;

import com.Projektarbete.ListOperations.ListMethods;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ReadFromFileTest {
    ReadFromFile filereader = new ReadFromFile();


    @Test
    void readFromFileTest() throws IOException, ClassNotFoundException {
        filereader.readFromFile();

        ListMethods list = new ListMethods();

        list = filereader.readFromFile();

        System.out.println(filereader.readFromFile());

       // Assertions.assertArrayEquals(list,filereader.readFromFile());
    }


}
