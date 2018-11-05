package com.jamiecoe;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    // In Java, it's possible to nest a class within a class
    // Four types of nested classes:
    //  - Static
    //  - Non-Static (Inner)
    //      - Local (inner class defined inside of scope block eg: method)
    //      - Anonymous (nested class without a class name)
    public static void main(String[] args)  {
//        Gearbox mcLaren = new Gearbox(6);

        // this is how you define instance of inner class Gear
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);

        // these are incorrect ways of doing it
//        Gearbox.Gear second = new Gearbox.Gear(2, 15.4);
//        Gearbox.Gear third = new mcLaren.Gear(3, 17.8);

//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(3);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));

        // This is an example of using a Local class
        // We've defined it inside a scope block (ie: main())
        // It's scope is restricted to the block
        // Useful when attaching the same onClick method to multiple buttons
//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.setOnClickListener(new ClickListener());


        // Anonymous class is a Local class without a name
        // They have to be declared and instantiated at the same time
        // They're used when a Local class in only required once
        // Very common for attaching event handlers to a user interface
        // Here we declare and instantiate an anonymous class inside btn.setOnClickListener()
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });

        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
