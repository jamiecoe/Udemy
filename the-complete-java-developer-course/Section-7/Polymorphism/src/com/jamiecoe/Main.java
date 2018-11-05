package com.jamiecoe;

// Polymorphism is the method / mechanism in OOP that allows actions to act differently based on...
// the actual object that the action is being performed on

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats people";
    }
}

class IndependanceDay extends Movie {
    public IndependanceDay() {
        super("Independance Day");
    }

    @Override
    public String plot() {
        return "Aliens invade earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze runner");
    }

    @Override
    public String plot() {
        return "Kids escape maze";
    }
}

class StarWars extends Movie {
    public StarWars() {
        super("Star wars");
    }

    @Override
    public String plot() {
        return "Space adventure";
    }
}

class ForgetableMovie extends Movie {
    public ForgetableMovie() {
        super("Forgetable");
    }

    // no plot method
}

public class Main {

    public static void main(String[] args) {
	    for (int i = 1; i < 11; i++) {
	        // We return a random child of the Movie class
	        Movie movie = randomMovie();
	        // We can use movie.plot() method and it will automatically look for a child override method
            // If no override method is present, it will use the plot() method from the original Movie class
            // This is very helpful, as we don't have to figure out which child class we want to call method with
            // This is power of Polymorphism
	        // Polymorphism allows for unique functionality for the class that's inherited from a base class
            System.out.println(
                    "Movie #" + i + " : " + movie.getName() + "\n" + "Plot: " + movie.plot() + "\n"
            );
        }
    }

    // we can use return type `Movie` to apply to all child classes
    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number = " + randomNumber);

        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependanceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new ForgetableMovie();
            default:
                return null;
        }
    }
}

