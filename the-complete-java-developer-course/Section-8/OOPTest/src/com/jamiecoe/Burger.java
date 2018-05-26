package com.jamiecoe;

public class Burger {
    private String breadRoll;
    private String meat;
    private double basePrice;
    private String additions;
    private int numOfAdditions;
    private int additionsLimit;
    private double additionsPrice;
    private String name;

    public Burger(String breadRoll, String meat, String name) {
        this.breadRoll = breadRoll;
        this.meat = meat;
        this.basePrice = 2.5;
        this.additions = "";
        this.numOfAdditions = 0;
        this.additionsLimit = 4;
        this.additionsPrice = 1.0;
        this.name = name;
    }

    public void addNewAddition(String newAddition) {
        if (numOfAdditions < additionsLimit) {
            additions += newAddition + ", ";
            numOfAdditions++;
            System.out.println("New addition " + newAddition + " added");
            System.out.println("Total additions left = " + (additionsLimit - numOfAdditions));
        } else {
            System.out.println("No more additions allowed");
        }
    }

    public double calculateTotalPrice() {
        return basePrice + (numOfAdditions * additionsPrice);
    }

    public String getBreadRoll() {
        return breadRoll;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getAdditions() {
        return additions;
    }

    public int getNumOfAdditions() {
        return numOfAdditions;
    }

    public double getAdditionsPrice() {
        return additionsPrice;
    }

    public String getName() {
        return name;
    }

    public int getAdditionsLimit() {
        return additionsLimit;
    }

    public void setAdditionsLimit(int additionsLimit) {
        this.additionsLimit = additionsLimit;
    }
}
