package week4;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;



public class InvadersApplication extends JFrame implements KeyListener,Runnable {
	
	private static boolean isGraphicsInitialised = false;
	private static final Dimension WindowSize = new Dimension(800,600);
	private static final int NumAliens = 30;
	private Aliens[] AlienArray = new Aliens[NumAliens];
	private Image ShipImage, AlienImage;
	private Spaceship spaceship;
	private BufferStrategy strategy;
	protected boolean test = false;
	
	
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
		spaceship = new Spaceship(ShipImage,800);
		spaceship.setPosition(400, 520);
		
		
		
		int i;
		for(i=0;i<NumAliens;i++){//populates the array of Aliens with assigned random position and image
			AlienArray[i] = new Aliens(AlienImage,800);//populates the array of aliens with image and windowsize
			AlienArray[i].setPosition((i%6)*60 + 30, (i%5)*50 + 50);//puts positiion for i alien
			AlienArray[i].setXSpeed(2);//sets the speed at which it moves
			
		}
		
		//create a thread
		Thread t = new Thread(this);
		t.start();
		
		setVisible(true);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		isGraphicsInitialised = true;
		repaint();
	}
	
	public void paint(Graphics g){
		if(isGraphicsInitialised){
			g=strategy.getDrawGraphics();
			//create a black rectangle to cover the window
			super.paintComponents(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WindowSize.width, WindowSize.height);
			
			
			// paints each alien
			for(Aliens alien: AlienArray){
				alien.paint(g);
			}
			//paints spaceship
			spaceship.paint(g);
			
			g.dispose();
			strategy.show();
		}
	}
	//for the spaceship, the movement is taken from keyboard events, only left and right arrow (only cahnges the x-axis)
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			spaceship.setXSpeed(-8);//if left arrow is pressed spaceship moves -5 on the x axis
		}
		
		if(key == KeyEvent.VK_RIGHT){
			spaceship.setXSpeed(8);//if right arrow is pressed spaceship moves 5 on the x axis
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
		boolean test=true;
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Aliens alien: AlienArray){
				
				if(alien.move()){
					
					for(Aliens alien1 : AlienArray){
						
						alien1.reverseDirection();
						
						if(test){
							alien1.y+=60;
						}
					}
				}	
				else {
					
					alien.move();
				
				}
				
				//test=false;
				
				}
			

				spaceship.move();
				
			
				this.repaint();
			}
	}
	
	public static void main(String args[]){
		InvadersApplication w = new InvadersApplication();
	}
}
