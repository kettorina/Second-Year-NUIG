package assignment6;


interface BinaryNodeInterface<T>










  public BinaryNodeInterface<T> getLeftChild();


   *  @return the node that is this node�s right child */



   *  @param leftChild  a node that will be the left child */



   *  @param rightChild  a node that will be the right child */
  public void setRightChild(BinaryNodeInterface<T> rightChild);


   *  @return true if the node has a left child */


  /** Task: Detects whether the node has a right child.
   *  @return true if the node has a right child */




  public boolean isLeaf();


   *  @return the number of nodes in the subtree rooted at this node */
  public int getNumberOfNodes();

  /** Task: Computes the height of the subtree rooted at this node.
   *  @return the height of the subtree rooted at this node */
  public int getHeight();





