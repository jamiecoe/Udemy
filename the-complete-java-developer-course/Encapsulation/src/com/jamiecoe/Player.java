package com.jamiecoe;

public class Player {

    public String fullName;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;

        if (health <= 0) {
            System.out.println("player dead");
            // reduce number of lives for player
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}
