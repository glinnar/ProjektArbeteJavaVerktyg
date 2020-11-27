package com.Projektarbete.Contact;

public class NonValidTelephoneException extends Exception{
    NonValidTelephoneException() {
    }

    public String toString() {
        return "* NonValidTelephoneException: Enter a telephone number. Avoid special characters or letters.";
    }
}
