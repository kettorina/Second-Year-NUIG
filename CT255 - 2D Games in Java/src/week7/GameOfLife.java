package week7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GameOfLife extends JFrame implements Runnable, MouseListener{
	
	private static boolean isGraphicsInitialised = false;
	private static final Dimension WindowSize = new Dimension(800,800);
	private BufferStrategy strategy;
	private static boolean[][] cells;//2D array
	private static int x,y;
	
	public static void main(String args[]){
		GameOfLife w = new GameOfLife();
	}
	
	public GameOfLife(){
		this.setTitle("Conway's Way of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		addMouseListener(this);
		
		//creating 40*40 cell matrices
		cells  = new boolean[40][40];
		int i,j;
		for(i=0;i<40;i++){
			for(j=0;j<40;j++){
				cells[i][j]= false;
			}
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
			
			//when true paint white squares
			for(int i=0;i<40;i++){
				for(int j=0;j<40;j++){
					if(cells[i][j]){
						g.setColor(Color.WHITE);
						g.fillRect(i*20,j*20, 20, 20);
						break;
					}
				}
			}
			g.dispose();
			strategy.show();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//toggles status of the cell
		 x=e.getX()/20;
		 y=e.getY()/20;
		 cells[x][y]=!cells[x][y];
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}
		
	}
}
