/** M Madden, M Schukat, 2005 - 2015: Abstract Stack interface */

package assignment3_arraylist;

import java.util.Scanner;


	public class QueueTest {
			public static void main (String args[]){
			
			
			
			//user input of the number of strings required an the initialisation of those strings
			System.out.print("Enter the number of strings: ");
			Scanner sc = new Scanner(System.in);
			int numStrings = sc.nextInt();
			String[] StringArray = new String[numStrings];
			ArrayQueue queue = new ArrayQueue(numStrings);
			//populating the array with different values 
			for(int i=0;i<StringArray.length;i++){
				
				String num = Integer.toString(i);
				StringArray[i] = num;
			}
			
			//enqueue method and records the time it took by taking the start and end time and finding the difference
			long enqueueStartTime = System.currentTimeMillis();
			for(int i=0;i<StringArray.length;i++){
				queue.enqueue(StringArray[i]);
			}
			long enqueueEndTime = System.currentTimeMillis();
			long enqueuedifference = enqueueEndTime - enqueueStartTime;

			System.out.println("Elapsed enqueue time in milliseconds: " + enqueuedifference);
			
			//similar to enqueue method, however records the time taken to dequeue
			long dequeueStartTime = System.currentTimeMillis();
			while(! queue.isEmpty()){
				queue.dequeue();
			}
			long dequeueEndTime = System.currentTimeMillis();
			long dequeuedifference = dequeueEndTime - dequeueStartTime;

			System.out.println("Elapsed dequeue time in milliseconds: " + dequeuedifference);
			
		}
	}
