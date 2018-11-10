package com.jamiecoe;

public abstract class Sport {
    private int winPoints;
    private int losePoints;
    private int drawPoints;

    public Sport(int winPoints, int losePoints, int drawPoints) {
        this.winPoints = winPoints;
        this.losePoints = losePoints;
        this.drawPoints = drawPoints;
    }

    public int getWinPoints() {
        return winPoints;
    }

    public int getLosePoints() {
        return losePoints;
    }

    public int getDrawPoints() {
        return drawPoints;
    }
}
