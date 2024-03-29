/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombiansoccerleague;

import java.util.ArrayList;
public class Team {
    private String name;
    private int wins;
    private int losses;
    private int draws;
    private int points;
    private int goalsScored;
    private int goalsConceded;
    private int matchesPlayed;
    private boolean playing;
    private ArrayList<Team> playedTeam =new ArrayList<>() ;
    
    public Team() {
    }

    public Team(String name, int wins, int losses, int draws, int points, int goalsScored, int goalsConceded, boolean playing, ArrayList<Team> playedTeam) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.points = points;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.playing = playing;
        this.playedTeam = playedTeam;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins += wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses += losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws += draws;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded += goalsConceded;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public ArrayList<Team> getPlayedTeam() {
        return playedTeam;
    }

    public void setPlayedTeam(ArrayList<Team> playedTeam) {
        this.playedTeam = playedTeam;
    }
    public int getMatchesPlayed() {
        return playedTeam.size();
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void updatePlayedTeamList (Team team){
        this.playedTeam.add(team);
    
    }
    public String toString(Team team) {
        return "Team{" + "name=" + team.getName() + ", wins=" + team.getWins() + 
                ", losses=" + team.getLosses() + ", draws=" + team.getDraws() + ", points=" + team.getPoints() + 
                ", goalsScored=" + team.getGoalsScored() + ", goalsConceded=" + team.getGoalsConceded() + 
                ", playing=" + team.isPlaying() + ", playedTeam=" + team.getPlayedTeam()+ '}';
    } 
}
