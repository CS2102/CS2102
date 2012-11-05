
public class EmptyAVLTree implements AVLTree {

	public int size() {
		// size of an empty tree
		return 0;
	}
	
	// largestElem not well-defined on empty BSTs, so raises an error
	public int largestElem () {
	  throw new RuntimeException("shouldn't call largestelem on MtBST") ;
	}
	  
	public int largestElem(int parentValue){
		return parentValue;
	}
	  
	public int smallestElem () {
		throw new RuntimeException("shouldn't call smallestElem on MtBST") ;
	}
		  
	public int smallestElem(int parentValue){
		return parentValue;
	}
	// --------------------------------------------------------
	
	public AVLTree addElem(int elem) {
		return new DataAVLTree(elem);
	}

	public AVLTree remElem(int elem) {
		// can't remove an element from an empty tree,
		// so return an empty tree
		return this;
	}
	
	// returns the other sibling to remove parent of an empty sibling
	public AVLTree remParent(AVLTree rightsibling) {
	  return rightsibling;
	}
	  
	  // "this" is the right sibling; leftsibling is a DataBST
	public AVLTree mergeToRemoveParent(AVLTree leftsibling) {
	  return leftsibling;
	}

	public boolean hasElem(int elem) {
		return false;
	}

	public int height() {
		return 0;
	}
	
	public boolean isBalanced() {
		return true;
	}
	
	public AVLTree rebalance() {
		return this;
	}
	
	public AVLTree rotateLeft() {
		return this;
	}
	
	public AVLTree rotateRight() {
		return this;
	}

	public AVLTree getLeftChild() {
		throw new RuntimeException("ERROR CODE 40493: This error should never be called.");
	}

	public AVLTree setLeftChild(AVLTree newLeft) {
		throw new RuntimeException("ERROR CODE 40493: This error should never be called.");
	}

	public AVLTree getRightChild() {
		throw new RuntimeException("ERROR CODE 40493: This error should never be called.");
	}

	public AVLTree setRightChild(AVLTree newRight) {
		throw new RuntimeException("ERROR CODE 40493: This error should never be called.");
	}
}
