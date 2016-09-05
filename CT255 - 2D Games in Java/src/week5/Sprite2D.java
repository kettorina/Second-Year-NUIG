package week5;

import java.awt.*;
import javax.swing.*;


public class Sprite2D extends JFrame{

	protected double x, y, d;
	protected Image myImage1, myImage2;
	protected double xSpeed=0;
	int winWidth;
	int framesDrawn = 0;
	protected boolean isAlive;
	
	public Sprite2D(Image i1, Image i2, int windowWidth, boolean isAlive){//constructor that assigns image and position for each object
		this.x = windowWidth;
		this.myImage1 = i1;
		this.myImage2 = i2;
		this.isAlive=isAlive;//new boolean check for each object 
	}
	
	public void paint(Graphics g){//drawImage uses the assigned image, resizes it and positions it to the objects coordinates
		framesDrawn++;
		if(framesDrawn%100<50){
			g.drawImage(myImage1, (int)x, (int)y, null);
		}
		else{
			g.drawImage(myImage2, (int)x, (int)y, null);
		}
	}
	
	public void setPosition(double xx, double yy){
		x=xx;
		y=yy;
	}

	
	public void setXSpeed(double XSpeed){//sets the speed from InvadersApplication 
		this.d = XSpeed;
	}
	
}


