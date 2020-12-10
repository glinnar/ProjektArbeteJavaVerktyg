package com.Projektarbete.Main;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputMismatchEx {

    public void enterInteger() {
        {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Starting program... ");
                System.out.println("Press any num key and enter: ");
                Integer input = scanner.nextInt();
                System.out.println(input);
            } catch (InputMismatchException ex) {
                throw new InputMismatchException("Error - Press any num key and enter: ");
            }
        }
    }
}