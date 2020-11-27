package com.Projektarbete.Contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String emailAdress;
    private static final String nameRegex = "^[A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+" +
            "([\\ A-Za-z\\x{00C4}-\\x{00F6}][A-Za-z\\x{00C4}-\\x{00F6}\\'\\-]+)*";
    private static final String telephoneRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
    private static final String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public Contact(String firstName, String lastName, String telephoneNumber, String emailAdress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.emailAdress = emailAdress;
        this.emailAdress = emailAdress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        boolean matchFound;
        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(firstName);
        matchFound = matcher.find();

        try {
            if (matchFound)
                this.firstName = firstName;
            if (!matchFound) throw new NonValidNameException();
        }
        catch (NonValidNameException exc){
            System.out.println(exc);
            exc.printStackTrace();
        }
    }

    public String getLastName() {
        return  this.lastName;
    }

    public void setLastName(String lastName) {
        boolean matchFound;
        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(lastName);
        matchFound = matcher.find();

        try {
            if (matchFound)
                this.lastName = lastName;
            if (!matchFound) throw new NonValidNameException();
        }
        catch (NonValidNameException exc){
            System.out.println(exc);
            exc.printStackTrace();
        }
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        boolean matchFound;
        Pattern pattern = Pattern.compile(telephoneRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(telephoneNumber);
        matchFound = matcher.find();

        try {
            if (matchFound)
                this.telephoneNumber = telephoneNumber;
            if (!matchFound) throw new NonValidTelephoneException();
        }
        catch (NonValidTelephoneException exc){
            System.out.println(exc);
            exc.printStackTrace();
        }
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        boolean matchFound;
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAdress);
        matchFound = matcher.find();

        try {
            if (matchFound)
                this.emailAdress = emailAdress;
            if (!matchFound) throw new NonValidEmailException();
        }
        catch (NonValidEmailException exc){
            System.out.println(exc);
            exc.printStackTrace();
        }
    }
}



