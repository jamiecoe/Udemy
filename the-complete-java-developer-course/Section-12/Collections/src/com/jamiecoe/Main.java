package com.jamiecoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);


        /* Comparable and Comparator Lecture */

        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }


        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        // Here we pass in List of seats and our Comparator which has a compare method using price
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);

        /* Collections List Methods Lecture */

//        // This creates a shallow copy of theatre.seats List, they both point to same objects
//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
//        printList(seatCopy);

//        // However, we can reverse order of copy List, and order of original List won't be changed
//        // Remember they are seperate ArrayLists, but the objects in the List point to same place in memory
//        Collections.reverse(seatCopy);
//
//        printList(seatCopy);
//        printList(theatre.getSeats());
//
//        Collections.shuffle(seatCopy);
//        printList(seatCopy);
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//
////        System.out.println(minSeat.getSeatNumber());
////        System.out.println(maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);
//
//        // This will not work!
//        // Here we are making a new Array List of Seats, and initialising it to same length as theatre.seats
//        // We then try and make a deep copy with Collections.copy, providing the destination object and source to copy from
//        // However, setting the size of an ArrayList only sets it's initial capacity, it doesn't actually create elements in those slots
////        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
//        // in order for this to work, newList would have to already contain the same number of Seat objects as theatre.seats
//        // There's rarely a good use case for Collections.copy()
////        Collections.copy(newList, theatre.seats);


    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }

        System.out.println();
        System.out.println("=================================");
    }

    // We made sortList more generic with List<? extends Theatre.Seat>
    // It can sort any kind of list of theatre seats as long as they implement the Comparable interface
    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
