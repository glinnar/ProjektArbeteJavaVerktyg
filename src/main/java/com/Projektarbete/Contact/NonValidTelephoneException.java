package com.Projektarbete.Contact;

// NonValidTelephoneException handle cases where the given telephone-number doesn't have a correct format
// (doesn't comply with telephoneRegex). For instance, a NonValidTelephoneException exception is thrown when
// someone tries to give "Albert" as value to telephoneNumber instance-variable of a Contact object.
public class NonValidTelephoneException extends Exception{
    public NonValidTelephoneException(String telephone) {
        super("\n" + "* NonValidTelephoneException: Telephone '" + telephone + "' has incorrect format.");
    }
}
