package week6;

public class Ostrich extends Bird {
	
	protected String name= "";
	protected boolean flies = false;
	protected boolean tall = true;
	protected double tall_legs = 0;
	protected boolean thin_long_legs = true;
	
	public Ostrich(String name, double tall_legs ){
		this.name = name;
		this.tall_legs = tall_legs;
	}
	
	@Override
	public boolean equals(Object obj){
		//checks if points at null
		if (obj==null){
			return false;
		}
		//check that object is object of Ostrich
		if (!(obj instanceof Ostrich)){
			return false;
		}
		//casting c as Ostrich object
		Ostrich c = (Ostrich)obj;
		//equality testing
		if (this.tall_legs==c.tall_legs){
			return true;
		}

		return false;
	}

	public void move(int length) {
		fly(length);
	}
	
	@Override
	public void fly(int length) {
		System.out.println("I can't fly " + length + " metres");
		
	}
	
	@Override
	public String toString(){
		String printOstrich = "I'm " + this.name +  " the ostrich; I am a Bird. I have thin legs " + this.tall_legs + " metres long;"; 
		return printOstrich;
	}	
}
