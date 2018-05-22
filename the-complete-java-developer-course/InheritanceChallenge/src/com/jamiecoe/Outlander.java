package com.jamiecoe;

public class Outlander extends Car {
    private int roadServiceMonths;

    public Outlander(String colour, int roadServiceMonths) {
        super("Outlander", "4 wheel drive", colour, 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }
}
