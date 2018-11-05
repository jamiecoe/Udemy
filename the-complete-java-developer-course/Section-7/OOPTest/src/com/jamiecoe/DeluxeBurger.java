package com.jamiecoe;

public class DeluxeBurger extends Burger {
    public DeluxeBurger(String breadRoll, String meat, String name) {
        super(breadRoll, meat, name);
        setAdditionsLimit(2);
        addNewAddition("Chips");
        addNewAddition("Drink");
    }
}
