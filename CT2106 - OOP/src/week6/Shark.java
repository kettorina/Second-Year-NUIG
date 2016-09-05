package week6;

public class Shark extends Fish{
	
	protected String name ="";
	protected boolean bites = true;
	protected boolean dangerous = true;
	protected int how_dangerous = 0;
	
	public Shark(String name, int how_dangerous){
		this.name = name;
		this.how_dangerous=how_dangerous;
	}
	
	@Override
	public boolean equals (Object obj){
		//check that object doesn't point to null
		if(obj==null){
			return false;
		}
		//check for object being a Shark object
		if(!(obj instanceof Shark)){
			return false;
		}
		//casting as a Shark object
		Shark c = (Shark) obj;
		//equality test
		if (this.how_dangerous==c.how_dangerous){
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
		String printShark = "I'm " + this.name +  " the shark; I am a Fish. I'm pretty dangerous " + this.how_dangerous + 
				"/10 dangerous scale and I can bite;"; 
		return printShark;
	}
}
