package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        FootballPlayer sophie = new FootballPlayer("Sophie");
        BaseballPlayer steve = new BaseballPlayer("Steve");
        RugbyPlayer fatimat = new RugbyPlayer("Fatimat");

        // Here we assign our generic Type parameter
        // So '<T>' inside Team will be FootballPlayer
        // An arguement passed as a type param can be a class or an interface
        // Interfaces can also specify type params
        // You can ensure Interface methods act on a specific type of object
        Team<FootballPlayer> arsenal = new Team<>("Arsenal");
        // Now you can only add FootballPlayer objects to arsenal
        arsenal.addPlayer(sophie);

        Team<BaseballPlayer> yankees = new Team<>("Yankees");
        yankees.addPlayer(steve);
        Team<RugbyPlayer> wolves = new Team<>("Wolves");
        wolves.addPlayer(fatimat);

        Team<FootballPlayer> liverpool = new Team<>("Liverpool");

        liverpool.calculateMatchResult(arsenal, 5, 1);

        System.out.println(liverpool.compareTo(arsenal));
    }
}
