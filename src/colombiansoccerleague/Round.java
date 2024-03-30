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
    private Team team1;
    private int goalsTeam1;
    private Team team2;
    private int goalsTeam2;
    public ArrayList<Team> alredyPlayed = new ArrayList<>();
    public ArrayList<Team> toPlay = new ArrayList<>();


    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public int getGoalsTeam1() {
        return goalsTeam1;
    }

    public void setGoalsTeam1(int goalsTeam1) {
        this.goalsTeam1 = goalsTeam1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getGoalsTeam2() {
        return goalsTeam2;
    }

    public void setGoalsTeam2(int goalsTeam2) {
        this.goalsTeam2 = goalsTeam2;
    }

    public Round() {
    }
    
      //Create multiple teams objects with the name attribute given by the String ArrayList with names.
    public void insertTeams(ArrayList<String> lstStringTeams, ArrayList<Team> lstTeams) {
        for (int i = 0; i < lstStringTeams.size(); i++) {
            Team team = new Team();
            team.setName(lstStringTeams.get(i));
            team.setIdTeam(i);
            lstTeams.add(team);
        }
    }
    
     //Get a Random index to pick a team in the Teams ArrayList.
    public int getRandomTeamIndex(ArrayList<Team> lstTeams) {
        int a = lstTeams.size();
        index = (int) (Math.random() * a);
        return index;
    }
    
    
    public Team getTeam1() {
        int random1 = getRandomTeamIndex(lstTeams);
        /*Team team = lstTeams.stream()
                .filter(x -> x.getName().equals(lstTeams.get(random1).getName()))
                .findFirst()
                .orElse(new Team());*/
        return lstTeams.get(random1);
    }

    public Team getTeam2() {
        int random2 = getRandomTeamIndex(lstTeams);
        /*Team team = lstTeams.stream()
                .filter(x -> x.getName().equals(lstTeams.get(random2).getName()))
                .findFirst()
                .orElse(new Team());*/
        return lstTeams.get(random2);
    }

    public void initTeamList() {
        if (lstTeams.isEmpty()) {
            insertNameTeams(lstStringTeams);
            insertTeams(lstStringTeams, lstTeams);
        }
    }
    public void playRound() {
        initTeamList();
        var teamSize = getTeamsLstSize();
        for (int i = 0; i < teamSize / 2; i++) {
            playMatch();
            if (i == teamSize / 2 - 1) {
                lstTeams.forEach(Team -> Team.setPlaying(false));
            }
        }
    }


    
}
