package assignment1;

import javax.swing.JOptionPane;

import assignment1.QueueCircular;
import assignment1.QueueCircularArray;

public class QueueCircularTest {
	public static void main(String[] args) {
		// Create a Queue
		int i=1;//counter
		QueueCircularArray q = new QueueCircularArray(10);//creates an array of capacity 10
		
		//this checks if the circular method wraps around the array 
		JOptionPane.showMessageDialog(null, "About to enqueue: 996 995");
		q.enqueue(996);
		q.enqueue(995);
		JOptionPane.showMessageDialog(null, "Size of the queue is \n " +q.size());
		JOptionPane.showMessageDialog(null, "About to denqueue: ");
		int de = (int)q.dequeue();
		JOptionPane.showMessageDialog(null, "Dequeued: " + de);
		JOptionPane.showMessageDialog(null, "Size of the queue is \n " +q.size());
		// Now dequeue them from the queue
		JOptionPane.showMessageDialog(null, "About to enqueue  ...");
		//this populates the array until it is full
		while(! q.isFull()) {
			q.enqueue(i); // Note: have to cast Objects popped to String
			JOptionPane.showMessageDialog(null, "Number enqueued: " + i);
			i++;
		}
		//checks if the array contains 10 elements (checks if it's full)
		JOptionPane.showMessageDialog(null, "Size of the queue is \n " +q.size());
		//checks if the front of the queue remains 995
		int front=(int)q.front();
		JOptionPane.showMessageDialog(null, "Front of the queue is \n " + front);
		
		
		
		
		
		
		
		System.exit(0);
	}

}
