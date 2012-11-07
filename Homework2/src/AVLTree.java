
public interface AVLTree extends IBST {
	
	boolean isBalanced();
	
	AVLTree rebalance();
	
	AVLTree rotateLeft();
	
	AVLTree rotateRight();
}
