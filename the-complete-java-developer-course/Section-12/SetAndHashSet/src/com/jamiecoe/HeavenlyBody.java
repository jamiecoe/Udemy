package com.jamiecoe;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes {
        STAR,
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        BodyTypes objBodyType = ((HeavenlyBody) obj).getBodyType();

        if (this.bodyType.equals(objBodyType)) {
            String objName = ((HeavenlyBody) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }

    // hashCode() is used to decide which bucket a Set entry is added to
    @Override
    public int hashCode() {
//        System.out.println("hashcode called");
        // we add 57 to hashcode so that the hashcode of (String)"Pluto" doesn't equal (HeavenlyBody) `pluto`
        return this.name.hashCode() + 57;
    }
}
