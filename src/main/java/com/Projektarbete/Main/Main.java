package com.Projektarbete.Main;

import com.Projektarbete.FileHandeling.WriteToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // String Msg = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        WriteToFile write = new WriteToFile();



    }
}
