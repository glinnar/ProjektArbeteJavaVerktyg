package com.Projektarbete.Contact;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String emailAddress;

    public Contact(){

    }

    // Regular expression for first- and last-name format check.
    private static final String nameRegex = "^[A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+" +
            "([\\ A-Za-z\\x{00C4}-\\x{00F6}][A-Za-z\\x{00C4}-\\x{00F6}\\'\\-]+)*$";
    // Regular expression for telephone number format check.
    private static final String telephoneRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    // Regular expression for email-address format check.
    private static final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    // Constructor of a contact which includes first- & last-name, telephone-number and email-address.
    public Contact(String firstName, String lastName, String telephoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
    }

    public Contact(String lastName) {
        this.lastName = lastName;
    }


    // Get the first-name of a Contact object.
    public String getFirstName() {
        return this.firstName;
    }

    // Get the last-name of a Contact object.
    public String getLastName() {
        return this.lastName;
    }

    // Get the telephone-number of a Contact object.
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    // Get the email-address of a Contact object.
    public String getEmailAddress() {
        return emailAddress;
    }

    // Validate if a first-name has the right format,
    // otherwise throw exception NonValidNameException.
    public void validateFirstName(String firstName) throws NonValidNameException {
        boolean matchFound;
        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        matchFound = matcher.find();
        if(!matchFound)
            throw new NonValidNameException(firstName);

    }

    // Validate if a last-name has the right format,
    // otherwise throw exception NonValidNameException.
    public void validateLastName(String lastName) throws NonValidNameException {
        boolean matchFound;
        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(lastName);
        matchFound = matcher.find();
        if(!matchFound)
            throw new NonValidNameException(lastName);
    }

    // Validate if a telephone-number has the right number format,
    // otherwise throw exception NonValidTelephoneException.
    public void validateTelephone(String telephone) throws NonValidTelephoneException {
        boolean matchFound;
        Pattern pattern = Pattern.compile(telephoneRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(telephone);
        matchFound = matcher.find();
        if(!matchFound)
            throw new NonValidTelephoneException(telephone);

    }

    // Validate if an email-address has the right email format,
    // otherwise throw exception NonValidEmailException.
    public void validateEmail(String emailAddress) throws NonValidEmailException {
        boolean matchFound;
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAddress);
        matchFound = matcher.find();
        if(!matchFound)
            throw new NonValidEmailException(emailAddress);

    }

    // Set the first-name of an existing Contact object.
    // A NonValidNameException is caught when the input argument doesn't have the right format(nameRegex).
    public void setFirstName(String firstName) {
        try {
            validateFirstName(firstName);
            this.firstName = firstName;
        }
        catch(NonValidNameException exc) {
            System.out.println(exc);
            exc.printStackTrace();
        }
    }

    // Set the last-name of an existing Contact object.
    // A NonValidNameException is caught when the input argument doesn't have the right format(nameRegex).
    public void setLastName(String lastName) {
        try {
            validateFirstName(lastName);
            this.lastName = lastName;
        }
        catch(NonValidNameException exc) {
            System.out.println(exc);
            exc.printStackTrace();
        }
    }

    // Set the telephone-number of an existing Contact object.
    // A NonValidTelephoneException is caught when the input argument
    // doesn't have the right number-format(telephoneRegex).
    public void setTelephoneNumber(String telephoneNumber) {
        try {
            validateTelephone(telephoneNumber);
            this.telephoneNumber = telephoneNumber;
        }
        catch(NonValidTelephoneException exc) {
            System.out.println(exc);
            exc.printStackTrace();
        }
    }


    // Set the email-address of an existing Contact object.
    // A NonValidEmailException is caught when the input argument
    // doesn't have the right email-format(emailRegex).
    public void setEmailAddress(String emailAddress) {
        try {
            validateEmail(emailAddress);
            this.emailAddress = emailAddress;
        }
        catch(NonValidEmailException exc) {
            System.out.println(exc);
            exc.printStackTrace();
        }
    }

    public static Contact createContact(String firstName, String lastName, String telephoneNumber, String emailAddress) {
        return new Contact(firstName, lastName, telephoneNumber, emailAddress);
    }
}


