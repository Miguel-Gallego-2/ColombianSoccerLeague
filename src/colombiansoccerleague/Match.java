/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombiansoccerleague;

import java.util.ArrayList;

public class Match {

    private Integer index;
    public ArrayList<String> lstStringTeams = new ArrayList<>();
    public ArrayList<Team> lstTeams = new ArrayList<>();

    public void showList() {
        System.out.print(lstTeams);
    }

    public Match() {

    }

    //Create a method to add the name of the Teams in an ArrayList.
    public void insertNameTeams(ArrayList<String> lstStringTeams) {
        lstStringTeams.add("Atletico Nacional");
        lstStringTeams.add("América de Cali");
        lstStringTeams.add("Independiente Santa Fe");
        lstStringTeams.add("Deportivo Cali");
        lstStringTeams.add("Deportes Tolima");
        lstStringTeams.add("Independiente Medellín");

    }

    public ArrayList<Team> getLstTeams() {
        return lstTeams;
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

    public void winner(Team team, int goalsScored, int goalsConceded) {
        team.setGoalsScored(goalsScored);
        team.setGoalsConceded(goalsConceded);
        team.setWins(1);
        team.setPoints(3);
    }

    public void losser(Team team, int goalsScored, int goalsConceded) {
        team.setGoalsScored(goalsScored);
        team.setGoalsConceded(goalsConceded);
        team.setLosses(1);
        team.setPoints(0);
    }

    public void draw(Team team1, Team team2, int goals) {
        team1.setGoalsScored(goals);
        team1.setGoalsConceded(goals);
        team1.setPoints(1);
        team1.setDraws(1);
        team2.setGoalsScored(goals);
        team2.setGoalsConceded(goals);
        team2.setPoints(1);
        team2.setDraws(1);
    }

    //This method is used to updated the stats of both teams.
    public void faceOff(Team team1, Team team2) {
        int goals1 = (int) (Math.random() * 5);
        int goals2 = (int) (Math.random() * 5);
        if (goals1 == goals2) {
            draw(team1, team2, goals1);
        } else if (goals1 < goals2) {
            winner(team2, goals2, goals1);
            losser(team1, goals1, goals2);
        } else {
            winner(team1, goals1, goals2);
            losser(team2, goals2, goals1);
        }
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

    public int getTeamsLstSize() {
        var teamSize = lstTeams.size();
        return teamSize;
    }

    public void playMatch() {
        Team team1;
        Team team2;
        do {
            team1 = getTeam1();
            team2 = getTeam2();
            //if (!team1.isPlaying() && !team2.isPlaying() && !team1.equals(team2)) {
            //    break;
            // }
        } //   False || Flase || 
        while (team1.getPlayedTeam().contains(team2) || team1.equals(team2) ||
                team1.isPlaying() || team2.isPlaying());
        faceOff(team1, team2);
        team1.setPlaying(true);
        team2.setPlaying(true);
        team1.updatePlayedTeamList(team2);
        team2.updatePlayedTeamList(team1);
        System.out.println(team1.toString(team1));
        System.out.println(team2.toString(team2));
        System.out.println("other macht");
        int counter =0;
        for(int i = 0 ; i < getTeamsLstSize() ; i++){
            if(lstTeams.get(i).isPlaying()){counter += 1;}}
        if (counter == getTeamsLstSize()){
        lstTeams.forEach(Team->Team.setPlaying(false));}
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

    public void playTournament() {
        initTeamList();
        var NUMROUNDS = lstTeams.size() - 1;
        for (int i = 0; i < NUMROUNDS; i++) {
            playRound();
        }
    }
}
