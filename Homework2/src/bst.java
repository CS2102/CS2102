
//-------------------------------------------------------------------------

interface IBST {
  // returns set containing all existing elements and the given element
  IBST addElt (int elt);
  // returns set containing all existing elements except the given element
  IBST remElt (int elt);
  // returns the number of distinct elements in the set
  int size ();
  // determines whether given element is in the set
  boolean hasElt (int elt);
  // produces the largest element in the BST
  int largestElt();
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
  public IBST addElt (int elt) {
    return new DataBST(elt, new MtBST(), new MtBST());
  }

  // returns set containing all existing elements except the given element
  public IBST remElt (int elt) { return this; }

  // determines whether the given element is in the set
  public boolean hasElt (int elt) { return false; }

  // largestElt not well-defined on empty BSTs, so raises an error
  public int largestElt () {
    throw new RuntimeException("shouldn't call largestElt on MtBST") ;
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
  public IBST addElt (int elt) {
    if (elt == this.data)
      return this; // not storing duplicate values
    else if (elt < this.data)
      return new DataBST (this.data,
                          this.left.addElt(elt),
                          this.right);
    else // elt > this.data
      return new DataBST (this.data,
                          this.left,
                          this.right.addElt(elt));
  }
  
  // produces the largest element in the BST
  public int largestElt() {
    if (this.right instanceof MtBST) 
      return this.data;
    else return this.right.largestElt();
  }
  
  // determines whether the given element is in the set
  public boolean hasElt (int elt) {
    if (elt == this.data) 
      return true; 
    else if (elt < this.data)
      return this.left.hasElt(elt);
    else // elt > this.data
      return this.right.hasElt(elt);
  }
  
  // returns set containing all existing elements except the given element
  public IBST remElt (int elt) {
   if (elt == this.data) {
       // four cases to consider.
       //
       //       elt        elt       elt       elt
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
   else if (elt < this.data)
       return new DataBST(this.data, this.left.remElt(elt), this.right);
   else // (elt > this.data)
      return new DataBST(this.data, this.left, this.right.remElt(elt)) ;
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
    int newRoot = leftSibling.largestElt();
    return new DataBST(newRoot,
                       leftSibling.remElt(newRoot),
                       this); 
  }
}

//-------------------------------------------------------------------------
/*
class Examples {
  Examples(){}
  
  IBST b1 = new DataBST (5, new MtBST(), new MtBST());
  IBST b2 = b1.addElt(3).addElt(4).addElt(8).addElt(7);
  IBST b2no4 = b1.addElt(3).addElt(8).addElt(7);
  IBST b2no8 = b1.addElt(3).addElt(4).addElt(7);
  IBST b2rem5 = new DataBST(4, new MtBST(), new MtBST()).addElt(3).addElt(8).addElt(7);

  // does size work as expected?
  boolean test1 (Tester t) {
    return t.checkExpect(b2.size(), 5);
  }
  
  // do size and addElt interact properly on a new element?
  boolean test2 (Tester t) {
    return t.checkExpect(b1.addElt(7).size(), 2);
  }
    
  // do size and addElt interact properly on a duplicate element?
  boolean test3 (Tester t) {
    return t.checkExpect(b1.addElt(5).size(), 1);
  }
  
  // check removal in left subtree
  boolean test4 (Tester t) {
    return t.checkExpect(b2.remElt(4), b2no4);
  }
  
  // check removal in right subtree
  boolean test5 (Tester t) {
    return t.checkExpect(b2.remElt(8), b2no8);
  }

  // check removal of root
  boolean test6 (Tester t) {
    return t.checkExpect(b2.remElt(5), b2rem5);
  }

}
 */ 