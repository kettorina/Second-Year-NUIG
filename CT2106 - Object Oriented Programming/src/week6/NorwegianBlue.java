package week6;

public final class NorwegianBlue extends Canary {

	/**
	 * constructor 1
	 */
	public NorwegianBlue(String name, int quality, int clr) {
		super(name, quality, clr);
		this.flies = false;
		this.moves = false;
		this.breathes = false;
		this.eats = false;
		this.sings = false;
	}
	
	public boolean equals (Object obj){
		//check that obj doesn't point to null
		if(obj==null){
			return false;
		}
		//check that obj is instance of NorwegianBlue
		if (!(obj instanceof NorwegianBlue)){
			return false;
		}
		//cast as NorwegianBlue object
		NorwegianBlue c = (NorwegianBlue) obj;
		//equality
		if (this.songQuality==c.songQuality && this.colour==c.colour){
			return true;
		}
		return false;
	}
	@Override
	public void move(int length){
		fly(length);
	}
	
	@Override
	public void fly(int length) {
		System.out.println("I can't fly " + length + " metres");
	}
	
	@Override
	public String toString(){
		String printNorwegianBlue = "I'm " + this.name +  " the norwegian blue; I am a Bird. I have blue colour " + this.colour + " and can't sing with quality " + this.songQuality + 
				". I'm pretty much dead, can't sing, can't fly, can't breathe and can't eat;"; 
		return printNorwegianBlue;
	}
}
