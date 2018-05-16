package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
	    boolean gameOver = true;
	    int score = 10000;
	    int levelComplete = 8;
	    int bonus = 200;

	    if (gameOver) {
            int finalScore = score + (levelComplete * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
