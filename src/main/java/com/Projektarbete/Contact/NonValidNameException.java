package com.Projektarbete.Contact;

// NonValidNameException handle cases where the given first- or last-name doesn't have a correct format
// (doesn't comply with nameRegex). For instance, a NonValidNameException exception is thrown when
// someone tries to give "2021" as value to firstName instance-variable of a Contact object.
public class NonValidNameException extends Exception{
    public NonValidNameException(String name) {
        super("\n" + "* NonValidNameException: Name '" + name + "' has incorrect format.");
    }
}
