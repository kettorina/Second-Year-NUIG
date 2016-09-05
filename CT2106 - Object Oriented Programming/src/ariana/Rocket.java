package ariana;

public class Rocket {

	private double altitude = 0;// error arises when altitude and total are being parsed into short (which lowers the values) this gives an error and fails the program 
	public boolean malfunction = false;//when malfunction is set to untrue

	public static void main(String[] args) {//main


		Rocket ariana = new Rocket();//new object ariana
		VelocitySensor sensor = new VelocitySensor();//communicates with velocitySenor in VelocitySensor.java with sensor
		INS navigation = new INS();//communicates with INS in INS.java with navigation

		while (!ariana.malfunction ){//when ariana is working if statement is working
			double speed = sensor.getVelocity();//gets speed from VelocitySensor.java
			double distance = navigation.calculateAltitude(speed);//gets distance from INS.java
			ariana.setAltitude(distance);//goes to setAltitude
			ariana.output();//sends to print out the value
		
		if (ariana.getAltitude()>4000){//if altitude is over 4000 mission accomplished
			System.out.println("mission accomplished");
			break;
		}
			
		}
	}

	public void setAltitude(double alt) {
		if (alt< altitude){//if altitude is minus number
			
			malfunction = true;
			System.out.println("Houston, we have a problem. Major Telemetry Malfunction");
		}
		altitude = alt;
	}
	
	public double getAltitude() {
		return altitude;
	}

	public void output(){
		System.out.println("Ariana 5 altitude: " + altitude);
	}

}
/* the rocket malfunctioned because of the  short total variable this resulted to change every value (velocity, speed) to short (loss of value) and because short can only hold 16 bit memory it overflows (resulting in minus number in altitude) converting everything to double solves it */
