
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
	
	
	public AVLTree addElem(int elem) {
		// TODO: implement add code
		rebalance();
		return this;
	}

	public AVLTree remElem(int elem) {
		// TODO: implement remove code
		rebalance();
		return this;
	}

	public boolean hasElem(int elem) {
		return (this.elem == elem ||
				this.leftChild.hasElem(elem) ||
				this.rightChild.hasElem(elem));
	}
	
	private AVLTree rebalance(){
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
	
	public int height(){
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
