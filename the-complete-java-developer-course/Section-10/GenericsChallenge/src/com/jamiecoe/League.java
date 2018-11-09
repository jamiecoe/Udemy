package com.jamiecoe;

import java.util.ArrayList;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> leagueTeams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
