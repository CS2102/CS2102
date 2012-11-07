
//-------------------------------------------------------------------------

interface IBST extends ISet {
  // produces the largest element in the BST
  int largestElem();
  int largestElem(int parentValue);
  // produces the smallest element in the BST
  int smallestElem();
  int smallestElem(int parentValue);
  // removes the parent of a left child
  IBST remParent(IBST sibling);
  // removes the parent of a right child
  IBST mergeToRemoveParent(IBST sibling);
int height();
}
  
//-------------------------------------------------------------------------

class MtBST implements IBST  {
  MtBST() {}
  
  public int height() {return 0;}
  
  // returns the number of distinct elements in the set
  public int size () {return 0;}
  
  // returns set containing all existing elements and the given element
  public IBST addElem (int elem) {
    return new DataBST(elem, new MtBST(), new MtBST());
  }

  // returns set containing all existing elements except the given element
  public IBST remElem (int elem) {return this;}

  // determines whether the given element is in the set
  public boolean hasElem (int elem) {return false;}

  // largestElem not well-defined on empty BSTs, so raises an error
  public int largestElem () {
    throw new RuntimeException("shouldn't call largestElem on MtBST") ;
  }
  
  public int largestElem(int parentValue){
	  return parentValue;
  }
  
  // smallestElem not well-defined on empty BSTs, so raises an error
  public int smallestElem () {
	  throw new RuntimeException("shouldn't call smallestElem on MtBST") ;
  }
	  
  public int smallestElem(int parentValue){
	  return parentValue;
   }
  
  // returns the other sibling to remove parent of an empty sibling
  public IBST remParent(IBST rightsibling) {
    return rightsibling;
  }
  
  // "this" is the right sibling; leftsibling is a DataBST
  public IBST mergeToRemoveParent(IBST leftsibling) {
    return leftsibling;
  }
}

//-------------------------------------------------------------------------

class DataBST implements IBST {
  int data;
  IBST leftChild;
  IBST rightChild;
  
  DataBST(int data, IBST left, IBST right) {
    this.data = data;
    this.leftChild = left;
    this.rightChild = right;
  }
  
  // returns height of tree
  public int height() {
		return (leftChild.height() > rightChild.height() ?
				leftChild.height() : rightChild.height()) + 1;
	}
  
  // returns the number of distinct elements in the set
  public int size() {
    return 1 + this.leftChild.size() + this.rightChild.size();
  }
  
  // returns set containing all existing elements and the given element
  public IBST addElem (int elem) {
    if (elem == this.data)
      return this; // not storing duplicate values
    else if (elem < this.data)
      return new DataBST (this.data,
                          (IBST) this.leftChild.addElem(elem),
                          this.rightChild);
    else // elem > this.data
      return new DataBST (this.data,
                          this.leftChild,
                          (IBST) this.rightChild.addElem(elem));
  }
  
  // produces the largest element in the BST
  public int largestElem() {
    return this.rightChild.largestElem(this.data);
  }
  
  public int largestElem(int parentValue){
	  return this.rightChild.largestElem(this.data);
  }
  
  // produces the smallest element in the BST
  public int smallestElem() {
	  return this.leftChild.smallestElem(this.data);
  }
	  
  public int smallestElem(int parentValue){
	  return this.leftChild.smallestElem(this.data);
  }
  
  // determines whether the given element is in the set
  public boolean hasElem (int elem) {
    if (elem == this.data) 
      return true; 
    else if (elem < this.data)
      return this.leftChild.hasElem(elem);
    else // elem > this.data
      return this.rightChild.hasElem(elem);
  }
  
  // returns set containing all existing elements except the given element
  public IBST remElem (int elem) {
   if (elem == this.data) {
       // four cases to consider.
       //
       //       elem        elem       elem       elem
       //      /   \        /  \      /    \      /  \
       //     Mt   BST     Mt  Mt    BST   Mt    BST BST
       //
       // Elegant solution is to break into two steps. If left child is Mt
       // then we can immediately return right sibling. If, however, left
       // child is BST try once more to see if easy case with Mt as right
       // sibling (mergeToRemoveParent) in which case return left child.
       // Fourth and final case is handled by BST mergeToRemoveParent      
       return this.leftChild.remParent(this.rightChild);
   }
   else if (elem < this.data)
       return new DataBST(this.data, 
    		   (IBST) this.leftChild.remElem(elem), 
    		   this.rightChild);
   else // (elem > this.data)
      return new DataBST(this.data, 
    		  this.leftChild, 
    		  (IBST) this.rightChild.remElem(elem));
  }
  
  // returns the other sibling to remove parent of an empty sibling
  public IBST remParent(IBST rightSibling) {
    return rightSibling.mergeToRemoveParent(this);
  }
  
  // returns DataBST resulting from removing parent when both children are DataBSTS
  public IBST mergeToRemoveParent(IBST leftSibling) {
    // "this" refers to the original right sibling of the parent being deleted
    // here, could decide whether to use largest-in-left or smallest-in-right
    // and branch accordingly.  
	java.util.Random rand = new java.util.Random();
	boolean leftSide = rand.nextBoolean();
	if(leftSide){
		// use largest-in-left
	int newRoot = leftSibling.largestElem();
    	return new DataBST(newRoot,
                       (IBST) leftSibling.remElem(newRoot),
                       this);
	}
	else {
		// use smallest-in-right
		int newRoot = this.smallestElem();
	    return new DataBST(newRoot,
	    				leftSibling,
	                    this.remElem(newRoot));
	}
  }
}