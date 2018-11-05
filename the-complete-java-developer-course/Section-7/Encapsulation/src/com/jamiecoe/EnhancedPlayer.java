package com.jamiecoe;

public class EnhancedPlayer {
    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 && health <= 100) {
            this.hitPoints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitPoints -= damage;

        if (hitPoints <= 0) {
            System.out.println("player dead");
            // reduce number of lives for player
        }
    }

    public int getHeath() {
        return hitPoints;
    }
}
