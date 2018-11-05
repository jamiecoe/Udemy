package com.jamiecoe;

// One abstract class can extend another abstract class
public abstract class Bird extends Animal implements CanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println(this.getName() + " is breathing");
    }

    @Override
    public void fly() {
        System.out.println(this.getName() + " is flapping it's wings");
    }
}
