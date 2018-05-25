package com.jamiecoe;

public class Convertible extends Car {

    private boolean topDown;

    public Convertible(String colour, int gears, boolean isManual, boolean topDown) {
        super("Convertible", "4 wheel drive", colour, 5, 5, gears, isManual);
        this.topDown = topDown;
    }
}
