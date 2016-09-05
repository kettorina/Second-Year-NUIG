package QueueArray;

/**
 * @author Michael Madden, Jan 2011, and Michael Schukat, Jan 2016
 */

import javax.swing.JOptionPane;


public class CircularQueueTest {
	public static void main(String[] args) 
	{
		// Testing CircularArrayQueue
		// Initial test: at start of main(), replaced ArrayQueue with CircularArrayQueue and verified that program ran exactly as before.
		Queue q = new CircularArrayQueue();  
		
		// Put some strings onto the queue
		JOptionPane.showMessageDialog(null, "About to enqueue words onto queue: \nThe end is nigh!");
		q.enqueue("The");
		q.enqueue("end");
		q.enqueue("is");
		q.enqueue("nigh!");

		// Now dequeue them from the queue
		JOptionPane.showMessageDialog(null, "About to dequeue the words ...");
		while(! q.isEmpty()) {
			String word = (String)q.dequeue(); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word);
		}

		// More testing of CircularArrayQueue.
		// Things to test for:
		// - Make a queue of fairly small capacity
		// - Does it behave correctly when you try to add too many items or remove items when it's full?
		// - Does it behave correctly when you've enqueued/dequeued enough items to make front & rear wrap around?

		q = new CircularArrayQueue(5); // queue of small capacity 
		JOptionPane.showMessageDialog(null, "About to enqueue 4 words onto CircularArrayQueue");
		q.enqueue("This");
		q.enqueue("is");
		q.enqueue("a");
		q.enqueue("wrap");

		for (int i=0; i<3; i++) {
			String word = (String)q.dequeue(); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word);			
		}
		JOptionPane.showMessageDialog(null, "Front of queue: " + (String)q.front());			
		
		JOptionPane.showMessageDialog(null, "Enqueue 3 more words onto CircularArrayQueue");
		q.enqueue("adding");
		q.enqueue("more");
		q.enqueue("words");

		for (int i=0; i<3; i++) {
			String word = (String)q.dequeue(); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word);			
		}
		JOptionPane.showMessageDialog(null, "Front of queue: " + (String)q.front());			

		JOptionPane.showMessageDialog(null, "Enqueue some more words; exceed capacity");
		q.enqueue("and");
		q.enqueue("some");
		q.enqueue("more");
		q.enqueue("than");
		q.enqueue("can");
		q.enqueue("fit");
		
		JOptionPane.showMessageDialog(null, "About to dequeue the words ...");
		while(! q.isEmpty()) {
			String word = (String)q.dequeue(); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word);
		}
		
		System.exit(0);
	}

}
