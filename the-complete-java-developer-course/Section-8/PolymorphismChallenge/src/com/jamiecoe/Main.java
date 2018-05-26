package com.jamiecoe;

class Convertible extends Car {
    public Convertible(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void accelerate() {
        System.out.println("Convertible accelerating");
    }
}

class Mini extends Car {
    public Mini(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void accelerate() {
        System.out.println("Mini accelerating");
    }
}

class DefaultCar extends Car {
    public DefaultCar(int cylinders, String name) {
        super(cylinders, name);
    }
}



public class Main {

    public static void main(String[] args) {
	    for (int i = 0; i < 5; i++) {
	        Car car = randomCar();
            car.accelerate();
        }
    }

    public static Car randomCar() {
        int randomNum = (int) (Math.random() * 3);

        System.out.println(randomNum);

        switch (randomNum) {
            case 0:
                return new Convertible(4, "Convertible");
            case 1:
                return new Mini(2, "Mini");
            case 2:
                return new DefaultCar(2, "default car");
            default:
                return null;
        }
    }
}
