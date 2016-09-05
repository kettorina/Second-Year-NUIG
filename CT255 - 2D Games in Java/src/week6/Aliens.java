package week6;

import java.awt.Image;

public class Aliens extends Sprite2D{
	
	protected boolean check1=true;
	
	public Aliens(Image i1, Image i2, int windowWidth, boolean isAlive){//similar to spaceship, aliens inherit from sprite 2d
		super(i1, i2, windowWidth, isAlive);
	}
	//here all alien specific methods are written here
	public boolean move(){
		
		 	x+=d;
		 	if(!isAlive)
		 	{
		 		return false;
		 	}
		 	if(x<=20){//checks if it goes outside the boundary
		 		return true;
		 	}
		 	if(x>=720){
		 		return true;
		 	}

			return false;
		
	}
	
	public void reverseDirection(){//reverses the direction is move()=true
			this.setXSpeed(-d);
			
	}
}
