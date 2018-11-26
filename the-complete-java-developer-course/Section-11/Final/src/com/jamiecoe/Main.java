package com.jamiecoe;

public class Main {

    // you can mark a Class as final eg: public final class SomeClass {}
    // This means it cannot be extended by a subclass
    // Marking a method as final means it cannot be overridden

    public static void main(String[] args) {
	    SomeClass one = new SomeClass("one");
	    SomeClass two = new SomeClass("two");
	    SomeClass three = new SomeClass("three");

	    int pw = 345;
	    Password password = new Password(pw);
	    password.storePassword();

	    password.isAllowedIn(pw);
	    password.isAllowedIn(123);

		System.out.println("Main method call");
		StaticInitialisationBlockTest test = new StaticInitialisationBlockTest();

		test.someMethod();
		System.out.println("Owner is " + StaticInitialisationBlockTest.owner);
    }
}
