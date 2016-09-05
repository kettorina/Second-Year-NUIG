package week2;

import java.awt.*;

import javax.swing.*;


public class MovingSquaresApplication extends JFrame implements Runnable{
	
	private static final Dimension WindowSize = new Dimension(600,600);
	private static final int NumGameObj = 25;
	private GameObject[] GameObjArray = new GameObject[NumGameObj];
	
	public MovingSquaresApplication(){
		
		this.setTitle("Moving Squares");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		
		
		int i;
		for (i=0; i<NumGameObj; i++){
			GameObjArray[i] = new GameObject();
		}
		
		Thread t = new Thread(this);
		t.start();
		
		setVisible(true);
	}
	public void paint(Graphics g){
		super.paintComponents(g);
		for(GameObject game: GameObjArray){
			game.paint(g);
		}
	}
	
	public void run(){
		while(true){
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			for(GameObject game: GameObjArray){
				game.move();
				
			}
			this.repaint();
		}
	}
	public static void main (String args[]){
		
		MovingSquaresApplication w = new MovingSquaresApplication();
	
	}

}
