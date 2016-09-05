package lab2;

public class Month {
	
		private int number;
		private String nameofmonth;
	
	public Month(int in2) {
		// TODO Auto-generated constructor stub
		number= in2;//number takes in the value of in2 
		
		switch (number)//switch statement
		{
			case 1://allocates January for number 1
			{
				nameofmonth="January";
				break;
			}
			
			case 2://similar to above with Tuesday
			{
				nameofmonth="February";
				break;
			}
			case 3:
			{
				nameofmonth="March";
				break;
			}
			case 4:
			{
				nameofmonth="April";
				break;
			}	
			case 5:
			{
				nameofmonth="May";
				break;
			}
			case 6:
			{
				nameofmonth="June";
				break;
			}
			case 7:
			{
				nameofmonth="July";
				break;
			}
			case 8:
			{
				nameofmonth="August";
				break;
			}
			case 9:
			{
				nameofmonth="September";
				break;
			}
			case 10:
			{
				nameofmonth="October";
				break;
			}
			case 11:
			{
				nameofmonth="November";
				break;
			}
			case 12:
			{
				nameofmonth="December";
				break;
			}
			default:
			{
				System.out.println("Invalid month");
				break;
			}
		}
		
		
	}
		public String getMonthpublic()
		{
			final String publicMonth = nameofmonth;
			return publicMonth;
		}


}
