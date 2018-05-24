package com.jamiecoe;

public class Wardrobe {
    private int width;
    private int height;
    private int depth;
    private String material;

    public Wardrobe(int width, int height, int depth, String material) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
    }

    public Wardrobe() {
        this.width = 50;
        this.height = 100;
        this.depth = 70;
        this.material = "wood";
    }
}
