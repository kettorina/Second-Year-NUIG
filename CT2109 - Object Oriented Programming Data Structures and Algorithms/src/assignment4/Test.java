package assignment4;

//import StringComparator;

import java.util.Comparator;

import javax.swing.JOptionPane;

public class Test {
	protected static int insertionMove = 0;
	protected static int insertionComp = 0;
	protected static int shellMove = 0;
	protected static int shellComp = 0;
	protected static int quickMove = 0;
	protected static int quickComp = 0;
	/** Shellort.java: 
	 *  
	 *  Based on code from Carrano & Savitch, “Data Structures and Abstractions with Java”
	 *  With some simplifications for clarity, an extra insertionSort method, 
	 *  and test code at the end.
	 */



		/** Task: Sorts equally spaced elements of an array into ascending order.
		 *  The paramater arr is an array of Comparable objects.
		 */
		
		public static void shellSort (Comparable[] arr)   
		{
			int last = arr.length-1; 

			// Begin with gap = half length of array; reduce by half each time.
			for (int gap = arr.length/2; gap > 0; gap = gap/2)
			{
				if (gap % 2 == 0) gap++; // if gap is even, move to next largest odd number
				
				// Apply Insertion Sort to the subarrays defined by the gap distance
				for (int first = 0; first < gap; first++) {
					insertionSort (arr, first, last, gap);
				}
			} // end for
		} // end shellSort
		

		/** Helper function for shellSort method, that sorts a subarray
		 * that goes from the first to last index, in steps specified by gap.
		 */	
		private static void insertionSort(Comparable[] a, int first, int last, int gap)                                             
		{
			int index;     // general index for keeping track of a position in array
			int toSort;  // stores the index of an out-of-place element when sorting.

			// NOTE: Instead of considering a full array of adjacent elements, we are considering 
			// a sub-list of elements from 'first' to 'last, separated by 'gap'. All others are ignored.
			//
			// Work forward through the list, starting at 2nd element, 
			// and sort each element relative to the ones before it.
			
			for (toSort = first+gap; toSort <= last; toSort += gap)
			{
				Comparable toSortElement = a[toSort];

				// Go back through the list to see how far back (if at all)
				// this element should be moved.
				// Note: we assume all elements before this are sorted relative to each other.
				boolean moveMade = false;
				index = toSort - gap;
				while ((index >= first) && (toSortElement.compareTo(a[index]) < 0))
				{
					if(gap == 1) insertionComp++;
					else shellComp++;
					// Shuffle elements over to the right, put firstUnsorted before them 
					a[index+gap] = a[index];
					index = index - gap;
					moveMade = true;
					
				} 
				if (moveMade) {
					if(gap ==1) insertionMove++;
					else shellMove++;
					//System.out.println("Inserting " + toSortElement + " at pos " + (index+1));
					a[index+gap] = toSortElement;
					
				}
			} 
		} 

		
		/** Version of insertionSort method that uses the correct settings to sort an entire array
		 *  from start to end in steps of 1.
		 *  
		 *  This version uses the 'helper function' version, but is a direct substitute for the 
		 *  quickSort() method call.
		 */
		public static void insertionSort(Comparable arr[])
		{
			insertionSort(arr, 0, arr.length-1, 1);
		}

		
		 /** QuickSort method:
		  * Sorts the elements of array arr in nondecreasing order according
		  * to comparator c, using the quick-sort algorithm. Most of the work
		  * is done by the auxiliary recursive method quickSortStep.
		  **/
		public static void quickSort (Object[] arr, Comparator c) {
		    if (arr.length < 2) return; // the array is already sorted in this case
		    quickSortStep(arr, c, 0, arr.length-1); // call the recursive sort method
		}
		  
