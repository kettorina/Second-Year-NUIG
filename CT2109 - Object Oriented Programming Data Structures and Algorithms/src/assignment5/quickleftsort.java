package assignment5;

import java.util.Comparator;

	public class quickleftsort {
		protected static int quickMove = 0;
		protected static int quickComp = 0;
		
	
	
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
		   //random value than is between leftBound and rightBound
		   int random = leftBound + (int)(Math.random()*(rightBound-leftBound));
		
		   if (leftBound >= rightBound) return; // the indices have crossed
		   
		   Object temp;  // temp object used for swapping
		   //this swapping allows to swap the random value calculated with rightBound 
		   // as it uses rightBound to compare the values.
		   temp=s[random];
		   s[random]=s[rightBound];
		   s[rightBound]=temp;
		   
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
					case 3: size=12000; break;
				}
				return size;
			}
			
			public static double CalculateAverage(int[] arr){
				int sum = 0;
	            
	            for(int z=0; z < arr.length ; z++)
	            {	
	                    sum = sum + arr[z];
				}
	            double average = sum /(double) arr.length;
	            
	            return average;
			}
			
			public static void main(String[] args ){
				for(int i=0;i<=3;i++)
				{
					int[] AverageMove = new int[6];
					int[] AverageMoveSorted = new int[6];
					int[] AverageComp = new int[6];
					int[] AverageCompSorted = new int[6];
					int[] AverageTime = new int[6];
					int[] AverageTimeSorted = new int[6];
					
					for(int j=0;j<=4;j++){
						String[] toSort = CreateArray(CreateSize(i));
						
						long quickStartTime = System.currentTimeMillis();
						quickSort(toSort, new StringComparator());
						long quickEndTime = System.currentTimeMillis();
						long quickdifference = quickEndTime - quickStartTime;
						
						System.out.println("unsorted" + "\t" + toSort.length + "\t" + quickdifference +
								"\t"+ quickMove + "\t" +quickComp);
						AverageMove[j]=quickMove;
						AverageTime[j]=(int) quickdifference;
						AverageComp[j]=quickComp;
						
						
						//re-run the test by using the string which has been already sorted by quicksort
						quickMove=0; //to restart the count
						quickComp=0;
						long quickStartTimeSorted = System.currentTimeMillis();
						quickSort(toSort, new StringComparator());
						long quickEndTimeSorted = System.currentTimeMillis();
						long quickdifferenceSorted = quickEndTimeSorted - quickStartTimeSorted;
						
						System.out.println("sorted" + "\t" + toSort.length +"\t" + quickdifferenceSorted +
								"\t"+ quickMove + "\t" +quickComp);
						AverageMoveSorted[j]=quickMove;
						AverageTimeSorted[j]=(int) quickdifferenceSorted;
						AverageCompSorted[j]=quickComp;
					}
					double Move = CalculateAverage(AverageMove);
					double Comp = CalculateAverage(AverageComp);
					double Time = CalculateAverage(AverageTime);
					double MoveSorted = CalculateAverage(AverageMoveSorted);
					double CompSorted = CalculateAverage(AverageCompSorted);
					double TimeSorted = CalculateAverage(AverageTimeSorted);
					
					System.out.println("unsorted average" + "\t" + CreateSize(i) +"\t" + Time +
							"\t"+ Move + "\t" + Comp);
					System.out.println("sorted average" + "\t" + CreateSize(i) +"\t" + TimeSorted +
							"\t"+ MoveSorted + "\t" + CompSorted);
				}
		}
}






	








