package com.jamiecoe;

public class Printer {
    private int tonerPercentageLevel;
    private int printedPages;
    private boolean duplexPrinter;

    public Printer(boolean duplexPrinter) {
        this.duplexPrinter = duplexPrinter;
        this.tonerPercentageLevel = 100;
        this.printedPages = 0;
    }

    public void fillToner(int newTonerPercent) {
        tonerPercentageLevel += newTonerPercent;

        if (tonerPercentageLevel > 100) {
            tonerPercentageLevel = 100;
            System.out.println("Toner filled to 100%");
        } else {
            System.out.println("Toner filled to " + tonerPercentageLevel + "%");
        }
    }

    public void printPage(int newPages) {

        if (duplexPrinter) {
            int newDoublePages = newPages % 2;
            printedPages += newDoublePages;
        } else {
            printedPages += newPages;
        }

        tonerPercentageLevel -= 2 * newPages;

        System.out.println("Total number of printed pages = " + printedPages);
        if (tonerPercentageLevel <= 0) {
            System.out.println("Toner empty, needs refilling");
        } else {
            System.out.println("Toner percentage level = " + tonerPercentageLevel + "%");
        }
    }

    public int getTonerPercentageLevel() {
        return tonerPercentageLevel;
    }

    public int getPrintedPages() {
        return printedPages;
    }

    public boolean isDuplexPrinter() {
        return duplexPrinter;
    }
}
