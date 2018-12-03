package com.jamiecoe;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        // Maps are bit like JS objects with key value pairs
        // You define type of key and value <String, String>
        Map<String, String> languages = new HashMap<>();

        languages.put("Java", "a compiled high level language");
        languages.put("Python", "an interpreted, object-oriented, language");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "it's basic");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));

        // You can't have duplicate keys in Map
        // If you try and add identical key, it will overwrite previous value
        languages.put("Java", "overwriting Java definition");
        System.out.println(languages.get("Java"));

        // languages.put() will return null if key is being created for first time
        System.out.println(languages.put("JavaScript", "the best language"));
        // languages.put() will return previous value if key is being overridden
        System.out.println(languages.put("Python", "overwriting python definition"));

        if (languages.containsKey("Lisp")) {
            System.out.println("Lisp is already in the map");
        }

        System.out.println("===============");

        // you can remove key/values from Map
        languages.remove("Lisp");

        // you can also remove based on if key has specific value
        if (languages.remove("BASIC", "it's basic")) {
            System.out.println("BASIC removed");
        } else {
            System.out.println("BASIC not removed");
        }

        // You can replace a value for a key, but only if that key exists in Map
        // language.replace() will return previous value if key exists
        System.out.println(languages.replace("Python", "a new python definition"));
        // language.replace() will return null if key doesn't exist
        System.out.println(languages.replace("Scala", "this won't work because Scala doesn't exist in Map"));

        // You can also replace based on the old value of the key
        // If the old value of the key were wrong here, the replace wouldn't work
        if (languages.replace("JavaScript", "the best language", "the worst language")) {
            System.out.println("JavaScript updated");
        }

        // Printing out all key/values from Map
        // languages.keySet() returns a Set
        for (String key: languages.keySet()) {
            // Remeber there's no guarenteed order with a HashMap
            // It won't necessarily print out key/values in the order you added them
            System.out.println(key + ": " + languages.get(key));
        }


        // Map key/values can be anything, you could have use Maps as keys or Values
        // eg: Map<Map<String, String>, String>
        // Keys can be mutable (eg: an ArrayList where values can be added/removed), but this is not advised!
        // Map can behave unpredictably if Keys objects change in such a way that 'equals' comparisons are affected

        // A Map cannot contain itself as a Key!

    }
}
