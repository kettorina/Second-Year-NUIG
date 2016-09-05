package football_league;

public class Player {
	
	private int age;
	private int position;
	private int goals;
	
	public Player (int age, int position, int goals){//constructor
		this.age=age;
		this.position=position;
		this.goals=goals;
	}
	
	public double getAge(){//getter method to get age of a player
		return this.age;
	}

	public int getPosition(){
		return this.position;
	}
	
	public int getGoals(){//getter method to get goals of a player
		return this.goals;
	}
}
