package lab2;

public class Calendar {

	//assume all months have 30 days and that 1 January is a Monday;
	
	public static void main(String[] args) { // e.g. input: 29 09 2015
		
		int in1 = Integer.parseInt(args[0]);//first string argument is passed to in1
		int in2 = Integer.parseInt(args[1]);//similar to above with two
		int in3 = Integer.parseInt(args[2]);
	
		Day day = new Day(in1, in2); //constructor
		Month month = new Month(in2); //constructor
		Year year = new Year(in3);//constructor
		
		Date date = new Date(day, month, year);//constructor
	
		date.printName(); // e.g. "The date is Tuesday, 29th of September, 2015

	}
}
/* Part B
   there are many ways to check the input
   for example only allow up to 30 for the day (if statement and a return if in1>30 is true),
   secondly repeat the same thing with months (if statement and return if in2>12),
   you can also set up the year between 1900 and 2100 for example and have if statement where
   1900>in3<2500*/
 