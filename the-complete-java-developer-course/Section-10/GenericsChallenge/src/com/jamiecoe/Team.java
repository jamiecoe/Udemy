package com.jamiecoe;

public class Team<T extends Sport> implements Comparable<Team<T>>{
    private String name;
    private int points;
    private T sport;

    public Team(String name, T sport) {
        this.name = name;
        this.sport = sport;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public T getSport() {
        return sport;
    }

    public void calculateMatchResult(Team<T> otherTeam, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            points += sport.getWinPoints();
        } else if (ourScore == theirScore) {
            points += sport.getDrawPoints();
        } else {
            points += sport.getLosePoints();
        }

        if (otherTeam != null) {
            otherTeam.calculateMatchResult(null, theirScore, ourScore);
        }
     }

    @Override
    public int compareTo(Team<T> otherTeam) {
        return Integer.compare(otherTeam.getPoints(), points);
    }
}
