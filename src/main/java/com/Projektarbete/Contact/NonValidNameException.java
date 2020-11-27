package com.Projektarbete.Contact;

public class NonValidNameException extends Exception{
    NonValidNameException() {
    }

    public String toString() {
        return "* NonValidNameException: Enter a valid name. Do not include numbers or special symbols.";
    }
}
