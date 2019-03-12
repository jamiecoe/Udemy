package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        // How does Thread know what to do with a Lambda?
        // One of Thread class constructors accepts a Runnable parameter
        // Also it knows that Runnable interface only has one method (eg: run()) which takes no parameters
        // So its able to match the lambda expression (which also has no parameters) with the run() method
        // Lambda expressions can only be used like this with an interface that contains one method
	    new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Printing another from the Runnable");
        }).start();
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}
