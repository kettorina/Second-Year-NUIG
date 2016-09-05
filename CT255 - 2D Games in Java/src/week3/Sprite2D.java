package week3;

import java.awt.*;
import javax.swing.*;


public class Sprite2D extends JFrame{

	private double x, y, dx;
	private Image myImage;
	
	public Sprite2D(double x, double y, Image i){//constructor that assigns image and position for each object
		this.x = x;
		this.y = y;
		
		this.myImage = i;
	}
	
	public void paint(Graphics g){//drawImage uses the assigned image, resizes it and positions it to the objects coordinates
		g.drawImage(myImage, (int)x, (int)y, 60, 60, null);
	}

	public void moveEnemy() {
		x+= 10*(Math.random() - Math.random());//assign random movement to the enemy
		y+= 10*(Math.random() - Math.random());
		
		if (x < 60){//restricts the enemy to move in certain places
			x = 60;
		}
		if (x >560){
			x = 560;
		}
		if (y < 60){
			y = 60;
		}
		if (y > 460){
			y = 460; 
		}
		
	}
	public void setXSpeed(double dx){//sets the speed from InvadersApplication 
		this.dx = dx;
	}
	
	public void movePlayer(){//moves the spaceship by using setXSpeed
			
		x+=dx;
	}
}


