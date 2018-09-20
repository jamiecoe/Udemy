package com.jamiecoe;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " can't fly because it's a penguin");
    }
}
