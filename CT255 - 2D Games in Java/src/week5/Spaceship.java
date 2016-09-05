package week5;

import java.awt.Image;

public class Spaceship extends Sprite2D{
	
	public Spaceship(Image i1,int windowWidth, boolean isAlive){
		super(i1,i1,windowWidth,isAlive);//inherits Sprite 2D
	}
	//everything else is specific to spaceship is coded here
	public void move(){
		
		x+=d;//this value is taken from the keyboard input.
			
		if(x+d <= 20){//if the speed of the spaceship and the co-ordiates are approaching <= 20 or >= 715, spaceship stops
			x=20;
		}
		
		if(x+d >= 715){
			x=715;
		}
	}

}
