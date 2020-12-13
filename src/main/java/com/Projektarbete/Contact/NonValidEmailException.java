package com.Projektarbete.Contact;

// NonValidEmailException handle cases where the given email doesn't have a correct format
// (doesn't comply with emailRegex). For instance a NonValidEmailException exception is thrown when
// someone tries to give "testEmail@gmail.ccccccccccccom" or "testEmail" as value to emailAdress
// instance variable of a Contact object.
public class NonValidEmailException extends Exception {
    public NonValidEmailException(String emailAdress) {
        super("\n" + "* NonValidEmailException: Email address " + emailAdress + " has incorrect format.");
    }
}
