package ariana;

public class INS{
	
	private double total = 0;//short was original value where the error occurred

	public static double reading_frequency = 5;// every 5 seconds
	
	public double calculateAltitude (double velocity){

		double reading = velocity;//this function adds velocity to and adds to altitude
		total =  (total + reading);
		double altitude = (total * reading_frequency/60);
		return altitude;//returns altitude
		
	}
}
/* the code changes are double to where short was found*/