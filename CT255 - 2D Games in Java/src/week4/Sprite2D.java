package week4;

import java.awt.*;
import javax.swing.*;


public class Sprite2D extends JFrame{

	protected double x, y, dx;
	protected Image myImage;
	protected double xSpeed=0;
	int winWidth;
	
	public Sprite2D(Image i,int windowWidth ){//constructor that assigns image and position for each object
		this.x = windowWidth;
		//x = Math.random()*600;
		//y = Math.random()*600;
		this.myImage = i;
	}
	
	public void paint(Graphics g){//drawImage uses the assigned image, resizes it and positions it to the objects coordinates
		g.drawImage(myImage, (int)x, (int)y, 60, 60, null);
	}
	
	public void setPosition(double xx, double yy){
		x=xx;
		y=yy;
	}

	
	public void setXSpeed(double dx){//sets the speed from InvadersApplication 
		this.dx = dx;
	}
	
}


