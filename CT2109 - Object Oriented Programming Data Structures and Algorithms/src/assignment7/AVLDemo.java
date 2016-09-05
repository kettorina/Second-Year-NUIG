package assignment7;

public class AVLDemo {
	
	public static void main (String[] args){
		
		double[] time = new double[100];	
		for(int i=0;i<=5;i++)
		{		
		
			//part 1 which creates an empty tree and adds entries into it using .add
			System.out.println("Constructing a test tree ...");
			long StartTime = System.currentTimeMillis();
			AVLTree<String> testTree = new AVLTree<String>();
			testTree.add("Germany");
			testTree.add("Latvia");
			testTree.add("Denmark");
			testTree.add("Finland");
			testTree.add("America");
			testTree.add("Japan");
			testTree.add("Korea");
			testTree.add("New Zealand");
			testTree.add("Norway");
			testTree.add("France");
			testTree.add("Italy");
			testTree.add("Switzerland");
			testTree.add("Australia");
			testTree.add("China");
			long EndTime = System.currentTimeMillis();
			long difference = EndTime - StartTime;
			System.out.println("Time taken: " + difference);
			time[i]=(double)difference;
			
			// part 2 which performs the inorderTraversal and displays stats
			System.out.println("\nIn-order traversal of the test tree part 2");
			long StartTime2 = System.currentTimeMillis();
			testTree.inorderTraverse();
			long EndTime2 = System.currentTimeMillis();
			long difference2 = EndTime2 - StartTime2;
			System.out.println("Time taken:" +difference2);
			System.out.println("\nSome statistics about the test tree part 2");
			displayStats(testTree);
			
			//part 3 which adds an entry which already exists
			System.out.println("\nIn-order traversal of the test tree part 3");
			long StartTime3 = System.currentTimeMillis();
			testTree.add("France");
			long EndTime3 = System.currentTimeMillis();
			long difference3 = EndTime3 - StartTime3;
			System.out.println("Time taken:" +difference3);
			testTree.inorderTraverse();
			System.out.println("\nSome statistics about the test tree part 3");
			displayStats(testTree);
			
			
			//part 5 which searches for entries
			long StartTime5 = System.currentTimeMillis();
			testTree.contains("France");
			testTree.contains("Korea");
			long EndTime5 = System.currentTimeMillis();
			long difference5 = EndTime5 - StartTime5;
			System.out.println("Time taken:" +difference5);
			if(!(testTree.contains("France"))){
	
				System.out.println("\nFrance is not found");
			}
			else if((testTree.contains("France"))){
				System.out.println("\nFrance is found");
			}
			if(!(testTree.contains("Korea"))){
				System.out.println("\nKorea is not found");
			}
			else if((testTree.contains("Korea"))){
				System.out.println("\nKorea is found");
			}
		}
		double total = CalculateAverage(time);
		System.out.println(total);
	}
	
	public static double CalculateAverage(double[] arr){
		double sum = 0;
        
        for(int z=0; z < arr.length ; z++)
        {	
                sum = sum + arr[z];
		}
        double average = sum /(double) arr.length;
        
        return average;
	}
	
	public static void displayStats(BinarySearchTreeR<String> tree)
	{
		if (tree.isEmpty())
			System.out.println("The tree is empty");
		else
			System.out.println("The tree is not empty");
		
		System.out.println("Root of tree is " + tree.getRootData());
		System.out.println("Height of tree is " + tree.getHeight());
		System.out.println("No. of nodes in tree is " + tree.getNumberOfNodes());
	} // end displayStats 
}
