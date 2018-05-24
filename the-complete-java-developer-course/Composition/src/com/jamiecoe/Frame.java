package com.jamiecoe;

public class Frame {
    private String material;
    private int width;
    private int height;

    public Frame(String material, int width, int height) {
        this.material = material;
        this.width = width;
        this.height = height;
    }

    public Frame() {
        this.material = "wood";
        this.width = 50;
        this.height = 100;
    }

    public String getMaterial() {
        return material;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
