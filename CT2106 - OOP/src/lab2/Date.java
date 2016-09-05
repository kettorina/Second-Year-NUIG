package lab2;

public class Date {
String todaydate;
	public Date(Day day, Month month, Year year) {//assigning values for the constructor
		 
		todaydate = "The date is " + day.getDay2public() +", "+ day.getDaypublic() + " of " + month.getMonthpublic() +", " + year.getYearpublic();
		
	}

	public void printName() {
		System.out.println(todaydate);//printing out the todaydate
		
	}

}
