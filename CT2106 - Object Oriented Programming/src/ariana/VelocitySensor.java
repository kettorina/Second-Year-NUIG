package ariana;

public class VelocitySensor {
	
	double velocity = 0.0;
	
	public double getVelocity(){//this function gets random speed
		
		double speed  = 1000* Math.random();
		return speed;
	}
}
