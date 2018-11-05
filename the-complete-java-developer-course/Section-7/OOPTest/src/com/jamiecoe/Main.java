package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        Burger cheeseBurger = new Burger("white", "beef", "bacon cheese burger");

        cheeseBurger.addNewAddition("Cheese");
        cheeseBurger.addNewAddition("Bacon");
        cheeseBurger.addNewAddition("Onions");
        cheeseBurger.addNewAddition("Chip");

        String additions = cheeseBurger.getAdditions();
        System.out.println("Additions = " + additions);
        double totalPrice = cheeseBurger.calculateTotalPrice();
        System.out.println("Total price of Burger = £" + String.format( "%.2f", totalPrice));

        HealthyBurger healthyBurger = new HealthyBurger("turkey", "turkeyBurger");

        healthyBurger.addNewAddition("Cheese");
        healthyBurger.addNewAddition("Bacon");
        healthyBurger.addNewAddition("Onions");
        healthyBurger.addNewAddition("Chip");

        additions = healthyBurger.getAdditions();
        System.out.println("Additions = " + additions);
        totalPrice = healthyBurger.calculateTotalPrice();
        System.out.println("Total price of Healthy Burger = £" + String.format( "%.2f", totalPrice));

        DeluxeBurger deluxeBurger = new DeluxeBurger("white", "chicken", "Chicken burger");

        deluxeBurger.addNewAddition("Cheese");
        deluxeBurger.addNewAddition("Bacon");

        additions = deluxeBurger.getAdditions();
        System.out.println("Additions = " + additions);
        totalPrice = deluxeBurger.calculateTotalPrice();
        System.out.println("Total price of Deluxe Burger = £" + String.format( "%.2f", totalPrice));
    }
}
