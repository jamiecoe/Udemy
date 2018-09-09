package com.jamiecoe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "New Cross");
        addInOrder(placesToVisit, "Deptford");
        addInOrder(placesToVisit, "Dulwich");
        addInOrder(placesToVisit, "Peckham");

        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        // Iterators allow you to loop over things like in a for loop
        Iterator<String> i = linkedList.iterator();

        while(i.hasNext()) {
            // i.next() gets the value, and moves to the next value
            System.out.println(i.next());
        }
        System.out.println("=================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        // ListIterators give more flexibility than traditional iterators
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            // compareTo() is a string method that check value against another string
            // If two strings are equal, it returns 0
            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison == 0) {
                System.out.println(newCity + " already exists in this list");
                return false;
            } else if (comparison > 0) {
                // new city is higher in alphabet, so it should go before current LinkedList value

                // because we already already used next() to get the comparison value, we moved past...
                // the LinkedList value we want to insert newCity before
                // we need to use previous(), so we can go back before that value
                stringListIterator.previous();
                // now we add the newCity in the correct place
                stringListIterator.add(newCity);
                // leave function once newCity has been inserted
                return true;
            }

            // otherwise, go back to top and compare newCity with next value in list
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in list");
        } else {
            System.out.println("Now visiting " + listIterator.next());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Vaction over!");
                    quit = true;
                    break;
                case 1:
                    // if we were previously going backwards
                    if (!goingForward) {
                        // check we're not at end of list
                        if (listIterator.hasNext()) {
                            // we need to call next() to skip over current value
                            // remember listIterators go between the values!
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("now visiting " + listIterator.next());
                    } else {
                        System.out.println("reached end of list");
                    }
                    break;
                case 2:
                    // if we were previously going forwards
                    if (goingForward) {
                        // check we're not at start of list
                        if (listIterator.hasPrevious()) {
                            // we need to call previous() to skip back from current value
                            // remember listIterators go between the values!
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("going back to " + listIterator.previous());
                    } else {
                        System.out.println("reached start of list");
                    }
                    break;
            }
        }
    }
}
