package assignment2;

import javax.swing.JOptionPane;

public class LLQueue implements Queue{
	
	 protected SLinkedList list;
	 protected int rear = -1;			// index for the rear of the queue
	 
	 //constructor
	 public LLQueue() {//creates a link list
		   list = new SLinkedList();
		   
	 }
	 //adds an element
	 public void enqueue(Object n)
	 {
		 list.insertNext(n);
		 //if it's empty, it will insert in the head (done in the slinkedList)
	 }
	 //removes an element
	 public Object dequeue()
	 {
		 // Can't do anything if it's empty
		 if (isEmpty())
			 return null;
		 
		 Object toRemove;//object to remove
		 
		 list.gotoHead();//returns a boolean, but sets head as current
		 toRemove = list.getCurr();//sets current as the object to remove
		 list.deleteHead();//deletes the head
		 
		 return toRemove;//returns the object
	 }
	 //checks if the linked list is empty
	 public boolean isEmpty()  {// checks if empty
	     return (list.isEmpty());//returns true if slinkedlist is empty
	 }
	 //checks if the linked list is full
	 public boolean isFull() {
		 return (false);//can't be full as there is no capacity
	 }
	 //returns the front without removing the head
	 public Object front()
	 {
		 if (isEmpty()){//if empty no front element is present
			 return null;
		 }
		 
		 return list.gotoHead();//if not empty calls list.gotoHead()
	 }
}
