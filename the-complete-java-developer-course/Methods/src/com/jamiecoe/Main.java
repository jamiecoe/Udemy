package com.jamiecoe;

public class Main {
    // void means you don't want to return anything from the function
    // methods with return type void can also be known as a `procedure`
    public static void main(String[] args) {
        int finalScore = calculateScore(true, 800, 5, 100);

        int finalPosition = calculateHighScorePosition(finalScore);

        displayHighScorePosition("Jamie", finalPosition);
    }

    // you can't declare a method inside another method in Java

    public static int calculateScore(boolean gameOver, int score, int levelComplete, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelComplete * bonus);
            return finalScore;
        }
        // returning -1 is a convention to indicate an error (eg: invalid value or valueNotFound)
        return -1;
    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " managed to get into position " + position);
    }

    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) return 1;
        else if (score >= 500) return 2;
        else if (score >= 100) return 3;
        else return 4;
    }
}
