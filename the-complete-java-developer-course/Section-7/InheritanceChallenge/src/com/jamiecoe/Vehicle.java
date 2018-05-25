package com.jamiecoe;

public class Vehicle {

    private String name;
    private String size;
    private String colour;
    private int speed;
    private int direction;

    public Vehicle(String name, String size, String colour) {
        this.name = name;
        this.size = size;
        this.colour = colour;
        this.speed = 0;
        this.direction = 0;
    }

    public void steer(int direction) {
        this.direction += direction;
        System.out.println("Vehicle.steer(): steering at " + this.direction + " degrees.");
    }

    public void move(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
        System.out.println("Vehicle.move(): moving at " + this.speed + " mph and at " + this.direction + " degrees.");
    }

    public void stop() {
        this.speed = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
