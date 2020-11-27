package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.WriteToFile;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        WriteToFile filewriter = new WriteToFile();
        filewriter.createFile();



    }
}
