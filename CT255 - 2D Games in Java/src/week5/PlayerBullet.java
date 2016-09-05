package week5;
 
import java.awt.Image;

public class PlayerBullet extends Sprite2D{

	public PlayerBullet(Image i1, int windowSize,boolean IsAlive){
		super(i1,i1,windowSize,IsAlive);
	}
	
	public boolean move(){
		
		y-=d;
		if(y<=50){
			return true;
		}
		return false;
	}

}
