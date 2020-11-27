package com.Projektarbete.ListOperations;

public class ContactList {

        private String firstName;
        private String lastName;
        private String mail;
        private String phone;

        // Superklass för skapandet av en person som skall läggas till i vår arraylist

        // Konstruktor
        public ContactList(String firstName, String lastName, String mail, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.mail = mail;
            this.phone = phone;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getMail() {
            return mail;
        }

        public String getPhone() {
        return phone;
    }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
        this.lastName = lastName;
    }

        public void setMail(String mail) {
        this.mail = mail;
    }

        public void setPhone(String phone) {
        this.phone = phone;
    }

        public static ContactList createContactList(String firstName, String lastName, String mail, String phone) {
            return new ContactList(firstName, lastName, mail, phone);
        }

}
