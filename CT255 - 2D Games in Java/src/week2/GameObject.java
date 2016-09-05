package week2;

import java.awt.*;
import java.util.Random;

public class GameObject {

	private int x,y;
	private Color randomcolour;
	
	public GameObject(){
		Random randomcol = new Random();
		int red = randomcol.nextInt(255);
		int blue = randomcol.nextInt(255);
		int green = randomcol.nextInt(255);
		randomcolour = new Color(red,blue,green);
		
		Random randommove = new Random();
		x = randommove.nextInt(550);
		y = randommove.nextInt(550);//this initialises the position of a square
		
	}
	
	public void move(){//this changes the position of the square so it can "jiggle" 
		/*Random randommove = new Random();
		x+= randommove.nextInt(10) - randommove.nextInt(5);
		y+= randommove.nextInt(10) - randommove.nextInt(5);*/
		x+= (double)((Math.random()*20)-10);
		y+= (double)((Math.random()*20)-10);

		if (x < 60){
			x = 60;
		}
		if (x >560){
			x = 560;
		}
		if (y < 60){
			y = 60;
		}
		if (y > 560){
			y = 560; 
		}
		
	}
	
	public void paint(Graphics g){
		
		g.setColor(randomcolour);
		g.fillRect(x,y,50,50);
	}
}
