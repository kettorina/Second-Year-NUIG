package week1;

public class Car {

		
		private int speed =0;
		private int gear=0;
		
		public void changeSpeed( int speednew) {
			
			speed = speednew; 
		}
		
		public void changeGear ( int gearnew){
			
			gear = gearnew;
		}
		
		public void printStates() {
	         System.out.println(" speed:" + 
	             speed + " gear:" + gear);
	    }
		
		
	
}
