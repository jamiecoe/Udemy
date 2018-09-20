package com.jamiecoe;

public class Main {

    // Abstract classes define methods, but do not provide an implementation for those methods (like Interfaces)
    // Implementation is done by classes that inherit from abstract class

    // When choosing between abstract classes or interfaces, think about whether your class 'is a' something OR...
    // ... your class 'can do' something
    // A dog IS A animal (so makes sense for animal to be abstract)
    // A bird CAN fly (but so can insects etc) so CanFly would be a good interface for both classes to implement

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");

        dog.eat();
        dog.breathe();

        Parrot parrot = new Parrot("Waldo");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Pingo");
        penguin.fly();
    }
}
