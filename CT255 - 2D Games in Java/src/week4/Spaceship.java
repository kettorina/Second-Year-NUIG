package week4;

import java.awt.Image;

public class Spaceship extends Sprite2D{
	
	public Spaceship(Image i, int windowWidth){
		super(i,windowWidth);//inherits Sprite 2D 
	}
	//everything else is specific to spaceship is coded here
	public void move(){
		
		x+=dx;//this value is taken from the keyboard input.
			
		if(x+dx <= 20){//if the speed of the spaceship and the co-ordiates are approaching <= 20 or >= 715, spaceship stops
			x=20;
		}
		
		if(x+dx >= 715){
			x=715;
		}
	}

}
