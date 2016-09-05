package week10;

public class Node {
	boolean open = false;
	boolean closed=false;
	int f=0,g=0,h=0;//values to calculate shortest route
	int x=0,y=0;
	
	public Node(int lx, int ly)
	{
		x=lx;
		y=ly;
	}
}
