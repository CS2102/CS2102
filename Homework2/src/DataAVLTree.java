
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
	// for each case, the AVLTree must call rebalance before returning
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

	// returns DataAVLTree resulting from removing parent when both children are DataAVLTrees
	public AVLTree mergeToRemoveParent(AVLTree leftSibling) {
		// "this" refers to the original right sibling of the parent being deleted
		// here, randomly decide whether to use largest-in-left or smallest-in-right  
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
			// check right-right    P = -2, R = -1
			//       right-left     P = -2, R = +1
			//       left-left      P = +2, L = +1, and
			//       left-right     P = +2, L = -1
			// cases, rotate the tree appropriately in each case
			// additional remElem cases:  P = 2 & L = 0, and P = -2 & R = 0
			int pBalanceFactor = 
					this.leftChild.height() -
					this.rightChild.height();
			if(pBalanceFactor == -2){
				// if the right tree is 2 nodes higher than left,
				// the right child must be a DataAVLTree
				int rBalanceFactor =
					((DataAVLTree) this.rightChild).leftChild.height() -
					((DataAVLTree) this.rightChild).rightChild.height();
				if(rBalanceFactor == -1){
					// right-right   single left rotation around P
					return this.rotateLeft();
				}
				else if(rBalanceFactor == 1){
					// right-left    right rotation around R, then left rotation around P
					return new DataAVLTree(this.elem,
							this.leftChild,
							this.rightChild.rotateRight()).rotateLeft();
				}
				else if(rBalanceFactor == 0){
					// left rotation around P
					return this.rotateLeft();
				}
			}
			else if(pBalanceFactor == 2){
				// if left tree is 2 nodes higher than right,
				// the left child must be a DataAVLTree
				int lBalanceFactor = 
						((DataAVLTree) this.leftChild).leftChild.height() -
						((DataAVLTree) this.leftChild).rightChild.height();
				if(lBalanceFactor == 1){
					// left-left    single right rotation around P
					return this.rotateRight();
				}
				else if(lBalanceFactor == -1){
					// left-right    left rotation around L, then right rotation around P
					return new DataAVLTree(this.elem,
							this.leftChild.rotateLeft(),
							this.rightChild).rotateRight();
				}
				else if(lBalanceFactor == 0){
					// right rotation around P
					return this.rotateRight();
				}
			}
			// if we get here there's something wrong, since every case should have been covered
			throw new Error("Error when rebalancing: " + this.toString());
		}
	}
	
	public AVLTree rotateLeft() {
		// only calling the rotateLeft method when
		// the height from the root is at least 2,
		// thus pivot is guaranteed to also be a DataAVLTree
		DataAVLTree root = this, pivot = (DataAVLTree) this.rightChild;
		return new DataAVLTree(pivot.elem, 
				new DataAVLTree(root.elem,
						root.leftChild,
						pivot.leftChild),
				pivot.rightChild);
	}
	
	public AVLTree rotateRight() {
		// only calling the rotateRight method when
		// the height from the root is at least 2,
		// thus pivot is guaranteed to also be a DataAVLTree
		DataAVLTree root = this, pivot = (DataAVLTree) this.leftChild;
		return new DataAVLTree(pivot.elem,
				pivot.leftChild,
				new DataAVLTree(root.elem,
						pivot.rightChild,
						root.rightChild));
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
}
