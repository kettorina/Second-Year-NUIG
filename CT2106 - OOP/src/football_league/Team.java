package football_league;

import java.util.ArrayList;

public class Team {

	private Player player;
	private String teamName;
	private int throphies;
	private ArrayList<Player> players = new ArrayList<Player>();//arraylist of players
	
	public Team(String string) {//constructor
		this.teamName=string;
	}

	public String getTeamName(){//getter method to get the name of the team
		return this.teamName;
	}
	
	public int getThrophies(){
		return this.throphies;
	}
	
	public double getAge(){//method to get the age for each individual player that will be used by other methods in other classes
		int getAge=0;
		for(Player player:players){
			getAge+=player.getAge();
		}
		int aveAge=getAge/players.size();
		return aveAge;
	}
	
	public int getPosition(){
		return this.player.getPosition();
	}
	
	public int getGoals(){//method to get the number of goals per player that will be used later by other methods in other classes
		int getGoal=0;
		for(Player player:players){
			getGoal+=player.getGoals();
		}
		return getGoal;
	}

	public void add(Player player1) {//adding player to a team
		this.players.add(player1);
		
	}
}
