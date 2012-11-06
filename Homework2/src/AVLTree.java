
public interface AVLTree extends IBST {
	
	int height();
	
	boolean isBalanced();
	
	AVLTree rebalance();
	
	AVLTree rotateLeft();
	
	AVLTree rotateRight();
}
