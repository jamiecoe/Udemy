package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
	    Animal animal = new Animal("Animal", 1, 1, 5, 5);

	    Dog dog = new Dog("Yorkie", 8, 20, 2, 2, 1, 20, "Furry");

	    // dog has access to all of parent class methods, like eat()
	    dog.eat();
    }
}
