/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombiansoccerleague;

import java.util.ArrayList;

public class Match {
    private int goalsTeam1;
    private int goalsTeam2;
    

    public ArrayList<String> lstStringTeams = new ArrayList<>();
    public ArrayList<Team> lstTeams = new ArrayList<>();
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
       goalsTeam1 = (int) (Math.random() * 5);
       goalsTeam2 = (int) (Math.random() * 5);
        
    }
    public int getTeamsLstSize() {
        var teamSize = lstTeams.size();
        return teamSize;
    }
    public void playMatch(Team team1,Team team2) {
        faceOff(team1, team2);
        team1.updatePlayedTeamList(team2);
        team2.updatePlayedTeamList(team1);
        
        if (goalsTeam1 == goalsTeam2) {
            draw(team1, team2, goalsTeam1);
        } else if (goalsTeam1 < goalsTeam2) {
            winner(team2, goalsTeam2, goalsTeam1);
            losser(team1, goalsTeam1, goalsTeam2);
        } else {
            winner(team1, goalsTeam1, goalsTeam2);
            losser(team2, goalsTeam2, goalsTeam1);
        }
        
        /*System.out.println(team1.toString(team1));
        team1.setPlaying(true);
        team2.setPlaying(true);
        System.out.println(team2.toString(team2));
        System.out.println("other macht");
        int counter =0;
        for(int i = 0 ; i < getTeamsLstSize() ; i++){
            if(lstTeams.get(i).isPlaying()){counter += 1;}}
        if (counter == getTeamsLstSize()){
        lstTeams.forEach(Team->Team.setPlaying(false));}*/
    }
}
