package week3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class InvadersApplication extends JFrame implements KeyListener,Runnable {
	
	private static final Dimension WindowSize = new Dimension(600,600);
	private static final int NumAliens = 25;
	private Sprite2D[] AlienArray = new Sprite2D[NumAliens];
	private Image ShipImage, AlienImage;
	private Sprite2D spaceship; 
	
	
	public InvadersApplication (){
		this.setTitle("Aliens & SpaceShip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		addKeyListener(this);
		
		//gets the image and it is assigned to a Image object for Aliens and spaceship
		ImageIcon icon = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Techologies\\Digital Media\\Lab\\Space_Invaders_Alien.png");
		AlienImage = icon.getImage();
		ImageIcon icon2 = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Techologies\\Digital Media\\Lab\\ship.png");
		ShipImage = icon2.getImage();
		spaceship = new Sprite2D(270, 520, ShipImage);
		
		int i;
		for(i=0;i<NumAliens;i++){//populates the array of Aliens with assigned random position and image
			AlienArray[i] = new Sprite2D(Math.random()*600, Math.random()*500, AlienImage); 
		}
		
		//create a thread
		Thread t = new Thread(this);
		t.start();
		
		
		
		repaint();
		
		setVisible(true);
	}
	
	public void paint(Graphics g){
			//create a black rectangle to cover the window
			super.paintComponents(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WindowSize.width, WindowSize.height);

			// paints each alien
			for(Sprite2D alien: AlienArray){
				alien.paint(g);
		}
			//paints spaceship
			spaceship.paint(g);
	}
	//for the spaceship, the movement is taken from keyboard events, only left and right arrow (only cahnges the x-axis)
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			spaceship.setXSpeed(-5);//if left arrow is pressed spaceship moves -5 on the x axis
		}
		
		if(key == KeyEvent.VK_RIGHT){
			spaceship.setXSpeed(5);//if right arrow is pressed spaceship moves 5 on the x axis
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			spaceship.setXSpeed(0);//if left arrow is released spaceship moves 0 on the x axis
		}
		
		if(key == KeyEvent.VK_RIGHT){
			spaceship.setXSpeed(0);//if right arrow is released spaceship moves 0 on the x axis
		}
	}
	
	public void keyTyped(KeyEvent e){
	//not implemented	
	}
	
	public void run(){//makes the aliens to be moved via-thread
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				for(Sprite2D alien: AlienArray){
					alien.moveEnemy();
				}
				spaceship.movePlayer();
				this.repaint();
			}
	}
	
	public static void main(String args[]){
		InvadersApplication w = new InvadersApplication();
	}
}
