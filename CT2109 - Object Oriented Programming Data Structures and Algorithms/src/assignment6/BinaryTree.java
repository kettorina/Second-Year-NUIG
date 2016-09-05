package assignment6;import java.util.ArrayList;import java.util.LinkedList;import java.util.Queue;/** * A class that implements the ADT binary tree.
 *  * @author Frank M. Carrano * @version 2.0 */

public class BinaryTree<T> implements BinaryTreeInterface<T>, java.io.Serializable{
	private static final long serialVersionUID = -1932834476575953631L;
	private BinaryNodeInterface<T> root;
	
	public BinaryTree()
	{
		root = null;
	} 

	public BinaryTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} 

	public BinaryTree(T rootData, BinaryTree<T> leftTree,
 			BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	} 

	public void setTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} 

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree)
	{
		privateSetTree(rootData, (BinaryTree<T>)leftTree,
 				(BinaryTree<T>)rightTree);
	} 

	private void privateSetTree(T rootData, BinaryTree<T> leftTree,
 			BinaryTree<T> rightTree)
	{
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty())
		{
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} 

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();

 		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	private BinaryNode<T> copyNodes() // not essential
	{
		return (BinaryNode<T>)root.copy();
	} 

	public T getRootData()
	{
		T rootData = null;
		if (root != null)
			rootData = root.getData();
		return rootData;
	} 

	public boolean isEmpty()
	{
		return root == null;
	} 

	public void clear()
	{
		root = null;
	} 

	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	} 

	protected void setRootNode(BinaryNodeInterface<T> rootNode)
	{
		root = rootNode;
	} 

	protected BinaryNodeInterface<T> getRootNode()
	{
		return root;
	} 

	public int getHeight()
	{
		return root.getHeight();
	} 

	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
	} 

	public void inorderTraverse()
 	{
		inorderTraverse(root);
	}

	private void inorderTraverse(BinaryNodeInterface<T> node)
 	{
		if (node != null)
		{
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorderTraverse(node.getRightChild());
		} 
	} 		public void preorderTraverse()	 	{		preorderTraverse(root);	}		private void preorderTraverse(BinaryNodeInterface<T> node)	{	//This method of traversal will travel to the left most part of the binary	//tree until a leaf node, then goes to the right side of the tree and goes up	//the tree		if (node != null)//while the node isn't null		{			System.out.print(node.getData() + " ");//print out the node			preorderTraverse(node.getLeftChild());//travel to left and perform preorded			preorderTraverse(node.getRightChild());//travel to right and perform preorder		}	}	public void postorderTraverse()	 	{		postorderTraverse(root);	}		private void postorderTraverse(BinaryNodeInterface<T> node)	{	//This method traverses the left subtree then the right subtree	// and then visits the root		if (node != null)		{			postorderTraverse(node.getLeftChild());//visit the left node			postorderTraverse(node.getRightChild());//visit the right node			System.out.print(node.getData() + " ");//print out the root		}	}	
	void TreeBreadthFirst()	{		BinaryNode node = (BinaryNode) this.root;//creation of the temporary queue		Queue queue;		BinaryNodeInterface<T> traverse;//points which node is processed				if (node.getData() == null)		  return;  //Nothing to traverse				queue = new LinkedList();//create queue to hold nodes		queue.add(node);				while (!(queue).isEmpty()) {		   traverse = (BinaryNodeInterface<T>) (queue).remove();//the root is getting removed		   System.out.print(traverse.getData() + " ");		   if (traverse.getLeftChild() != null)			   queue.add(traverse.getLeftChild());//leftmost trees of that root is added to the queue		      		   if (traverse.getRightChild() != null)		      queue.add(traverse.getRightChild());//rightmost trees of that root is added to the queue		}	}	
} 