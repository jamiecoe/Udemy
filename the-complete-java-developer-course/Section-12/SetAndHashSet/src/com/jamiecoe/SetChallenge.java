package com.jamiecoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {
    private static Map<HeavenlyBody, String> solarSystem = new HashMap<>();
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

        solarSystem.put(earth, earth.getName());
        solarSystem.put(mercury, mercury.getName());
        solarSystem.put(mars, mars.getName());
        solarSystem.put(moon, moon.getName());
        solarSystem.put(deimos, deimos.getName());
        solarSystem.put(sun, sun.getName());

        solarSystem.put(fakeSun, fakeSun.getName());
        solarSystem.put(fakeMars, "Mars");

        printPlanets(planets);
        printSolarSystem(solarSystem);
    }

    private static void printSolarSystem(Map<HeavenlyBody, String> solarSystem) {
        System.out.println("SOLAR SYSTEM");
        Set<HeavenlyBody> solarSystemBodies = solarSystem.keySet();

        for (HeavenlyBody heavenlyBody :
                solarSystemBodies) {
            System.out.println("\t" + heavenlyBody.getName() + " " + heavenlyBody.getOrbitalPeriod());
        }
    }

    private static void printPlanets(Set<HeavenlyBody> planets) {
        System.out.println("PLANETS");
        for (HeavenlyBody planet :
                planets) {
            System.out.println("\t" + planet.getName() + " " + planet.getOrbitalPeriod());
        }
    }
}