		/** QuickSortStep method: 
		  * Method called by QuickSort(), which sorts the elements of array s between
		  * indices leftBound and rightBound, using a recursive, in-place,
		  * implementation of the quick-sort algorithm.
		 **/
	private static void quickSortStep (Object[] s, Comparator c,
		                              int leftBound, int rightBound ) 
		{
		   if (leftBound >= rightBound) return; // the indices have crossed
		   Object temp;  // temp object used for swapping
		    
		   // Set the pivot to be the last element
		   Object pivotValue = s[rightBound];
		    
		   // Now partition the array 
		   int upIndex = leftBound;     // will scan rightward, 'up' the array
		   int downIndex = rightBound-1; // will scan leftward, 'down' the array
		   while (upIndex <= downIndex) 
		   { 
		       // scan right until larger than the pivot
		       while ( (upIndex <= downIndex) && (c.compare(s[upIndex], pivotValue)<=0) ) upIndex++; 
		       // scan leftward to find an element smaller than the pivot
		       while ( (downIndex >= upIndex) && (c.compare(s[downIndex], pivotValue)>=0)) downIndex--;
		       quickComp++;
		       if (upIndex < downIndex) { // both elements were found
		          temp = s[downIndex]; 
			      s[downIndex] = s[upIndex]; // swap these elements
			      s[upIndex] = temp;
			      quickMove++;
		       }
		   } // the loop continues until the indices cross
		    
		   
		   int pivotIndex = upIndex;
		   temp = s[rightBound]; // swap pivot with the element at upIndex
		   s[rightBound] = s[pivotIndex]; 
		   s[pivotIndex] = temp; 
		 
		   // the pivot is now at upIndex, so recursively quicksort each side
		   quickSortStep(s, c, leftBound, pivotIndex-1);
		   quickSortStep(s, c, pivotIndex+1, rightBound);
		}
		private static String array2String(String[] a)
		{
			String text="[";
			for (int i=0; i<a.length; i++) {
				text += a[i];
				if (i<a.length-1)
					text += ",";
			}
			text += "]";
			return text;
		}
		
	public static String[] CreateArray(int size){
	
		String[] arr= new String[size];
		for(int i=0;i<size;i++){
			arr[i] = Double.toString(Math.random()*1000);
		}
		return arr;
	}
	
	public static int CreateSize(int num){
		int size = 0;
		switch(num){
			case 0: size=1000; break;
			case 1: size=5000; break;
			case 2: size=10000; break;
			case 3: size=15000; break;
			case 4: size=30000; break;
		}
		return size;
	}

	public static void main(String[] args ){
		for(int i=0;i<=4;i++)
		{
			String[] toSort = CreateArray(CreateSize(i));
			
			String arrshell[] = (String[])toSort.clone();
			String arrquick[] = (String[])toSort.clone();
			String arrinsertion[] = (String[])toSort.clone();
			
			System.out.println("Size of the String: " + toSort.length);
			//System.out.println("Array before sorting:\n" + array2String(toSort));
			
			/*long insertionStartTime = System.currentTimeMillis();
			insertionSort(arrinsertion);
			long insertionEndTime = System.currentTimeMillis();
			long insertiondifference = insertionEndTime - insertionStartTime;
	
			System.out.println("Elapsed time in milliseconds for InsertionSort: " + insertiondifference);
			//System.out.println("After Sorting with InsertionSort:\n " + array2String(arrinsertion));
			System.out.println("Count of move operations for InsertionSort: " + insertionMove);
			System.out.println("Count of comparison operations for InsertionSort: " + insertionComp);
			
			long quickStartTime = System.currentTimeMillis();
			quickSort(arrquick, new StringComparator());
			long quickEndTime = System.currentTimeMillis();
			long quickdifference = quickEndTime - quickStartTime;
			
			System.out.println("Elapsed time in milliseconds for QuickSort: " + quickdifference);
			//System.out.println("After Sorting with QuickSort:\n " + array2String(arrquick));
			System.out.println("Count of move operations for QuickSort: " + quickMove);
			System.out.println("Count of comparison operations for QuickSort: " + quickComp);
			*/
			long shellStartTime = System.currentTimeMillis();
			shellSort(arrshell);
			long shellEndTime = System.currentTimeMillis();
			long shelldifference = shellEndTime - shellStartTime;
			
			System.out.println("Elapsed time in milliseconds for ShellSort: " + shelldifference);
			//System.out.println("After Sorting with ShellSort:\n " + array2String(arrshell));
			System.out.println("Count of move operations for ShellSort: " + shellMove);
			System.out.println("Count of comparison operations for ShellSort: " + shellComp);
			
		}
	}
}
