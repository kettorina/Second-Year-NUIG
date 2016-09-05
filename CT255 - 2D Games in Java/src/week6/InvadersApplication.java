package week6;

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
	protected boolean safeToFire = true;
	protected int score = 0;
	protected int highscore = 0;
	protected boolean isGameinProgress = false;
	protected int count = 0; //checks how many aliens are dead
	protected int wave=0;
	protected boolean isReversalNeeded=false;
	
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
		
		
		ImageIcon icon4 = new ImageIcon("C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\missile-alien.png");
		BulletImage = icon4.getImage();
		
		
		//create a thread
		Thread t = new Thread(this);
		t.start();
		
		setVisible(true);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		isGraphicsInitialised = true;
		repaint();
	}
	
	public void startNewGame(){

		score=0;
		startNewWave();
	}
	
	public void startNewWave(){      
		int i;
		for(i=0;i<NumAliens;i++){//populates the array of Aliens with assigned random position and image
			AlienArray[i] = new Aliens(AlienImage1,AlienImage2,800,true);//populates the array of aliens with image and windowsize
			AlienArray[i].setPosition((i%6)*60 + 30, ((i%5)*50) + 67);//puts positiion for i alien
			AlienArray[i].setXSpeed(2+wave);//sets the speed at which it moves
		}
		spaceship.setPosition(400, 530);
	}
	
	public void paint(Graphics g){
		if(isGraphicsInitialised){
			if(isGameinProgress){
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
				
				int fontSize = 40;
				g.setFont(new Font("Cosmic Alien", Font.PLAIN, fontSize));
			    g.setColor(Color.white);
			    g.drawString("Score: " + score, 60, 78);
			    g.drawString("Highscore: " +highscore, 500 ,78);
				
				Iterator iterator = bulletList.iterator();//allows many bullets to be painted
				while(iterator.hasNext()){
					PlayerBullet bullet = (PlayerBullet) iterator.next();
					if(bullet.isAlive)//if the bullet is not alive don't paint it
					bullet.paint(g);
				}
				g.dispose();
				strategy.show();
			}
			else{//this is the black window that appears when the game is started and when user loses
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, WindowSize.width, WindowSize.height);
				g.setFont(new Font("Cosmic Alien", Font.PLAIN, 60));
			    g.setColor(Color.white);
			    g.drawString("Space Invaders", 190, 200);
			    g.setFont(new Font("Cosmic Alien", Font.PLAIN, 30));
			    g.drawString("Press any key to play", 250, 389);
			    g.setFont(new Font("Cosmic Alien", Font.PLAIN, 25));
			    g.drawString("[Arrow keys to move, space to shoot]", 190, 420);
			}
			
		}
	}
	
	public void shootBullet(){
		PlayerBullet bullet = new PlayerBullet(BulletImage,WindowSize.width,true);
		bullet.setPosition(spaceship.x + 22, spaceship.y);
		bullet.setXSpeed(5);
		bulletList.add(bullet);
	}
	//for the spaceship, the movement is taken from keyboard events, only left and right arrow (only cahnges the x-axis)
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(! isGameinProgress){
			startNewGame();
			isGameinProgress=true;
		}
		
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
		if(key == KeyEvent.VK_SPACE){//if space is typed a new bullet is created
			if(safeToFire)shootBullet();
		}
	}
	
	public void keyTyped(KeyEvent e){
	//not implemented	
	}
	
	public void run(){//makes the aliens to be moved via-thread
		while(true){
			safeToFire=true;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			safeToFire=false;
			if(isGameinProgress){
				Iterator iterator = bulletList.iterator();
				while(iterator.hasNext()){
					PlayerBullet bu =(PlayerBullet) iterator.next();
					if(bu.move()){
						iterator.remove();
						break;
					}
						for(Aliens alien: AlienArray){//for every alien
								if(alien.isAlive){//checks collision if alien is alive
									if(((alien.x < bu.x && alien.x+60>bu.x)|| (bu.x < alien.x && bu.x+22>alien.x ))
									&&((alien.y<bu.y && alien.y+60>bu.y)|| (bu.y<alien.y && bu.y+22>alien.y))){
										alien.isAlive=false;//sets that alien is dead if collision took place
										bu.isAlive=false;
										iterator.remove();
										score+=20;
										if(score>highscore){
											highscore=score;
										}
										count+=1;
										if(count==NumAliens){
											startNewWave();
											wave++;
											count=0;
											}
										break;
										
									}
								}	
							}
						}	
				
				for(Aliens alien: AlienArray){
					if(alien.isAlive){
						if(alien.move()){
							isReversalNeeded = true;
						}
						if(isReversalNeeded){
							for(Aliens alien1 : AlienArray){
								alien1.reverseDirection();
								alien1.y+=20;
								isReversalNeeded=false;
							}
					}	
					
					}
					else {
						
						alien.move();
						}
					}
				
				for(Aliens aliencollided: AlienArray){
					if(aliencollided.isAlive){//checks collision if alien is alive
						if(((aliencollided.x < spaceship.x && aliencollided.x+60>spaceship.x)|| (spaceship.x < aliencollided.x && spaceship.x+65>aliencollided.x ))
						&&((aliencollided.y<spaceship.y && aliencollided.y+60>spaceship.y)|| (spaceship.y<aliencollided.y && spaceship.y+40>aliencollided.y))){
							isGameinProgress=false;
							break;
							
						}
					}
				}
							
				spaceship.move();
				
			
				this.repaint();
			}
		}
	}
	
	public static void main(String args[]){
		InvadersApplication w = new InvadersApplication();
	}
}
