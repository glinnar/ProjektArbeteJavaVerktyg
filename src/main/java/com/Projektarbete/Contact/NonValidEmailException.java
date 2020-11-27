package com.Projektarbete.Contact;

public class NonValidEmailException extends Exception{
    NonValidEmailException() {
    }

    public String toString() {
        return "* NonValidEmailException: Wrong email address format.";
    }
}
