
public class EmptyAVLTree implements AVLTree {

	public int size() {
		// size of an empty tree
		return 0;
	}
	
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

	public AVLTree addElem(int elem) {
		return new DataAVLTree(elem);
	}

	public AVLTree remElem(int elem) {
		// can't remove an element from an empty tree, just return the same tree
		return this;
	}
	
	// returns the other sibling to remove parent of an empty sibling
	public AVLTree remParent(IBST rightsibling) {
	  return (AVLTree) rightsibling;
	}
	  
	// returns the other sibling to remove parent of an empty sibling
	public AVLTree mergeToRemoveParent(IBST leftsibling) {
	  return (AVLTree) leftsibling;
	}

	public boolean hasElem(int elem) {
		// an empty tree has no elements
		return false;
	}

	public int height() {
		return 0;
	}
	
	// always balanced
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
}
