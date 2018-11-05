package com.jamiecoe;

// Dog class inherits from Animal class
public class Dog extends Animal {

    // we can add extra fields that are only relevant to Dog class
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        // super() calls the parent class constructor
        super(name, 1, 1, size, weight);
        // we can still set Dog field variables
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    public void chew() {

    }

    // Child classes can override methods of the parent class
    @Override
    public void eat() {
        // so we can do specific method for Dog class
        chew();
        // and we can still call parent class method with `super`
        super.eat();
    }

    // we can use child methods to call parent method with different parameters
    public void walk() {
        move(1);
    }

    public void run() {
        move(5);
    }
}
