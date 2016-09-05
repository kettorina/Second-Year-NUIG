/* Fibonacci sequences: demonstrates recursion */
/* M Madden, Oct 2000 */

public class Fibonacci
{
	static long count = 0;

	public static void main(String[] args)
	{
		
		int answer;
		int num = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter n:"));

		javax.swing.JOptionPane.showMessageDialog(null, 
				"About to calculate fibonacci(" + num + "): ");

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

		/* Base cases: f(0) is 0, f(1) is 1 */
		/* Other cases: f(n) = f(n-1) + f(n-2) */
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		else {
			int answer = fibonacci(n-1) + fibonacci(n-2);
			return answer;
		}
	}

}
