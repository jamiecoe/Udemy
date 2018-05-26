package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        Printer nonDuplexPrinter = new Printer(false);
        Printer duplexPrinter = new Printer(true);

        nonDuplexPrinter.printPage(4);
        nonDuplexPrinter.fillToner(5);

        duplexPrinter.printPage(5);
        duplexPrinter.fillToner(5);

    }
}
