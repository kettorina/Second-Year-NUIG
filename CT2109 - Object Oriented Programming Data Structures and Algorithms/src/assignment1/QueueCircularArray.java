/** M Madden, M Schukat, 2005 - 2015: Abstract Stack interface */
package assignment1;
import javax.swing.JOptionPane;


public class QueueCircularArray implements QueueCircular{

	 protected Object Q[];				// array used to implement the queue 
	 protected int front = 0;			//index for the front rear of the queue
	 protected int rear = 0;			// index for the rear of the queue
	 protected int count = -1;			//index for counting how many elements in the array
	 protected int capacity; 			// The actual capacity of the queue array
	 public static final int CAPACITY = 1000;	// default array capacity
	   
	 public QueueCircularArray() {
		   // default constructor: creates queue with default capacity
		   this(CAPACITY);
	 }

	 public QueueCircularArray(int cap) {
		  // this constructor allows you to specify capacity
		  capacity = (cap > 0) ? cap : CAPACITY; // Conditional Operator
		  Q = new Object[capacity]; 
	 }
	 //this adds elements into the array by using mod
	 public void enqueue(Object n)
	 {
		 if (isFull()) {
			 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is full.");
			 return;
		 }
		 Q[rear] = n;
		 rear = (rear + 1)% capacity;//the index is done by using mod of the size ( the remainder act as a index)
		 count++;//increments the size of the array
		 
	 }
	/*this removes the front element of the queue and returns it. Compared to shuffling method where
	  where the rear gets decremented, the front gets incremented while rear stays the same*/
	 public Object dequeue()
	 {
		 // Can't do anything if it's empty
		 if (isEmpty())
			 return null;
		 
		 Object toReturn = Q[front];//gets the front element of the array
		 Q[front]= null;//empties the cell of the front element
		 
		 front=(front+1)%capacity;//increments the front so that the second element becomes the front etc.
		 count--;//count gets decremented as the size of the queue has been reduced by one
		 return toReturn;
	 }
	 /*this checks if the array is empty (by using count (initially placed at -1), 
	  * which gets incremented//decremented as the program enqueues/dequeues) 
	  */
		 public boolean isEmpty()  {
	     return (count == -1);//if the count is equals to -1, then the array is empty
	 }
	 //checks if the array is full by comparing count to the capacity of the array
	 public boolean isFull() {
		 return (count+1 == capacity);//if size of the array == capacity, return true
	 }
	 //this shows which element is placed at the front at the queue, without removing it 
	 public Object front()
	 {
		 if (isEmpty())//if the array is empty, nothing to show
			 return null;
		 
		 return Q[front];//returns the front value of the queue
	 }
	 // this is optional, but I've added the size() to check the size of the queue array
	 public int size(){
		 return (count+1);// as i initialised count as -1, in order to get the size add +1
	 }
}



