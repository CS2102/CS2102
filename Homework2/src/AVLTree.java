
public interface AVLTree {

	int size();

	int height();

	AVLTree addElem(int elem);

	AVLTree remElem(int elem);
	
	AVLTree remParent(AVLTree sibling);
	
	AVLTree mergeToRemoveParent(AVLTree sibling);
	
	int smallestElem();
	int smallestElem(int parentValue);
	
	int largestElem();
	int largestElem(int parentValue);

	boolean hasElem(int elem);

	boolean isBalanced();
	
	AVLTree rebalance();
	
	AVLTree rotateLeft();
	
	AVLTree rotateRight();
	
}
