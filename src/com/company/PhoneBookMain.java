package com.company;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPersonToBook("Contact1","555-55-55");
        phoneBook.addPersonToBook("Contact2","555-55-66");
        List<String> phonesOfContact = new ArrayList<>();
        phonesOfContact.add("1234560");
        phonesOfContact.add("098765");
        phoneBook.addPersonToBook("Contact1",phonesOfContact);

        List<String> phonesOfContact1 = new ArrayList<>();
        phonesOfContact1.add("222-22-22");
        phonesOfContact1.add("222-22-23");
        List<String> eMailsOfContact1 = new ArrayList<>();
        eMailsOfContact1.add("hhh@mail.ru");
        eMailsOfContact1.add("hhhhh@mail.ru");
        Person contact1 = new Person(phonesOfContact1,eMailsOfContact1);
        phoneBook.addPersonToBook("Contact3",contact1);

        System.out.println("Contact1's phone numbers "+ phoneBook.getPhoneNumber("Contact1"));
        System.out.println("Contact1's email addresses "+ phoneBook.getEmail("Contact1"));
        System.out.println("Contact2's phone numbers "+ phoneBook.getPhoneNumber("Contact2"));
        System.out.println("Contact2's email addresses "+ phoneBook.getEmail("Contact2"));
        System.out.println("Contact3's phone numbers "+ phoneBook.getPhoneNumber("Contact3"));
        System.out.println("Contact3's email addresses "+ phoneBook.getEmail("Contact3"));

    }
}
