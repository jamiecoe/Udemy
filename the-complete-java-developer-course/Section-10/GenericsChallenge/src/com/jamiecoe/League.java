package com.jamiecoe;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Sport> {
    private String name;
    private ArrayList<Team<T>> leagueMembers = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTeam(Team<T> newTeam) {
        leagueMembers.add(newTeam);
    }

    public void printLeagueTable() {
        Collections.sort(leagueMembers);

        System.out.println(name + " table:");

        for (int i = 0; i < leagueMembers.size(); i++) {
            System.out.println((i + 1) + ". " + leagueMembers.get(i).getName());
        }

        System.out.println("===========");
    }
}
