package Node;

public class NodeTest 
{
	public static void main(String[] args) 
	{
		// M Madden, M Schukat, 2005 - 2016
		
		// IMPORTANT: This code is just testing the Node class, but in practice 
		// you should use the LList class which in turn will use the Node class as required.
		
		// Here is code to create 2 nodes: rest will be done in class

		Node p = new Node("Node A", null);
		Node q = new Node("Node B", null);
		p.setNext(q);

		// Create more nodes
		Node c = new Node("Node C", null);
		Node d = new Node("Node D", null);

		q.setNext(c);
		c.setNext(d);

		q = new Node("Node E", null);
		d.setNext(q);
		
		q = new Node("Node -A", p);
		

		// Loop through them
		Node curr = q;
		while (curr != null) {
  		  System.out.println("Data in current node is: " + curr.getElement());
		  curr = curr.getNext();
		}
		
	}

}
