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
    
    public ArrayList<Team> alredyPlayed ;
    public ArrayList<Team> toPlay ;
    public ArrayList<Match> roundMatches ;


    public Round() {
    }
    public Round(ArrayList<Team> toPlay) {
        this.toPlay=toPlay;
        this.alredyPlayed= new ArrayList<>();
        this.roundMatches=new ArrayList<>();
    }

    public ArrayList<Match> getRoundMatches() {
        return roundMatches;
    }

    public void setRoundMatches(ArrayList<Match> roundMatches) {
        this.roundMatches = roundMatches;
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
    
     //Get a Random index to pick a team in the Teams ArrayList.
    public int getRandomTeamIndex(ArrayList<Team> lstTeams) {
        int a = lstTeams.size();
        return (int) (Math.random() * a);
    }
    
      public int getTeamsLstSize( ) {
        var teamSize = this.toPlay.size();
        return teamSize;
    }
    
    
    public Team getRandomTeam() {
        int random1 = getRandomTeamIndex(toPlay);
        return toPlay.get(random1);
    }
/*
    public void initTeamList() {
        if (lstTeams.isEmpty()) {
            insertNameTeams(lstStringTeams);
            insertTeams(lstStringTeams, lstTeams);
        }
    }*/
    public ArrayList<Team>  playRound() {
        
        var teamSize = getTeamsLstSize();
        for (int i = 0; i < teamSize / 2; i++) {
            Match match=playUniqueMatch();
            this.roundMatches.add(match);
        }
        return alredyPlayed;
    }
    
    public Match playUniqueMatch(){
        Team team1=getRandomTeam();
        toPlay.remove(team1);
        //Team team2 =new Team();
        Team team2=getRandomTeam();
        if(team1.getPlayedTeam().contains(team2)){
            team2=getRandomTeam();
        }
        toPlay.remove(team2);
        Match match=new Match(team1,team2);
        match.playMatch();
        team1.setMatchesPlayed(1);
        team2.setMatchesPlayed(1);
        team1.updatePlayedTeamList(team2);
        team2.updatePlayedTeamList(team1);
        alredyPlayed.add(team1);
        alredyPlayed.add(team2);
        return match;
    }


    
}
