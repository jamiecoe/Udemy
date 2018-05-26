package com.jamiecoe;

public class HealthyBurger extends Burger {
    public HealthyBurger(String meat, String name) {
        super("Brown rye", meat, name);
        setAdditionsLimit(6);
    }
}
