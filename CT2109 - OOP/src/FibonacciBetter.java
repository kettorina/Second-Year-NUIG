/* Fibonacci sequences: demonstrates recursion */
/* M Madden, Feb 2014 */

public class FibonacciBetter
{
	static long count = 0;
	static int[] stored;
	
	public static void main(String[] args)
	{
		int answer;
		int num = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter n:"));

		javax.swing.JOptionPane.showMessageDialog(null, 
				"About to calculate fibonacci(" + num + "): ");

		// create array to store values
		stored = new int[num+1];
		// initialise values
		stored[0]=0; stored[1]=1;
		for (int i=2; i<=num; i++)
			stored[i] = -1; // indicates unknown value
		
		
		answer = fibonacci(num);

		javax.swing.JOptionPane.showMessageDialog(null, 
				"Fibonacci(" + num + ") is " + answer + " (took " + count + " calls)");
	}

	static int fibonacci(int n)
	{
		count++;

		/* Only defined for n >= 0 */
		if (n < 0) {
			System.out.println("ERROR: fibonacci sequence not defined for negative numbers.");
			System.exit(1);
		}

		/* Base cases: are pre-stored */
		/* Other cases: f(n) = f(n-1) + f(n-2) */
		if (stored[n] == -1)
			stored[n] = fibonacci(n-1) + fibonacci(n-2);
			
		return stored[n];
	}

}
