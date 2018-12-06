package com.jamiecoe;

import java.util.*;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "In front on computer", new HashMap<>()));

        Map<String, Integer> tempExit = new HashMap<>();

        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);

        locations.put(1, new Location(1, "End of road", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);

        locations.put(2, new Location(2, "Top of hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);

        locations.put(3, new Location(3, "Inside a building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);

        locations.put(4, new Location(4, "In a valley", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);

        locations.put(5, new Location(5, "In a forest", tempExit));

        int loc = 1;

        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String userInput = scanner.nextLine().toUpperCase();

            String direction = getDirection(userInput);

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }

    public static String getDirection(String userInput) {
        String[] splitWords = userInput.split(" ");

        ArrayList<String> acceptedDirections = new ArrayList<>();
        acceptedDirections.add("NORTH");
        acceptedDirections.add("EAST");
        acceptedDirections.add("SOUTH");
        acceptedDirections.add("WEST");

        for (String word : splitWords) {
            if (acceptedDirections.contains(word)) {
                return String.valueOf(word.charAt(0));
            }
        }

        return String.valueOf(splitWords[0].charAt(0));
    }
}
