package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
	    Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
	    double price = hamburger.itemizeHamburger();

	    hamburger.addHamburgerAddition1("Tomato", 0.27);
	    hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);

        System.out.println(hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.itemizeHamburger();
        healthyBurger.addHealthAddition1("egg", 5.43);
        healthyBurger.addHealthAddition2("Lentils", 3.41);
        System.out.println(healthyBurger.itemizeHamburger());
    }
}
