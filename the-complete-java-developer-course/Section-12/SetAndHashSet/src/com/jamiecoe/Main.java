package com.jamiecoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Sets are a collection of objects
// Unlike Lists, they have no defined ordering AND cannot contain duplicates
// There's no way to retrieve an item from a Set...
// You can check if Set contains item, or iterate over a Set
// But attempting for example to get 10th element isn't possible
// Sets are useful because Operations on Sets are very fast


public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
//        HeavenlyBody temp = new HeavenlyBody("Mercury", 88, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Venus", 225, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Earth", 365, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon);
//
//        temp = new HeavenlyBody("Mars", 687, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        tempMoon = new HeavenlyBody("Deimos", 1.3, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Mars
//
//        tempMoon = new HeavenlyBody("Phobos", 0.3, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Mars
//
//        temp = new HeavenlyBody("Jupiter", 4332, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        tempMoon = new HeavenlyBody("Io", 1.8, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        tempMoon = new HeavenlyBody("Europa", 3.5, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        tempMoon = new HeavenlyBody("Ganymede", 7.1, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        tempMoon = new HeavenlyBody("Callisto", 16.7, bodyType);
//        solarSystem.put(tempMoon.getName(), tempMoon);
//        temp.addSatellite(tempMoon); // temp is still Jupiter
//
//        temp = new HeavenlyBody("Saturn", 10759, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Uranus", 30660, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Neptune", 165, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        temp = new HeavenlyBody("Pluto", 248, bodyType);
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        System.out.println("Planets");
//        for(HeavenlyBody planet : planets) {
//            System.out.println("\t" + planet.getName());
//        }
//
//        HeavenlyBody body = solarSystem.get("Mars");
//        System.out.println("Moons of " + body.getName());
//        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
//            System.out.println("\t" + jupiterMoon.getName());
//        }
//
//        // Let's say we want to get all the moons in one Set
//        // You can create a union of two or more Sets. containing all the elements of the Sets
//        // Each element of a union will still only appear once, even if it was present in multiple Sets
//        // You can generate a union of Sets using the addAll() method
//        Set<HeavenlyBody> moons = new HashSet<>();
//        for(HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites());
//        }
//
//        System.out.println("All Moons");
//        for(HeavenlyBody moon : moons) {
//            System.out.println("\t" + moon.getName());
//        }
//
//        // Lets say we try to add a duplicate of Pluto with a different orbital period
//        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842, bodyType);
//        planets.add(pluto);
//
//        // When we print them out, we will see Pluto in the Set twice (which seems wrong!?)
//        // However, because the two objects do not compare equal, our Set is happy to accept both
//        // We'll need to override the equals() and hashCode() method in our HeavenlyBody class
//        System.out.println("Planets");
//        for(HeavenlyBody planet : planets) {
//            System.out.println("\t" + planet.getName());
//        }
    }
}
