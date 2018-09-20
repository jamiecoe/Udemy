package com.jamiecoe;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Any classes that inherit from Animal HAVE to have define implementation of these methods
    // (unlike regular inheritance)
    public abstract void eat();

    public abstract void breathe();

    public String getName() {
        return name;
    }
}
