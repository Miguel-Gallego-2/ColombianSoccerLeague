/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombiansoccerleague;

import java.util.ArrayList;

public class Match {
    public int counter = 0;
    public Team team1;
    public Team team2;
    private Integer index;
    public ArrayList<String> lstStringTeams = new ArrayList<>();
    public ArrayList<Team> lstTeams = new ArrayList<>();
    public ArrayList<Team> temptLstTeams = new ArrayList<>();
    
    public void showList() {
        System.out.print(lstTeams);
    }
    
    public Match() {
    }

    //Create a method to add the name of the Teams in an ArrayList.
    public void insertNameTeams(ArrayList<String> lstStringTeams) {
        lstStringTeams.add("Nacional");
        lstStringTeams.add("Patriotas");
        lstStringTeams.add("Santa Fe");
        lstStringTeams.add("Cali");
        lstStringTeams.add("Tolima");
        lstStringTeams.add("Medellín");
        /*lstStringTeams.add("Patriotas");
        lstStringTeams.add("Aguilas Doradas");
        lstStringTeams.add("Millonarios");
        lstStringTeams.add("Once Caldas");*/
    }
   
    public ArrayList<Team> getLstTeams() {
        return lstTeams;
    }
    
    public int getTeamsLstSize() {
        var teamSize = lstTeams.size();
        return teamSize;
    }

    //Create multiple teams objects with the name attribute given by the String ArrayList with names.
    public void insertTeams(ArrayList<String> lstStringTeams, ArrayList<Team> lstTeams) {
        for (int i = 0; i < lstStringTeams.size(); i++) {
            Team team = new Team();
            team.setName(lstStringTeams.get(i));
            lstTeams.add(team);
        }
    }
    
    public void initTeamList() {
        if (lstTeams.isEmpty()) {
            insertNameTeams(lstStringTeams);
            insertTeams(lstStringTeams, lstTeams);
        }
    }
    
    //Get a Random index to pick a team in the Teams ArrayList.
    public int getRandomTeamIndex(ArrayList<Team> lstTeams) {
        index = (int) (Math.random() * lstTeams.size());
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
    
    public void getTeam1(){
        int random1;
        do{
            random1 = getRandomTeamIndex(lstTeams);
            team1 = lstTeams.get(random1);
            System.out.println("Team 1 nombre "+team1.getName());
        }
        while(team1.isPlaying());
    }
    
    public void getTeam2(){
    int indTeam2;
        for(Team e: lstTeams){
            if(!team1.getPlayedTeam().contains(e)){
                indTeam2 = lstTeams.indexOf(e);
                team2 = lstTeams.get(indTeam2);
                System.out.println("Team 2 nombre "+team2.getName());
                if(!team2.isPlaying() && !team1.equals(team2) ){
                    break;
                }
            } 
        }
    } 
    
    public void playMatch() {
        getTeam1();
        getTeam2();
        faceOff(team1, team2);
        team1.setPlaying(true);
        team2.setPlaying(true);
        team1.updatePlayedTeamList(team2);
        team2.updatePlayedTeamList(team1);
        System.out.println(team1.toString(team1));
        System.out.println(team2.toString(team2));
        counter +=1;
        if (counter == getTeamsLstSize()/2){
            lstTeams.forEach(Team->Team.setPlaying(false));
            counter=0;
        }
    }
    
    public void playRound() {
        initTeamList();
        for (int i = 0; i < getTeamsLstSize() / 2; i++) {
            System.out.println("MATCH "+ (i+1));
            playMatch();
            /*if (i == (getTeamsLstSize()/2) - 1) {
                lstTeams.forEach(Team -> Team.setPlaying(false));
            }*/
        }
    }
    
    public void playTournament() {
        initTeamList();
        var NUMROUNDS = lstTeams.size() - 1;
        for (int i = 0; i < NUMROUNDS; i++) {
            System.out.println("ROUND "+ (i+1));
            playRound();
        }
        printList();
    }
    
    public void printList(){
        for (int i = 0; i < getTeamsLstSize(); i++) {
            System.out.println(lstTeams.get(i).getName());
            System.out.println(lstTeams.get(i).getWins());
            System.out.println(lstTeams.get(i).getLosses());
            System.out.println(lstTeams.get(i).getDraws());
            System.out.println(lstTeams.get(i).getGoalsScored());
            System.out.println(lstTeams.get(i).getGoalsConceded());
            System.out.println(lstTeams.get(i).getMatchesPlayed());
            System.out.println(lstTeams.get(i).getPoints());
        }

    }
}
