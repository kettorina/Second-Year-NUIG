package assignment2;

import javax.swing.JOptionPane;

import QueueArray.ArrayQueue;

public class LLQueueTest {
	
	public static void main(String args[]){
		//compares both the linked list and array, while implementing queue
		LLQueue test = new LLQueue();
		ArrayQueue queue = new ArrayQueue();
		int i=0; //counter
		
		//enqueue
		JOptionPane.showMessageDialog(null, "About to enqueue words onto queue: \nThe end is nigh!");
		test.enqueue("The");
		test.enqueue("end");
		test.enqueue("is");
		test.enqueue("nigh!");
		queue.enqueue("The");
		queue.enqueue("end");
		queue.enqueue("is");
		queue.enqueue("nigh!");
		
		//dequeue until linked list is empty
		JOptionPane.showMessageDialog(null, "About to dequeue the words linked list...");
		while(! test.isEmpty()) {
			i++;
			String word = (String)test.dequeue(); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued " + i + " : "  + word);
		}
		
		//dequeue until array is empty
		JOptionPane.showMessageDialog(null, "About to dequeue the words array...");
		while(!queue.isEmpty()){
			i++;
			String words = (String)queue.dequeue();
			JOptionPane.showMessageDialog(null, "Word dequeued " + i + " : "  + words);
		}
		System.exit(0);
	}
}
