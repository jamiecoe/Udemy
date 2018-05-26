package com.jamiecoe;

public class Car {
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public void startEngine() {
        if (!engine) {
            engine = true;
        }
    }

    public void accelerate() {
        System.out.println("Accelerating car");
    }

    public void brake() {
        System.out.println("Braking car");
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public String getName() {
        return name;
    }
}
