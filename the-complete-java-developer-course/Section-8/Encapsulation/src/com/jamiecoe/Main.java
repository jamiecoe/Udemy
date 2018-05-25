package com.jamiecoe;

public class Main {

    // Encapsulation is the mechanism that allows you to restrict access to certain components in your objects

    public static void main(String[] args) {

    	// Here we are not using encapsultation
		// This is bad because:
		// 1. we have to do contructor stuff in main method (easy to forgot and annoying with lots of objects)
		// 2. Player class does not have complete control over state (eg: we can change the health from outside class)
		// 3. If we change a field name inside the class, we have to change it everywhere else

//	    Player player = new Player();
//
//	    player.name = "Jamie";
//	    player.health = 20;
//	    player.weapon = "stick";
//
//	    int damage = 10;
//
//	    player.loseHealth(damage);
//
//        System.out.println("remaining health = " + player.health);
//
//        damage = 11;
//
//		player.loseHealth(damage);
//
//		System.out.println("remaining health = " + player.health);


		// Here we are using encapsulation
		// Health can only be accessed and changed with Player methods
		// We have control over whats accessible in Main, and can easily change field names

		EnhancedPlayer player = new EnhancedPlayer("Jamie", 50, "stick");
		System.out.println("initial health is " + player.getHeath());

	}
}
