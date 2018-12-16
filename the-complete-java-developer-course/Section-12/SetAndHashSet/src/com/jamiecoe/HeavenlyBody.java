package com.jamiecoe;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    // Nested enum is automatially static
    public enum BodyTypes {
        STAR,
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    // Making the method final means it can be overridden by subclass
    // This way equals will be symmetric
    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody otherHeavenlyBody = (HeavenlyBody) obj;
            return this.key.equals(otherHeavenlyBody.getKey());
        }

        return false;
    }

    // hashCode() is used to decide which bucket a Set entry is added to
    @Override
    public final int hashCode() {
        // we add 57 to hashcode so that the hashcode of (String)"Pluto" doesn't equal (HeavenlyBody) `pluto`
//        return this.name.hashCode() + 57;

        return this.key.hashcode();
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyTypes;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyTypes.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return this.bodyTypes == key.getBodyTypes();
            }

            return false;
        }
    }
}
