package com.jamiecoe;

public class StaticInitialisationBlockTest {
    public static final String owner;

    // This is static initialisation block
    // It's like a constructor for static variables
    static {
        owner = "Jamie";
        System.out.println("1st static initialisation block called");
    }

    public StaticInitialisationBlockTest() {
        System.out.println("Constructor called");
    }

    // You can have as many SIBs as you like in a class
    // They will all be called before the constructor, regardless of what order they are declared
    static {
        System.out.println("2nd static initialisation block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
