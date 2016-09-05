package football_league;

import java.util.ArrayList;

public class Division {

	Team team;
	private String name;
	private ArrayList<Team> teams = new ArrayList<Team>();//arraylist of team
	
	public Division(String string) {//constructor
		this.name=string;
	}

	public void add(Team team1){//method of adding team to a division
		this.teams.add(team1);
	}
	

	public int getnumTeams() {//this method return the size of team array (used for getNumTeams() in league and leaguestats
		return teams.size();
	}
	public String getDivName(){//getter method to get the name of the division
		return this.name;
	}

	public int getNumGoals() {//method to get the number of goals in a division
		int getGoals=0;
		for (Team team: teams){
			getGoals+=team.getGoals();
		}
		return getGoals;
	}

	public int getGoalsForTeam(String string) {//method to get the number of goals in a team
		int numGoalsForTeam=0;
		for (Team team:teams){
			if(team.getTeamName().equals(string)){
				numGoalsForTeam+=team.getGoals();
			}
		}
		return numGoalsForTeam;
	}

	public double getAveAgeofTeam(String string) {//method to get the average age per team
		int aveAgeForTeam=0;
		for (Team team:teams){
			if(team.getTeamName().equals(string)){
				aveAgeForTeam+=team.getAge();
			}
		}
		return aveAgeForTeam;
	}
}
