package football_league;

import java.util.ArrayList;

public class League {

	Division division; 
	private String name;
	private ArrayList<Division> divisions = new ArrayList<Division>();
	
	public League(String string) {//constructor
		this.name=string;
	}

	public void add(Division div1) {//method of adding divisions to league
		this.divisions.add(div1);
		
	}

	public int getNumDivisions() {//this method returns the size of directory
		return divisions.size();
	}
	
	public int getNumTeams(){//this method returns the number of teams in a directory
		int numTeams=0;
		for (Division div: divisions){//special method of going through each division to get the number of teams in a league
			numTeams+=div.getnumTeams();
		}
		return numTeams;
	}


	public int getGoalsForDivision(String name) {//similar to above but returns a value of goals per division
		int numGoalsForDivision=0;
		for (Division div: divisions){
			
			if(div.getDivName().equals(name)){
				numGoalsForDivision+=div.getNumGoals();
			}
		}
			return numGoalsForDivision;
			
	}

	public double getGoalsForTeam(String string) {//similar to above but returns a number of goals in a team
		int numGoalsForTeam=0;
		for (Division div:divisions){
			numGoalsForTeam+=div.getGoalsForTeam(string);
		}
		return numGoalsForTeam;
	}

	public double getAveAgeofTeam(String string) {//returns an average age in a team
		int aveAgeForTeam=0;
		for (Division div:divisions){
			aveAgeForTeam+=div.getAveAgeofTeam(string);
		}
		return aveAgeForTeam;
	}



}
