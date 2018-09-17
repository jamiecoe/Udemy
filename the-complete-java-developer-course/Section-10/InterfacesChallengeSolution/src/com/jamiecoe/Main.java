package com.jamiecoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player jamie = new Player("Jamie", 10, 15);
        System.out.println(jamie.toString());
        saveObject(jamie);

        jamie.setHitpoints(8);
        // jamie.toString() will actually be assumed by sout 🎉
        System.out.println(jamie);
        jamie.setWeapon("Gun");
        saveObject(jamie);
//        loadObject(jamie);
        System.out.println(jamie);

        Saveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        saveObject(werewolf);

        // In order to use methods of the monster class, we need to cast it back to Monster datatype
        System.out.println(((Monster) werewolf).getStrength());
    }

    public static void saveObject(Saveable objectToSave) {
        List<String> valuesToSave = objectToSave.write();
        for (int i = 0; i < valuesToSave.size(); i++) {
            System.out.println("Saving " + valuesToSave.get(i) + " to storage device");
        }
    }

    public static void loadObject(Saveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;

        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }

        return values;
    }
}
