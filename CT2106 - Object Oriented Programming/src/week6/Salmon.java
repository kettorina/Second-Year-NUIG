package week6;

public class Salmon extends Fish{
	protected String name = "";
	protected int colour = 0;
	protected int distance = 0;
	protected boolean edible = true;
	protected boolean lays_eggs_upriver = true;

	public Salmon(String name, int clr, int distance){
		this.name = name;
		this.colour = clr;
		this.distance = distance;
	}
	
	public boolean equals(Object obj){
		//check that obj doesn't point to null
		if(obj==null){
			return false;
		}
		//check that obj is Salmon object
		if (!(obj instanceof Salmon)){
			return false;
		}
		//cast obj as Salmon object
		Salmon c = (Salmon) obj;
		//equals
		if (this.colour==c.colour){
			return true;
		}
		return false;
	}
	@Override
	public void move(int length){
			swim(length);
		}
	
	@Override
	public void swim(int length) {
		System.out.println("I can swim " + length + " metres");
	}
	
	@Override
	public String toString(){
		String printSalmon = "I'm " + this.name +  " the salmon; I am a Fish. I have pink colour " + this.colour + " and can swim  " 
	+ this.distance + " km upriver to lay eggs. I'm edible :( ;"; 
		return printSalmon;
	}
}
