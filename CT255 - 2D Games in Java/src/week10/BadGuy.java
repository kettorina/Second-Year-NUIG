package week10;

import java.awt.Graphics;
import java.awt.Image;

public class BadGuy {
	
	Image myImage;
	int x=0,y=0;
	boolean hasPath=false;
	boolean walkable_1=false;
	boolean walkable_2=false;
	Node node[][] = new Node[40][40];
	int parx, pary;
	
	public BadGuy( Image i ) {
		myImage=i;
		x = 30;
		y = 10;
		
		for(int j=0;j<40;j++)//populating the bad guy with nodes (rather than with the map)
		{
			for(int l=0;l<40;l++)
			{
				node[j][l]= new Node(0,0);
			}
		}
	}
	
	public void reCalcPath(boolean map[][],int targx, int targy) {
		// TO DO: calculate A* path to targx,targy, taking account of walls defined in map[][]
		parx=x;
		pary=y;

	while(walkable_1)
	{
		node[parx][pary].open=true;//adding the starting position into the open list
		
		
		for(int xx=-1;xx<=1;xx++)//loop throught
		{						
			for(int yy=-1;yy<=1;yy++)
			{
					if(x+xx<0)//edge cases 
					{
						continue;
					}
					if(y+yy<0)
					{
						continue;
					}
					if(x+xx>39)
					{
						continue;
					}
					if(y+yy>39)
					{
						continue;
					}
					if(node[x+xx][y+yy].closed)//if nodes are already in the closed list
					{
						continue;
					}
					if(!map[x+xx][y+yy])//if walkable
					{
						node[x+xx][y+yy].open=true;//add to open list
						System.out.println("Count");//to debug easier
						if(xx==-1&&yy==-1||xx==-1&&yy==1||xx==1&&yy==1||xx==1&&yy==-1)
						{
							//diagonal cases
							node[x+xx][y+yy].g=14;
						}
						else if(xx==0&&yy==0)
						{
							//current position
							node[x+xx][y+yy].g=0;
						}
						else
						{
							//all other cases
							node[x+xx][y+yy].g=10;
						}
						while(!walkable_2)
						{
							int org_x=x;
							int org_y=y;
							move(map,targx,targy);//record the path
							node[x+xx][y+yy].h+=10;//heuristic cost
						}
						node[x+xx][y+yy].f=node[x+xx][y+yy].g+node[x+xx][y+yy].h;// finding the overall sum
					}
				
			}
		}
		
		node[parx][pary].open=false;//put into closed list
		node[parx][pary].closed=true;
	}
		hasPath=true;
	}
	
	public void move(boolean map[][],int targx, int targy) {
		if (hasPath) {
			// Didn't understand what to do
			
		}
		else {
			// no path known, so just do a dumb 'run towards' behaviour
			int newx=x, newy=y;
			if (targx<x)
				newx--;
			else if (targx>x)
				newx++;
			if (targy<y)
				newy--;
			else if (targy>y)
				newy++;
			if (!map[newx][newy]) {
				x=newx;
				y=newy;
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, x*20, y*20, null);
	}
	
}
