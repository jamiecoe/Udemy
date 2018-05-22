package com.jamiecoe;

// 'public' is an access modifier
// it means unrestricted access, in this case to the Car class
// other access modifiers include:
// 'private' - no other class can access
// 'protected' - only allows classes in this package to access
// you can also just have no access modifier
public class Car {

    // encapsulation - keeping your class fields private, only accessible with getters and setters
    // fields need an access modifier

    // defining the `state` of the car with fields
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }
}
