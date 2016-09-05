package QueueArray;
import javax.swing.JOptionPane;

/**
 * @author Michael Madden, Jan 2011, and Michael Schukat, Jan 2016
 * CT2109 Lab assignment: A modification of ArrayQueue to make it a CircularArrayQueue.
 * 
 * The idea is to  to eliminate the “shuffling” if we treated the array as if it were circular, 
 * so that when you try to add an item past the end, you instead insert it at the start.
 * 
 * This involves keeping track of the both the current head and the tail of the queue, 
 * and allowing them to increase continuously as items are added/removed. These head and tail 
 * positions are not ‘real’ array positions, but the corresponding actual array positions are 
 * found by computing the head/tail position modulus the array length.
 * 
 * Details:
 * - Keep track of front as well as rear; initially, front = 0 and rear = -1;
 * - At each enqueue, increment rear
 * - At each dequeue, increment front
 * - When indexing the array, run front/rear values through realindex(), which returns (index % capacity)
 * - Therefore, Q[rear] becomes Q[realindex(rear)] and Q[0] becomes Q[realindex(front)] 
 * 
 * Things to test for:
 * - Make a queue of fairly small capacity
 * - Does it behave correctly when you try to add too many items or remove items when it's full?
 * - Does it behave correctly when you've enqueued/dequeued enough items to make front & rear wrap around?
 */

public class CircularArrayQueue implements Queue 
{
	 protected Object Q[];				// array used to implement the queue
	 protected int front = 0;   		// index for the front of the queue: added for CircularArrayQueue
	 protected int rear = -1;			// index for the rear of the queue
	 protected int capacity; 			// The actual capacity of the queue array
	 public static final int CAPACITY = 10;	// default array capacity
	   
	 public CircularArrayQueue() {
		   // default constructor: creates queue with default capacity
		   this(CAPACITY);
	 }

	 public CircularArrayQueue(int cap) {
		  // this constructor allows you to specify capacity
		  capacity = (cap > 0) ? cap : CAPACITY;
		  Q = new Object[capacity]; 
	 }
	 
	 private int realindex(int index) {
		 // Added for CircularArrayQueue: Convert a 'virtual' front/rear value to a real one
		 return index % capacity;
	 }
	 
	 public void enqueue(Object n)
	 {
		 if (isFull()) {
			 JOptionPane.showMessageDialog(null, "Cannot enqueue object '" + (String)n + "'; queue is full.");
			 return;
		 }
		 rear++;
		 Q[realindex(rear)] = n; // changed for CircularArrayQueue
		 System.out.println("CircularArrayQueue: front=" + front + ", rear=" + rear); // just for debugging
	 }
	 
	 public Object dequeue()
	 {
		 // Can't do anything if it's empty
		 if (isEmpty())
			 return null;
		 
		 Object toReturn = Q[realindex(front)]; // changed for CircularArrayQueue
		 
		 // For CircularArrayQueue, no shuffling is required: instead, null out the item being returned and increment front
		 Q[realindex(front)] = null;
		 front++;
		 
		 System.out.println("CircularArrayQueue: front=" + front + ", rear=" + rear); // just for debugging
		 return toReturn;
	 }
	 
	 public boolean isEmpty()  {
		 // Changed for CircularArrayQueue: use front instead of 0.
		 // Note: testing (realindex(rear) < realindex(front)) does NOT work, because if front == -1 the modulus wraps it to N-1.
	     return (rear < front);
	 }
	 
	 public boolean isFull() {
		 // Changed for CirularArrayQueue: recognise that the previous test, rear == capacity-1,  
		 // was implicitly testing (rear - front) == capacity-1
		 
		 return ((rear - front) == (capacity-1));
	 }
	 
	 public Object front()
	 {
		 if (isEmpty())
			 return null;
		 
		 return Q[realindex(front)]; // Changed for CirularArrayQueue
	 }
	 
	 public int getFrontIndex() 
	 {
		 // Just for debugging/display
		 return front;
	 }
}