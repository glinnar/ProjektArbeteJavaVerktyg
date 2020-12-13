package com.Projektarbete.ConctactTest;

import com.Projektarbete.Contact.Contact;
import com.Projektarbete.Contact.NonValidEmailException;
import com.Projektarbete.Contact.NonValidNameException;
import com.Projektarbete.Contact.NonValidTelephoneException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    // Creation of a Contact object.
    Contact contactExample = new Contact("Charles","Bukowski",
            "+46 234 563 123","charles.bukowski@gmail.com");

    // ---  First Name Tests  --------------------------------------------------------------------------
    @Test
    @Order(1)
    // Check if the setFirstName() method changes the firstName instance-variable of a Contact object.
    void setFirstName_whenFirstNameValid_contactWithNewFirstName() {
        contactExample.setFirstName("Anders Ö");
        assertEquals("Anders Ö",contactExample.getFirstName());
    }

    @Test
    @Order(2)
    // Check if validateFirstName() method doesn't throw a NonValidNameException
    // when a first-name of proper format is given as input argument.
    void ValidateName_whenFirstNameIsValid_doesntThrowNonValidNameException() {
        assertDoesNotThrow(() -> contactExample.validateFirstName("Anders Ö"));
    }

    @Test
    @Order(3)
    // Check if validateFirstName() method throws a NonValidNameException
    // when a first-name of improper format is given as input argument.
    void ValidateFirstName_whenFirstNameIsNotValid_throwsNonValidNameException() {
        assertThrows(NonValidNameException.class, () -> contactExample.validateFirstName("345"));
    }

    // ---  Last Name Tests  --------------------------------------------------------------------------
    @Test
    @Order(4)
        // Check if the setLastName() method changes the lastName instance-variable of a Contact object.
    void setLastName_whenLastNameValid_contactWithNewLastName() {
        contactExample.setLastName("Axelsson");
        assertEquals("Axelsson",contactExample.getLastName());
    }

    @Test
    @Order(5)
    // Check if validateLastName() method doesn't throw a NonValidNameException
    // when a last-name of proper format is given as input argument.
    void ValidateLastName_whenLastNameIsValid_doesntThrowNonValidNameException() {
        assertDoesNotThrow(() -> contactExample.validateLastName("Bukowski"));
    }

    @Test
    @Order(6)
    // Check if validateLastName() method throws a NonValidNameException
    // when a last-name of improper format is given as input argument.
    void ValidateLastName_whenLastNameIsNotValid_throwsNonValidNameException() {
        assertThrows(NonValidNameException.class, ()
                -> contactExample.validateLastName(" wrong345Name asd"));
    }

    // ---  Telephone Number Tests  --------------------------------------------------------------------------
    @Test
    @Order(7)
    // Check if the setTelephoneNumber() method changes the telephoneNumber instance-variable of a Contact object.
    void setTelephoneNumber_whenTelephoneValid_contactWithNewTelephoneNumber() {
        contactExample.setTelephoneNumber("098 76 12 345");
        assertEquals("098 76 12 345",contactExample.getTelephoneNumber());
    }

    @Test
    @Order(8)
    // Check if validateTelephone() method doesn't throw a NonValidTelephoneException
    // when a telephone of proper format is given as input argument.
    void ValidateTelephone_whenTelephoneNumberIsValid_doesntThrowNonValidTelephoneException() {
        assertDoesNotThrow(() -> contactExample.validateTelephone("+46 234 563 123"));
    }

    @Test
    @Order(9)
    // Check if validateTelephone() method throws a NonValidTelephoneException
    // when a telephone of improper format is given as input argument.
    void validateTelephone_whenTelephoneNumberIsNotValid_throwsNonValidTelephoneException() {
        assertThrows(NonValidTelephoneException.class,
                () -> contactExample.validateTelephone("Wrong Telephone Number"));
    }

    // ---  Email Address Tests  --------------------------------------------------------------------------
    @Test
    @Order(10)
    // Check if the setEmailAdress() method changes the emailAdress instance-variable of a Contact object.
    void setEmailAddress_whenEmailAddressValid_contactWithNewEmailAddress() {
        contactExample.setEmailAddress("koutsoubas@kke.gr");
        assertEquals("koutsoubas@kke.gr",contactExample.getEmailAddress());
    }

    @Test
    @Order(11)
    // Check if validateEmailAddress() method doesn't throw a NonValidEmailException
    // when an email of proper format is given as input argument.
    void ValidateEmailAddress_whenEmailAddressIsValid_doesntThrowNonValidEmailException() {
        assertDoesNotThrow(() -> contactExample.validateEmail("giorgos@gmail.gr"));
    }

    @Test
    @Order(12)
    // Check if validateEmailAddress() method throws a NonValidEmailException
    // when an email of improper format is given as input argument.
    void validateEmailAddress_whenEmailAddressIsNotValid_throwsNonValidEmailException() {
        assertThrows(NonValidEmailException.class, () -> contactExample.validateEmail("aaa1234"));
    }

}