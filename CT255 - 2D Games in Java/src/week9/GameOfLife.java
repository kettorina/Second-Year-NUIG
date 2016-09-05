package week9;

import java.awt.Color;
import java.io.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class GameOfLife extends JFrame implements Runnable, MouseListener, MouseMotionListener{
	
	private static boolean isGraphicsInitialised = false;
	private static final Dimension WindowSize = new Dimension(800,800);
	private BufferStrategy strategy;
	private static boolean[][][] cells;//3D array
	private static int x,y,x2=0,y2=0;
	private static int count;//counts how many neighbors are alive 
	private static boolean isGameinProgress = false;
	boolean inDrag = false;
	
	public static void main(String args[]){
		GameOfLife w = new GameOfLife();
	}
	
	public GameOfLife(){
		this.setTitle("Conway's Way of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - 400;
		int y = screensize.height/2 - 400;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		//creating 40*40*2 cell matrices
		cells  = new boolean[40][40][2];
		int i,j,k;
		for(i=0;i<40;i++){
			for(j=0;j<40;j++){
				for(k=0;k<2;k++){
					cells[i][j][k]= false;
				}
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
					if(cells[i][j][0]){
						cells[i][j][1]=true;//if back cell is true set the front to be true
						g.setColor(Color.WHITE);
						g.fillRect(i*20,j*20, 20, 20);
					}
					else if(cells[i][j][0]==false){//else front cell is false
						cells[i][j][1]=false;
					}
				}
			}
			
			//drawing buttons
			g.setColor(Color.GREEN);
		    g.fillRect(27, 58, 53, 27);//x,y,width,height
		    g.fillRect(90, 58, 90, 27);
		    g.fillRect(190, 58, 60, 27);
		    g.fillRect(260, 58, 60, 27);
		    int fontSize = 22;
			g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		    g.setColor(Color.BLACK);
		    g.drawString("Start", 30, 78);
		    g.drawString("Random", 93 ,78);
		    g.drawString("Load", 193, 78);
		    g.drawString("Save", 263, 78);
			    
			g.dispose();
			strategy.show();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//toggles status of the cell
		 x=e.getX()/20;
		 y=e.getY()/20;
		 cells[x][y][0]=!cells[x][y][0];
		 
		 //positions of the start, random, load and save buttons
		 if((e.getX()>=27 & e.getX()<=80) && (e.getY()>=58 & e.getY()<=85)){
			 isGameinProgress = true;
		 }
		 
		 if((e.getX()>=90 & e.getX()<=180) && (e.getY()>=58 & e.getY()<=85)){
			 random();
		 }
		 
		 if((e.getX()>=190 & e.getX()<=250) && (e.getY()>=58 & e.getY()<=85)){
			 readfromFile();
		 }
		 
		 if((e.getX()>=260 & e.getX()<=320) && (e.getY()>=58 & e.getY()<=85)){
			 savetoFile();
		 }
		 inDrag = true;
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
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {//mouse dragging event
		 x=(e.getX()/20)%40;
		 y=(e.getY()/20)%40;
		 System.out.println("mouse Dragged to " + x + " " + y);
		
		    if(x2!=x || y2!=y){//only applicable if change in x or y values of the cells
		    	
		    	cells[x2][y2][0]=!cells[x2][y2][0];
		    	x2=x;
				y2=y;
		    }
		    
		      repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}		
	

	//random function intialise which back cells are true
	public static void random(){
		
		for(int i=0; i<40;i++){
			for(int j=0; j<40; j++){
				
				int rand = (Math.random() <= 0.5) ? 0 : 1; //generates either a 0 or 1
				
				if(rand==0){//if zero back cell is true
					cells[i][j][0] = true;
				}
				else{//if one
					cells[i][j][0] = false;
				}
			}
			
		}
		
		
	}
	//Loads previous states of the boolean
	public static void readfromFile(){
		String filename = "C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\lifegame.txt";
		String textinput = null;
		int mod = 0;
		char c = 0;
			try
				{
					BufferedReader reader = new BufferedReader(new FileReader(filename));
					do{
						try{
							textinput = reader.readLine();
							for(int k=0;k<40;k++){
								for(int l=0;l<40;l++){
									if(mod<1600)
									{
										c = textinput.charAt(mod);
									}
									if(c=='1'){
											cells[k][l][0]=true;
											System.out.println("found");
											mod++;
										}
										else if(c=='0'){
											cells[k][l][0]=false;
											mod++;
										}
									
								}
							}
						
					}catch(IOException e){
							
						}
					}
					while(textinput!= null);
					
					reader.close();
				} 
			catch(IOException e){
				 System.out.println (e.toString());
			     System.out.println("Could not find file " + filename);
			}
	}
	//saves states of booleans into a .txt file
	public static void savetoFile(){
		String filename = "C:\\Users\\kate\\Desktop\\Uni\\Second Year\\CT255 - Next Generation Technologies\\Digital Media\\Lab\\lifegame.txt";
			try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
					String outputtext="";
					for(int j=0;j<40;j++){
						for(int k=0;k<40;k++){
							if(cells[j][k][0]){
								outputtext = outputtext + "1";
							}
							else{
								outputtext = outputtext + "0";
							}
						}
					}
					writer.write(outputtext);
					writer.close();
				} 
				catch
				(IOException e) 
				{
					
				}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(isGameinProgress){
				//count how many neighbors are alive
				for(int x=0;x<40;x++){
					for(int y=0;y<40;y++){
						//count  the live neighbors of the cell [x][y][0]
						count=0;
						for(int xx=-1;xx<=1;xx++){
							for(int yy=-1;yy<=1;yy++){
								int xxx=xx+x;
								int yyy=yy+y;
								if(xx!=0||yy!=0){//doesn't count itself
									if((y+yy<0)){//edge cases
										yyy=39;
									}
									if(y+yy>39){
										yyy=0;
									}
									if(x+xx<0){
										xxx=39;
									}
									if(x+xx>39){
										xxx=0;
									}
									
									if(cells[x+xx][y+yy][1]==true){
										count++;
									}
								}
							
							}
						}
							//if underpopulation, cell which was alive dies
							if(count<2 && cells[x][y][1]==true){
								cells[x][y][0]=false;
							}
							
							//if overpopulation, cell which was alive dies
							else if(count>3 && cells[x][y][1]==true){
								cells[x][y][0]=false;
							}
							
							//if neighbor count is 2 or 3, cell stay alive
							else if((count==2 || count==3) && cells[x][y][1]==true){
								cells[x][y][0]=true;
							}
							
							//if neighbor count is exactly 3, cell which was dead is born
							else if(count==3 && cells[x][y][1]==false){
								cells[x][y][0]=true;
							}		
						}
					}
					
				}
				
			this.repaint();
		
		}	
	}
	
}
