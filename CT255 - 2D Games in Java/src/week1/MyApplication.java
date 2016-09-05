package week1;
import java.awt.*;

import javax.swing.*;

import java.util.Random;

public class MyApplication extends JFrame{
	
	private static final Dimension WindowSize = new Dimension(600,600);
	
	public MyApplication() {
		//Create and set up the window.
		this.setTitle("Pacman, or something..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Display the window, centred on the screen
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		setVisible(true);
		//Sets the background colour to yellow
		getContentPane().setBackground(Color.YELLOW);
	}
	
	public void paint ( Graphics g ) {
		int i;
		int j;
		//Make sure that the background is painted yellow, even if the window is enlarged
		super.paintComponents(g);
		Random random = new Random();
		
		for (i=50;i<WindowSize.height; i+=60){
			for(j=50; j<WindowSize.width; j+=60){
				//This method selects the colours randomly
				int red = random.nextInt(255);
				int blue = random.nextInt(255);
				int green = random.nextInt(255);
				Color randomcolour = new Color(red,blue,green);
				g.setColor(randomcolour);
				g.fillRect(i,j,50,50);
				
				}
		}
		
		
	}
	
	public static void main(String [ ] args) {
		MyApplication w = new MyApplication();
	}
}