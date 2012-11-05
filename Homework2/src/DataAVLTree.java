
public class DataAVLTree implements AVLTree {
	
	// Fields
	int elem;
	AVLTree leftChild;
	AVLTree rightChild;
	
	// Constructors
	DataAVLTree(int elem, AVLTree leftChild, AVLTree rightChild){
		this.elem = elem;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	DataAVLTree(int elem){
		this(elem, new EmptyAVLTree(), new EmptyAVLTree());
	}
	
	
	// Methods
	public int size() {
		return this.leftChild.size() + this.rightChild.size() + 1;
	}
	
	// produces the largest element in the BST
	public int largestElem() {
	  return this.rightChild.largestElem(this.elem);
	}
	  
	public int largestElem(int parentValue){
		return this.rightChild.largestElem(this.elem);
	}
	  
	public int smallestElem() {
		return this.leftChild.smallestElem(this.elem);
	}
		  
	public int smallestElem(int parentValue){
		return this.leftChild.smallestElem(this.elem);
	}
	// ------------------------------------------------
	
	public AVLTree addElem(int elem) {
		if (elem == this.elem)
		      return this.rebalance(); // not storing duplicate values
		    else if (elem < this.elem)
		      return new DataAVLTree (this.elem,
		                          this.leftChild.addElem(elem),
		                          this.rightChild).rebalance();
		    else // elem > this.data
		      return new DataAVLTree (this.elem,
		                          this.leftChild,
		                          this.rightChild.addElem(elem)).rebalance();
	}

	// returns set containing all existing elements except the given element
	public AVLTree remElem (int elem) {
	 if (elem == this.elem) {
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
	     return this.leftChild.remParent(this.rightChild).rebalance();
	 }
	 else if (elem < this.elem)
	     return new DataAVLTree(this.elem, this.leftChild.remElem(elem), this.rightChild).rebalance();
	 else // (elem > this.data)
	    return new DataAVLTree(this.elem, this.leftChild, this.rightChild.remElem(elem)).rebalance();
	 }
	  
	  // returns the other sibling to remove parent of an empty sibling
	public AVLTree remParent(AVLTree rightSibling) {
		return rightSibling.mergeToRemoveParent(this);
	}

	// returns DataBST resulting from removing parent when both children are DataAVLTrees
	public AVLTree mergeToRemoveParent(AVLTree leftSibling) {
		// "this" refers to the original right sibling of the parent being deleted
		// here, could decide whether to use largest-in-left or smallest-in-right
		// and branch accordingly.  
		java.util.Random rand = new java.util.Random();
		boolean leftSide = rand.nextBoolean();
		if(leftSide){
			// use largest-in-left
			int newRoot = leftSibling.largestElem();
			return new DataAVLTree(newRoot,
					leftSibling.remElem(newRoot),
					this);
		}
		else {
			// use smallest-in-right
			int newRoot = this.smallestElem();
			return new DataAVLTree(newRoot,
					leftSibling,
					this.remElem(newRoot));
		}
	}
	

	public boolean hasElem(int elem) {
		if (elem == this.elem) 
		      return true; 
		    else if (elem < this.elem)
		      return this.leftChild.hasElem(elem);
		    else // elem > this.data
		      return this.rightChild.hasElem(elem);
	}
	
	public AVLTree rebalance() {
		if(this.isBalanced())
			return this;
		else {
			// TODO: insert re-balance code here
			// we already know the tree is not balanced,
			// and we also know that it will only take exactly
			// one or two rotations to balance it, so the next
			// step is figuring out which, and then implementing
			// them both
			
			return this;
		}
	}
	
	public AVLTree rotateLeft() {
		AVLTree root = this, pivot = this.rightChild;
		return new DataAVLTree(pivot.getElem(), 
				new DataAVLTree(root.getElem(),
						root.getLeftChild(),
						pivot.getLeftChild()),
				pivot.getRightChild());
	}
	
	public AVLTree rotateRight() {
		AVLTree root = this, pivot = this.leftChild;
		return new DataAVLTree(pivot.getElem(),
				pivot.getLeftChild(),
				new DataAVLTree(root.getElem(),
						pivot.getRightChild(),
						root.getRightChild()));
	}
	
	public int height() {
		return (leftChild.height() > rightChild.height() ?
				leftChild.height() : rightChild.height()) + 1;
	}
	
	public boolean isBalanced(){
		boolean currBalanced = Math.abs(leftChild.height() - rightChild.height()) <= 1;
		return currBalanced &&
				leftChild.isBalanced() &&
				rightChild.isBalanced();
	}

	public AVLTree getLeftChild() {
		return this.leftChild;
	}

	public AVLTree setLeftChild(AVLTree left) {
		this.leftChild = left;
		return this;
	}

	public AVLTree getRightChild() {
		return this.rightChild;
	}

	public AVLTree setRightChild(AVLTree right) {
		this.rightChild = right;
		return this;
	}
	
	public int getElem(){
		return this.elem;
	}
	
}
