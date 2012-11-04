
public class EmptyAVLTree implements AVLTree {

	public int size() {
		// size of an empty tree
		return 0;
	}

	public AVLTree addElem(int elem) {
		return new DataAVLTree(elem);
	}

	public AVLTree remElem(int elem) {
		// can't remove an element from an empty tree,
		// so return an empty tree
		return this;
	}

	public boolean hasElem(int elem) {
		return false;
	}

	public int height() {
		return 0;
	}
	
	public boolean isBalanced(){
		return true;
	}

	public int largestElem() {
		return 0;
	}

	public int largestElem(int parentValue) {
		return parentValue;
	}

	public int smallestElem() {
		return 0;
	}

	public int smallestElem(int parentValue) {
		return parentValue;
	}

}
