
public interface AVLTree {

	int size();

	int height();

	AVLTree addElem(int elem);

	AVLTree remElem(int elem);

	boolean hasElem(int elem);

	boolean isBalanced();
	
	int largestElem();
	
	int largestElem(int parentValue);
	
	int smallestElem();
	
	int smallestElem(int parentValue);
}