package com.jamiecoe;

public class Bed {
    private Frame frame;
    private int width;
    private int height;

    public Bed(Frame frame, int width, int height) {
        this.frame = frame;
        this.width = width;
        this.height = height;
    }

    public Bed() {
        this(new Frame("wood", 100, 50), 100, 50);
    }

    public String getBedFrameMaterial() {
        return frame.getMaterial();
    }
}
