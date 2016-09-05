package week5;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;



public class InvadersApplication extends JFrame implements KeyListener,Runnable {
	
	private static boolean isGraphicsInitialised = false;
	private static final Dimension WindowSize = new Dimension(800,600);
	private static final int NumAliens = 30;
	private Aliens[] AlienArray = new Aliens[NumAliens];
	private Image ShipImage, AlienImage1, AlienImage2, BulletImage;
	private Spaceship spaceship;
	private BufferStrategy strategy;
	protected boolean test = false;
	protected ArrayList<PlayerBullet> bulletList = new ArrayList<PlayerBullet>();
	protected boolean isAlive = true;
	
	
	public InvadersApplication (){
		this.setTitle("Aliens & SpaceShip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		addKeyListener(this);
		
		//gets the image and it is assigned to a Image object for Aliens and spaceship
		ImageIcon icon = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\Space_Invaders_Alien.png");
		AlienImage1 = icon.getImage();
		ImageIcon icon3 = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\Small Invader.png");
		AlienImage2 = icon3.getImage();
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\ship.png");
		ShipImage = icon2.getImage();
		spaceship = new Spaceship(ShipImage,800,true);
		spaceship.setPosition(400, 530);
		
		ImageIcon icon4 = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\missile-alien.png");
		BulletImage = icon4.getImage();
		
		
		int i;
		for(i=0;i<NumAliens;i++){//populates the array of Aliens with assigned random position and image
			AlienArray[i] = new Aliens(AlienImage1,AlienImage2,800,true);//populates the array of aliens with image and windowsize
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
				if(alien.isAlive){
					alien.paint(g);
				}
			}
			//paints spaceship
			spaceship.paint(g);
			
			Iterator iterator = bulletList.iterator();//allows many bullets to be painted
			while(iterator.hasNext()){
				PlayerBullet bullet = (PlayerBullet) iterator.next();
				if(bullet.isAlive)//if the bullet is not alive don't paint it
				bullet.paint(g);
			}
			g.dispose();
			strategy.show();
		}
	}
	
	public void shootBullet(){
		PlayerBullet bullet = new PlayerBullet(BulletImage,WindowSize.width,true);
		bullet.setPosition(spaceship.x+spaceship.getWidth()/2, spaceship.y);
		bullet.setXSpeed(3);
		bulletList.add(bullet);
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
		
		if(key == KeyEvent.VK_SPACE){//if space is typed a new bullet is created
			shootBullet();
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
		boolean check=false;
		boolean test=true;
		int i =0;
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//check for collision
			for(PlayerBullet b: bulletList){//for every bullet
				if(b.isAlive){//if the bullet collided no collision test needed
					for(Aliens alien: AlienArray){//for every alien
						if(alien.isAlive){//checks collision if alien is alive
							if(((alien.x < b.x && alien.x+60>b.x)|| (b.x < alien.x && b.x+22>alien.x ))
							&&((alien.y<b.y && alien.y+60>b.y)|| (b.y<alien.y && b.y+22>alien.y))){
								alien.isAlive=false;//sets that alien is dead if collision took place
								b.isAlive=false;
							}
						}	
					}
				}
			}
			
			
			for(Aliens alien: AlienArray){
				
				check=alien.move()||check;
				
			}
			if(check){
				check=false;
				for(Aliens alien1 : AlienArray){
				
					alien1.reverseDirection();
						
						if(alien1.y<=450-(200-((i%5)*50))&&test){
							alien1.y+=20;
						}
						else {					
							test=false;				
						}	
						i++;
					}
				}	
							
						
			spaceship.move();
			
			for(PlayerBullet b : bulletList){//for every bullet 
				b.move();
			}
			
		
			this.repaint();
		}
	}
	
	public static void main(String args[]){
		InvadersApplication w = new InvadersApplication();
	}
}
