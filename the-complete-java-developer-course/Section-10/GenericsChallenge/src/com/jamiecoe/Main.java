package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
	    League<Football> premiereLeague = new League<>("Premiere League");
        League<Basketball> nba = new League<>("NBA");

        Team<Football> arsenal = new Team<>("Arsenal", new Football());
        Team<Football> liverpool = new Team<>("Liverpool", new Football());
        Team<Football> chelsea = new Team<>("Chelsea", new Football());
        Team<Football> manCity = new Team<>("Man City", new Football());

        Team<Basketball> lakers = new Team<>("Lakers", new Basketball());
        Team<Basketball> mets = new Team<>("Mets", new Basketball());

        premiereLeague.addTeam(arsenal);
        premiereLeague.addTeam(liverpool);
        premiereLeague.addTeam(chelsea);
        premiereLeague.addTeam(manCity);

        nba.addTeam(lakers);
        nba.addTeam(mets);

        premiereLeague.printLeagueTable();
        nba.printLeagueTable();

        liverpool.calculateMatchResult(arsenal, 5, 1);
        manCity.calculateMatchResult(chelsea, 3, 2);

        lakers.calculateMatchResult(mets, 56, 64);

        premiereLeague.printLeagueTable();
        nba.printLeagueTable();
    }
}
