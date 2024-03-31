/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombiansoccerleague;

import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class Round {

    public ArrayList<Team> alredyPlayed;
    public ArrayList<Team> toPlay;
    public ArrayList<Match> roundMatches;
    ArrayList<Match> matchToPlay;


    public Round() {
    }

    public Round(ArrayList<Team> toPlay) {
        this.toPlay = toPlay;
        this.alredyPlayed = new ArrayList<>();
        this.roundMatches = new ArrayList<>();
        this.matchToPlay=createRoundTeams();
    }

    public ArrayList<Match> getRoundMatches() {
        return roundMatches;
    }

    public void setRoundMatches(ArrayList<Match> roundMatches) {
        this.roundMatches = roundMatches;
    }

    //Get a Random index to pick a team in the Teams ArrayList.
    public int getRandomTeamIndex(ArrayList<Team> lstTeams) {
        int a = lstTeams.size();
        return (int) (Math.random() * a);
    }

    public int getTeamsLstSize() {
        var teamSize = this.toPlay.size();
        return teamSize;
    }

    public Team getRandomTeam(ArrayList<Team> toPlay) {
        int random1 = getRandomTeamIndex(toPlay);
        return toPlay.get(random1);
    }

    public ArrayList<Team> playRound() {
        for (int i = 0; i < matchToPlay.size(); i++) {
            Team team1= matchToPlay.get(i).getTeam1();
            Team team2= matchToPlay.get(i).getTeam2();
            Match match = playUniqueMatch(team1,team2);
            this.roundMatches.add(match);
        }
        return alredyPlayed;
    }

    public ArrayList<Match> createRoundTeams() {
        var teamSize = getTeamsLstSize();
        int i;
        boolean teamsAreCorrect = true;
        ArrayList<Team> tempToPlay = new ArrayList<>(this.toPlay);
        ArrayList<Team> tempAlredyPlayed = new ArrayList<>(this.alredyPlayed);
        matchToPlay = new ArrayList<>();
        for (i = 0; i < teamSize / 2; i++) {
            int z = 0;
            Team team1 = getRandomTeam(tempToPlay);
            tempToPlay.remove(team1);  
            Team team2 = getRandomTeam(tempToPlay);
            while (team1.getPlayedTeam().contains(team2)) {
                team2 = getRandomTeam(tempToPlay);
                if (z > 3) {
                    teamsAreCorrect = false;
                    break;
                }
                z++;
            }
            if (teamsAreCorrect) {
                tempToPlay.remove(team2);
                Match match = new Match(team1, team2);
                matchToPlay.add(match);
            } else {
               return createRoundTeams();
            }
        }
        return matchToPlay;
    }

    public Match playUniqueMatch(Team team1, Team team2) {
        Match match = new Match(team1, team2);
        match.playMatch();
        team1.setMatchesPlayed(1);
        team2.setMatchesPlayed(1);
        alredyPlayed.add(team1);
        alredyPlayed.add(team2);
        return match;
    }

}
