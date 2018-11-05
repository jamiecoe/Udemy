package com.jamiecoe;

import java.util.ArrayList;

// We want Team to accept a generic type for any kind of player
// Team<T> adds a Type paramter to Class declaration
// When we instantiate the class, 'T' will be replaced by Java with the actual class we're using
// Adding 'extends Player' limits what 'T' can be, it has to be a class that extends Player or is Player
// You can have multiple boundaries, T could extends a Class and multiple interfaces
// Eg: <T extends Class & Interface & Interface>

// We also implement Comparable interface, which we give Type param Team<T>
// That way, we can make sure the compareTo methods only compares Teams of the same type

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on the team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int getNumberOfPlayers() {
        return members.size();
    }

    public void calculateMatchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }

        played++;
        if (opponent != null) {
            opponent.calculateMatchResult(null, theirScore, ourScore);
        }

    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() == team.ranking()) {
            return 0;
        } else {
            return 1;
        }
    }
}
