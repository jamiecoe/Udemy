package com.jamiecoe;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyTypes().equals(BodyTypes.MOON)) {
            return super.addSatellite(satellite);
        } else {
            System.out.println(
                    "Can't add a " +
                    satellite.getKey().getBodyTypes() +
                    " as a satellite to a PLANET"
            );
            return false;
        }
    }
}
