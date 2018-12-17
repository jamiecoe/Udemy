package com.jamiecoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 365);
        Planet mercury = new Planet("Mercury", 88);
        Planet mars = new Planet("Mars", 687);
        Planet fakeMars = new Planet("Mars", 0);
        Planet fakeSun = new Planet("Sun", 0);

        Moon moon = new Moon("Moon", 27);
        Moon deimos = new Moon("Deimos", 1.3);

        Star sun = new Star("Sun", 3456);

        earth.addSatellite(moon);
        mars.addSatellite(deimos);

        planets.add(earth);
        planets.add(mercury);
        planets.add(mars);

        planets.add(fakeSun);
        planets.add(fakeMars);

        solarSystem.put(earth.getKey(), earth);
        solarSystem.put(mercury.getKey(), mercury);
        solarSystem.put(mars.getKey(), mars);
        solarSystem.put(moon.getKey(), moon);
        solarSystem.put(deimos.getKey(), deimos);
        solarSystem.put(sun.getKey(), sun);

        solarSystem.put(fakeSun.getKey(), fakeSun);
        solarSystem.put(fakeMars.getKey(), fakeMars);

        printPlanets(planets);
        printSolarSystem(solarSystem);
    }

    private static void printSolarSystem(Map<HeavenlyBody.Key, HeavenlyBody> solarSystem) {
        System.out.println("SOLAR SYSTEM");
        Set<HeavenlyBody.Key> solarSystemBodies = solarSystem.keySet();

        for (HeavenlyBody.Key heavenlyBodyKey :
                solarSystemBodies) {
            HeavenlyBody heavenlyBody = solarSystem.get(heavenlyBodyKey);
            System.out.println("\t" + heavenlyBody.getKey().getName() + " " + heavenlyBody.getOrbitalPeriod() + " " + heavenlyBody.getKey().getBodyTypes());
        }
    }

    private static void printPlanets(Set<HeavenlyBody> planets) {
        System.out.println("PLANETS");
        for (HeavenlyBody planet :
                planets) {
            System.out.println("\t" + planet.getKey().getName() + " " + planet.getOrbitalPeriod());
        }
    }
}
