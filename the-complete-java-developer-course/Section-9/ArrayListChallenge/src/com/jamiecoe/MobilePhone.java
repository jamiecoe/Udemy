package com.jamiecoe;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addNewContact(String name, String number) {
        System.out.println("Created contact: " + name + " - " + number);
        if (doesContactExist(name, number)) {
            System.out.println("Contact already exists");
        } else {
            contactList.add(new Contact(name, number));
        }
    }

    public void printContactList() {
        for (Contact contact: contactList) {
            contact.printValues();
        }
    }

    public void updateContact(String nameToUpdate, String numberToUpdate, String newName, String newNumber) {
        int index = findContact(nameToUpdate, numberToUpdate);

        if (index < 0) {
            System.out.println("Your contact does not exist in this phone");
        } else if (doesContactExist(newName, newNumber)) {
            System.out.println("Your updated contact already exists!");
        } else {
            updateContact(index, newName, newNumber);
        }
    }

    private void updateContact(int index, String newName, String newNumber) {
        contactList.set(index, new Contact(newName, newNumber));
    }

    public void removeContact(String nameToRemove, String numberToRemove) {
        int index = findContact(nameToRemove, numberToRemove);

        if (index < 0) {
            System.out.println("Your contact does not exist in this phone");
        } else {
            removeContact(index);
        }
    }

    private void removeContact(int index) {
        contactList.remove(index);
    }

    public boolean doesContactExist(String name, String number) {
        return findContact(name, number) >= 0;
    }

    private int findContact(String name, String number) {
        for (Contact contact: contactList) {
            if (contact.isPresent(name, number)) {
                return contactList.indexOf(contact);
            }
        }

        return -1;
    }
}
