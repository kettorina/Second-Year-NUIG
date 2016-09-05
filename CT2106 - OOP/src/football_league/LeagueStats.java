package football_league;

import java.util.ArrayList;

	public class LeagueStats {
	private League league;
	private ArrayList<League> leagues = new ArrayList<League>();//arraylist of League

	public int getNumDivisions(){//method to get the number of divisions
		return league.getNumDivisions();
	}
	
	public int getNumTeams(){//method to get the number of teams in a division
		return league.getNumTeams();
	}

	public void add(League league) {//method of adding league to leaguestats
		this.league=league;
		
	}

	public int getGoalsForDivision(String string) {//method to get the goals in a division which takes in a string as a parameter
		return league.getGoalsForDivision(string);
	}
	
	
	public double getGoalsForTeam(String string){//method to get goals in a team, similar to getGoalsForDivision
		return league.getGoalsForTeam(string);
	}
	
	public double getAveAgeofTeam(String string) {//method to get average age in a team
		return league.getAveAgeofTeam(string);
	}
 


}