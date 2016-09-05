package DoubleLinkLists;
import javax.swing.JOptionPane;

// M Madden, M Schukat, 2005 - 2016

public class DLLTest 
{
	public static void main(String[] args)
	{
		// Create an empty doubly linked list
		DLinkedList list = new DLinkedList();

		// Add some items to the list
		list.insertNext("AA"); 
		list.insertNext("BB");
		list.insertNext("CC");
		list.insertNext("DD");
		list.insertNext("EE");
		display(list);
		displayBackwards(list);
		
		list.gotoTail();
		list.insertNext("FF");
		JOptionPane.showMessageDialog(null, "Tail is: " + list.getCurr());
		
		list.gotoHead();
		list.insertNext("Second");
		display(list);
		displayBackwards(list);
		
		JOptionPane.showMessageDialog(null, "Size of list = " + list.size());
	}

	public static void display(DLinkedList list)
	{
		String alltext = "";
		Boolean haveNode = list.gotoHead();
		while (haveNode) {
			alltext +=  " " + list.getCurr();
			haveNode = list.gotoNext();
		}
		JOptionPane.showMessageDialog(null, "Full List ("+ list.size() + " size): " + alltext);
	}
	
	public static void displayBackwards(DLinkedList list)
	{
		String alltext = "";
		Boolean haveNode = list.gotoTail();
		while (haveNode) {
			alltext +=  " " + list.getCurr();
			haveNode = list.gotoPrev();
		}
		JOptionPane.showMessageDialog(null, "Full List Backwards: " + alltext);
	}


}
