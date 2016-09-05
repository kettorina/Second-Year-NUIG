import java.util.Date;


public class NaiveSort 
{

	
	private static int shuffles;
	
	public static void main(String[] args) 
	{
		int[] a = { 7, 3, 11, 2, 8, 1, 10, 5}; //, 12, 9} ;//, 6, 4};

		String startTime = (new Date()).toString();
		System.out.println("START time:" + startTime);
		
		shuffles = 0;
		
		while (! sorted(a))
			shuffle(a);
		
		System.out.println("SORTED! " + makeStr(a));
		System.out.println("Took " + shuffles + " calls to shuffle().");
		System.out.println("START time:" + startTime);
		System.out.println("END time:" + (new Date()).toString());

	}
	
	public static boolean sorted(int[] a)
	{
		for(int i=1; i<a.length; i++) {
			if (a[i-1] > a[i]) return false;
		}
		return true;
	}
	
	public static void shuffle(int[] a)
	{
		System.out.print("Shuffling: " + makeStr(a));
		shuffles++;
		for(int i=0; i<a.length; i++) {
			// pick a random index
			int j = (int)(Math.random() * a.length);
			// swap them
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		System.out.println("  Done: " + makeStr(a));		
	}
	
	public static String makeStr(int[] a)
	{
		String str = "[ ";
		for (int el : a) {
			str += el + " ";
		}
		str += "]";
		return str;
	}
}
