package lab2;

// This is a special method called a Constructor. 
//It is called when you create new Object - in this case, of type Day

public class Day {
	private int day;
	private int month;
	private String name; //e.g. Tuesday
	private int newday;
	
	public Day(int dy, int mth ){
		day = dy;
		month = mth;
		
		
		if (day>30)//if user inputs the date which is bigger than 30 the program ends
		{
			System.out.println("Invalid date");
			return;
		}
		else
		{
			newday = day;	
			switch (month)/* if the days of the month is restricted to 30, the 
			 first of January falls on Monday, the first of February falls on 
			 Wednesday, the first of March on Friday (+2 days each month)
			 the switch statement below is messy but the principal behind is give 
			 those two extra days every month in order move the days */
			{	
				case 1:newday = day+0;break;
				case 2:newday = (day+2)%7;break;
				case 3:newday = (day+4)%7;break;
				case 4:newday = (day+6)%7;break;
				case 5:newday = (day+1)%7;break;
				case 6:newday = (day+3)%7;break;
				case 7:newday = (day+5)%7;break;
				case 8:newday = (day+0)%7;break;
				case 9:newday = (day+2)%7;break;
				case 10:newday = (day+4)%7;break;
				case 11:newday = (day+6)%7;break;
				case 12:newday = (day+1)%7;break;
			}
				switch (newday)
				{
					case 1://1 of January is Monday, so the % 1 is allocated for Monday
					{
						name="Monday";
						break;
					}
					
					case 2://similar to above
					{
						name="Tuesday";
						break;
					}
					case 3:
					{
						name="Wednesday";
						break;
					}
					case 4:
					{
						name="Thursday";
						break;
					}
					case 5:
					{
						name="Friday";
						break;
					}
					case 6:
					{
						name="Saturday";
						break;
					}
					case 0:
					{
						name="Sunday";
						break;
					}
		}
			
				
			}
		
			}	
		public String getDaypublic()
		{
			String publicDay = name;
			return publicDay;
		}
		public int getDay2public()
		{
			int publicDay2 = day;
			return publicDay2;
		}
		//TODO
		//insert code to initialise the value of the name variable to a valid
		// day name (.e.g. Tuesday
		// you will need to use the the int value of day and month to calculate this 
	}


