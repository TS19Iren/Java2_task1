package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2. Написать простой класс PhoneBook(внутри использовать HashMap):
 * * - В качестве ключа использовать фамилию
 * * - В каждой записи всего два поля: phone, e-mail
 * * - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
 * * и отдельный метод для поиска e-mail по фамилии.
 * * Следует учесть, что под одной фамилией может быть несколько записей. Итого должно получиться 3 класса Main, PhoneBook, Person.
 */

public class PhoneBook {
    private Map<String, Person> phoneBook = new HashMap<>();

    public void addPersonToBook(String surname, Person contacts) {
        if (phoneBook.containsKey(surname)) {
            Person person = phoneBook.get(surname);
            person.getPhone().addAll(contacts.getPhone());
            person.getE_mail().addAll(contacts.getE_mail());
            phoneBook.put(surname, person);
        } else phoneBook.put(surname, contacts);
    }

    public void addPersonToBook(String surname, List<String> phones) {
        if (phoneBook.containsKey(surname)) {
            Person person = phoneBook.get(surname);
            person.getPhone().addAll(phones);
            phoneBook.put(surname, person);
        } else {
            Person newPerson = new Person(phones);
            phoneBook.put(surname,newPerson);
        }
    }
    public void addPersonToBook (String surname, String phone){
        if (phoneBook.containsKey(surname)){
            Person person = phoneBook.get(surname);
            person.getPhone().add(phone);
            phoneBook.put(surname,person);
        } else {
            Person newPerson = new Person(phone);
            phoneBook.put(surname,newPerson);
        }

    }

    public List<String> getPhoneNumber(String surname) {
        if (phoneBook.containsKey(surname)) {
            Person phoneNumber = phoneBook.get(surname);
            return phoneNumber.getPhone();
        }
        List<String> empty = new ArrayList<>(0);
        return empty;
    }

    public List<String> getEmail(String surname) {
        if (phoneBook.containsKey(surname)) {
            Person eMail = phoneBook.get(surname);
            return eMail.getE_mail();
        }
        List<String> empty = new ArrayList<>(0);
        return empty;
    }


}
