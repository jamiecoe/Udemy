package com.jamiecoe;

public class Table {
    private PC pc;
    private int width;
    private int height;
    private int depth;

    public Table(PC pc, int width, int height, int depth) {
        this.pc = pc;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Table(PC pc) {
        this.pc = pc;
        this.width = 50;
        this.height = 100;
        this.depth = 70;
    }

    public PC getPc() {
        return pc;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }
}
