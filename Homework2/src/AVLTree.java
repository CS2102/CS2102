
<<<<<<< HEAD
public interface AVLTree {

	int size();

	int height();

	AVLTree addElem(int elem);

	AVLTree remElem(int elem);

	boolean hasElem(int elem);

	boolean isBalanced();
=======
public class AVLTree implements ISet {
	int size;
	
	AVLTree() {
		this.size = 0;
	}

	public ISet addElem(int elem) {
		rebalance();
		return this;
	}

	public ISet removeElem(int elem) {
		rebalance();
		return this;
	}

	public boolean hasElem(int elem) {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private AVLTree rebalance() {
		if (isBalanced()) {
			return this;
		}
		else {
			// TODO: Balance code
			return this;
		}
	}
	
	private boolean isBalanced() {
		return true;
	}
>>>>>>> 26de3cc81cd069ba3feb6af3727dca43dc16f99a
}
