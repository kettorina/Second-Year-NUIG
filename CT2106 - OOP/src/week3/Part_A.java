package week3;

public class Part_A {
	
	public static void main(String[] args){ 
		
	int integer_to_double = 5;
	double integer_to_double1 = integer_to_double;// = 5.0 as implicit casting changes it into a double
	System.out.println(integer_to_double1);
	
	double  double_to_int = 5.00;
	int double_to_int1 = (int) double_to_int;
	System.out.println(double_to_int1);//shows 5 as it is an integer now 
	
	int integer3 = 78;
	float float3 = integer3;
	System.out.println(float3);//changes into float therefore 78.0 
	
	float float4 = 78f;
	int integer4 = (int) float4;
	System.out.println(integer4);// explicit casting and it equals to 78
	
	int y =65;
	float x = y; 
	System.out.println(x);// similar to one above with 78
	
	char character = 'a';
	int char1 = character;
	System.out.println(char1);//prints out 97 as character uses ASCII which stores a as 97
	
	int character2 = 89;// character ASCII value 89 is Y
	char char2 = (char) character2;
	System.out.println(char2);
	
	short short_to_int = 2;
	int inttoshort = short_to_int;
	System.out.println(inttoshort);//same result
	
	int by = 7;
	short bx = (short) by;
	System.out.println(bx);//same result
	
	byte byte_to_short = 1;
	short short_to_byte = byte_to_short;
	System.out.println(short_to_byte);//same result
	
	double double_to_byte = 20.00;
	byte byte_to_double = (byte) double_to_byte;
	System.out.println(byte_to_double);//20 as it is cuts off .00 to be an int
	
	int int_to_long = 54;
	long int_to_long1 = int_to_long;
	System.out.println(int_to_long1);// same
	
	float float_to_int = 3.0f;
	int float_to_int1 = (int) float_to_int;
	System.out.println(float_to_int1);// same
	
	float float_to_short = 7.0f;
	short float_to_short1= (short) float_to_short;
	System.out.println(float_to_short1);//same
	
	float float_to_byte = 8.0f;
	byte float_to_byte1 = (byte) float_to_byte;
	System.out.println(float_to_byte1);//same
	
	char char_to_double = 'd';
	double char_to_double1 = char_to_double;
	System.out.println(char_to_double1);// char 'd' is stored as 100.0 in double 
			
	}
}
