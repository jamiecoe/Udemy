package com.jamiecoe;

import java.util.ArrayList;

public class Main {

	// Why use Interfaces instead of parent class and Inheritance?
	// In this example, a modern mobile phone can actually do alot more than desktop (eg: browse internet etc)
	// Really a mobile only needs to implement telephone functionality, amongst its other methods
	// Therefore it's probably better to use an interface rather than a class
	// You need to consider the relationship between the class and what it's extending or implementing

	// In Java, a class can only inherit from one super class
	// However, a class can implement multiple Interfaces

	// Consider an animal super class that different classes inherit from
	// Not all animals can walk so you probably don't want a walk() method in your super class
	// A walk interface could be really handy though, for animals that do walk
	// Eg: a Dog could extend Animal and implement Walk


    public static void main(String[] args) {
        // you can use datatype of interface (or class)
	    ITelephone timsPhone = new DeskPhone(123456);
	    timsPhone.powerOn();
	    timsPhone.callPhone(123456);
	    timsPhone.answer();

	    ITelephone mobilePhone = new MobilePhone(123456);
	    mobilePhone.powerOn();
	    mobilePhone.callPhone(123456);
	    mobilePhone.answer();

		ArrayList<ITelephone> phoneList = new ArrayList<ITelephone>();
		// because both phones use the ITelephone data type, we can put them in an array list together
		// even though they are both different classes
		phoneList.add(timsPhone);
		phoneList.add(mobilePhone);

    }
}
