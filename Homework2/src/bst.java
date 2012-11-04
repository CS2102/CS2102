
//-------------------------------------------------------------------------

interface IBST {
  // returns set containing all existing elements and the given element
  IBST addElem (int elem);
  // returns set containing all existing elements except the given element
  IBST remElem (int elem);
  // returns the number of distinct elements in the set
  int size ();
  // determines whether given element is in the set
  boolean hasElem (int elem);
  // produces the largest element in the BST
  int largestElem();
  int largestElem(int parentValue);
  // removes the parent of a left child
  IBST remParent(IBST sibling);
  // removes the parent of a right child
  IBST mergeToRemoveParent(IBST sibling);
}
  
//-------------------------------------------------------------------------

class MtBST implements IBST  {
  MtBST() {}
  
  // returns the number of distinct elements in the set
  public int size () { return 0; }
  
  // returns set containing all existing elements and the given element
  public IBST addElem (int elem) {
    return new DataBST(elem, new MtBST(), new MtBST());
  }

  // returns set containing all existing elements except the given element
  public IBST remElem (int elem) { return this; }

  // determines whether the given element is in the set
  public boolean hasElem (int elem) { return false; }

  // largestelem not well-defined on empty BSTs, so raises an error
  public int largestElem () {
    throw new RuntimeException("shouldn't call largestelem on MtBST") ;
  }
  
  public int largestElem(int parentValue){
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
  IBST left;
  IBST right;
  
  DataBST(int data, IBST left, IBST right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  // returns the number of distinct elements in the set
  public int size() {
    return 1 + this.left.size() + this.right.size();
  }
  
  // returns set containing all existing elements and the given element
  public IBST addElem (int elem) {
    if (elem == this.data)
      return this; // not storing duplicate values
    else if (elem < this.data)
      return new DataBST (this.data,
                          this.left.addElem(elem),
                          this.right);
    else // elem > this.data
      return new DataBST (this.data,
                          this.left,
                          this.right.addElem(elem));
  }
  
  // produces the largest element in the BST
  public int largestElem() {
    return this.right.largestElem(this.data);
  }
  
  public int largestElem(int parentValue){
	  return this.right.largestElem(this.data);
  }
  
  // determines whether the given element is in the set
  public boolean hasElem (int elem) {
    if (elem == this.data) 
      return true; 
    else if (elem < this.data)
      return this.left.hasElem(elem);
    else // elem > this.data
      return this.right.hasElem(elem);
  }
  
  // returns set containing all existing elements except the given element
  public IBST remElem (int elem) {
   if (elem == this.data) {
       // four cases to consider.
       //
       //       elem        elem       elem       elem
       //      /   \      /  \      /  \      /  \
       //     Mt   BST   Mt  Mt   BST   Mt   BST BST
       //
       // Elegant solution is to break into two steps. If left child is Mt
       // then we can immediately return right sibling. If, however, left
       // child is BST try once more to see if easy case with Mt as right
       // sibling (mergeToRemoveParent) in which case return left child.
       // Fourth and final case is handled by BST mergeToRemoveParent      
       return this.left.remParent(this.right);
   }
   else if (elem < this.data)
       return new DataBST(this.data, this.left.remElem(elem), this.right);
   else // (elem > this.data)
      return new DataBST(this.data, this.left, this.right.remElem(elem)) ;
  }
  
  // returns the other sibling to remove parent of an empty sibling
  public IBST remParent(IBST rightSibling) {
    return rightSibling.mergeToRemoveParent(this);
  }
  
  // returns DataBST resulting from removing parent when both children are DataBSTS
  public IBST mergeToRemoveParent(IBST leftSibling) {
    // "this" refers to the original right sibling of the parent being deleted
    // here, could decide whether to use largest-in-left or smallest-in-right
    //   and branch accordingly.  Only showing largest-in-left code for now
    int newRoot = leftSibling.largestElem();
    return new DataBST(newRoot,
                       leftSibling.remElem(newRoot),
                       this); 
  }
}

//-------------------------------------------------------------------------
/*
class Examples {
  Examples(){}
  
  IBST b1 = new DataBST (5, new MtBST(), new MtBST());
  IBST b2 = b1.addElem(3).addElem(4).addElem(8).addElem(7);
  IBST b2no4 = b1.addElem(3).addElem(8).addElem(7);
  IBST b2no8 = b1.addElem(3).addElem(4).addElem(7);
  IBST b2rem5 = new DataBST(4, new MtBST(), new MtBST()).addElem(3).addElem(8).addElem(7);

  // does size work as expected?
  boolean test1 (Tester t) {
    return t.checkExpect(b2.size(), 5);
  }
  
  // do size and addElem interact properly on a new element?
  boolean test2 (Tester t) {
    return t.checkExpect(b1.addElem(7).size(), 2);
  }
    
  // do size and addElem interact properly on a duplicate element?
  boolean test3 (Tester t) {
    return t.checkExpect(b1.addElem(5).size(), 1);
  }
  
  // check removal in left subtree
  boolean test4 (Tester t) {
    return t.checkExpect(b2.remElem(4), b2no4);
  }
  
  // check removal in right subtree
  boolean test5 (Tester t) {
    return t.checkExpect(b2.remElem(8), b2no8);
  }

  // check removal of root
  boolean test6 (Tester t) {
    return t.checkExpect(b2.remElem(5), b2rem5);
  }

}
 */ 