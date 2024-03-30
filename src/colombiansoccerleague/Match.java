/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colombiansoccerleague;

public class Match {
    private Team team1;
    private Team team2;
    private int goalsTeam1;
    private int goalsTeam2;

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getGoalsTeam1() {
        return goalsTeam1;
    }

    public void setGoalsTeam1(int goalsTeam1) {
        this.goalsTeam1 = goalsTeam1;
    }

    public int getGoalsTeam2() {
        return goalsTeam2;
    }

    public void setGoalsTeam2(int goalsTeam2) {
        this.goalsTeam2 = goalsTeam2;
    }

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

   
    public Match() {

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
  
    public void playMatch() {
        faceOff(this.team1, this.team2);
        this.team1.updatePlayedTeamList(this.team2);
        this.team2.updatePlayedTeamList(this.team1);
        
        if (goalsTeam1 == goalsTeam2) {
            draw(team1, team2, goalsTeam1);
        } else if (goalsTeam1 < goalsTeam2) {
            winner(team2, goalsTeam2, goalsTeam1);
            losser(team1, goalsTeam1, goalsTeam2);
        } else if (goalsTeam1 > goalsTeam2){
            winner(team1, goalsTeam1, goalsTeam2);
            losser(team2, goalsTeam2, goalsTeam1);
        }
        
    }
}
