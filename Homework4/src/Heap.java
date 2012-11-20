package hwk4;
import java.util.LinkedList;
import java.util.Random;

interface IHeap<T extends Comparable<T>> extends IBinTree<T> {
	// adds given element to the heap without removing other elements
	IHeap<T> addElt(T e);

	// removes one occurrence of the smallest element from the heap
	IHeap<T> remMinElt();

	// Merge the current heap with another heap
	IHeap<T> merge(IHeap<T> withHeap);

	// Determine if the root of this heap is bigger than the given element
	boolean isBigger(T e);

	// for Tests
	boolean isHeap();

	boolean isAddValid(T elem);

	boolean isRemMinValid();

	boolean isEmpty();

	LinkedList<T> toList();
}

class MtHeap<T extends Comparable<T>> implements IHeap<T> {
	MtHeap(){}

	@Override
	// Since a MtHeap is empty, it does not have the element
	public boolean hasElt(T e) {
		return false;
	}

	@Override
	// A MtHeap has a size of 0
	public int size() {
		return 0;
	}

	@Override
	// A MtHeap has a height of 0
	public int height() {
		return 0;
	}

	@Override
	// If you add an element to a MtHeap, you create a new DataHeap
	public IHeap<T> addElt(T e) {
		return new DataHeap<T>(e, new MtHeap<T>(), new MtHeap<T>());
	}

	@Override
	// The min element of an empty heap returns an empty heap.
	public IHeap<T> remMinElt() {
		return new MtHeap<T>();
	}

	@Override
	// An empty heap should always lose a competition for which root is smaller (for the merge function)
	public boolean isBigger(T e) {
		return true;
	}

	@Override
	// An empty heap merged with another heap is the other heap (identity).
	public IHeap<T> merge(IHeap<T> withHeap) {
		return withHeap;
	}

	// Testers
	public boolean isHeap(){
		return true;
	}

	public boolean isEmpty(){
		return true;
	}

	public boolean isAddValid(T elem){
		IHeap<T> h = this.addElt(elem);

		if(h.isEmpty())
			return false;
		DataHeap<T> d = (DataHeap<T>) h;
		return d.data == elem && d.left.isEmpty() && d.right.isEmpty();
	}

	public boolean isRemMinValid() {
		IHeap<T> h = this.remMinElt();
		return h.isEmpty();
	}

	public LinkedList<T> toList(){
		return new LinkedList<T>();
	}
}

class DataHeap<T extends Comparable<T>> extends DataBT<T> implements IHeap<T> {
	IHeap<T> left;
	IHeap<T> right;

	DataHeap(T data) {
		super(data, new MtHeap<T>(), new MtHeap<T>());
		this.left = new MtHeap<T>();
		this.right = new MtHeap<T>();
	}

	DataHeap(T data, IHeap<T> left, IHeap<T> right) {
		super(data, left, right);
		this.left = left;
		this.right = right;
	}

	public IHeap<T> merge(IHeap<T> withHeap) {
		T newRoot;
		IHeap<T> H1, H2, H3;

		// determine the new root value and the three subtrees to consider merging
		if (withHeap.isBigger(this.data)) {
			newRoot = this.data;
			H1 = (IHeap<T>) this.left;
			H2 = (IHeap<T>) this.right;
			H3 = withHeap;
		} else {
			// Since a MtHeap will always return true on isBigger, satisfying
			//  the first condition, we know that withHeap is a DataHeap.
			//  Therefore, we can cast it.
			newRoot = ((DataHeap<T>) withHeap).data;
			H1 = ((DataHeap<T>) withHeap).left;
			H2 = ((DataHeap<T>) withHeap).right;
			H3 = this;
		}

		// choose which trees to merge and construct the new tree
		if (H1.height() > H2.height() && H1.height() > H3.height()) {
			return new DataHeap<T> (newRoot, H1, H2.merge (H3));
		} else if (H2.height() > H1.height() && H2.height() > H3.height()) {
			return new DataHeap<T> (newRoot, H2, H1.merge (H3));
		} else if (H3.height() > H1.height() && H3.height() > H2.height()){
			return new DataHeap<T> (newRoot, H3, H1.merge (H2));
		} else {
			// If the two bigger heaps are of the same size, choose one at random.
			Random coinFlip = new Random();
			if (H1.height() == H2.height()) {
				if (coinFlip.nextInt() % 2 == 1) {
					return new DataHeap<T> (newRoot, H1, H2.merge(H3));
				} else {
					return new DataHeap<T> (newRoot, H2, H1.merge(H3));
				}
			} else if (H2.height() == H3.height()) {
				if (coinFlip.nextInt() % 2 == 1) {
					return new DataHeap<T> (newRoot, H2, H3.merge(H1));
				} else {
					return new DataHeap<T> (newRoot, H3, H2.merge(H1));
				}
			} else {
				if (coinFlip.nextInt() %2 == 1) {
					return new DataHeap<T> (newRoot, H3, H1.merge(H2));
				} else {
					return new DataHeap<T> (newRoot, H1, H3.merge(H2));
				}
			}
		}
	}


	@Override
	public IHeap<T> addElt(T e) {
		return this.merge(new DataHeap<T>(e, new MtHeap<T>(), new MtHeap<T>()));
	}

	@Override
	public IHeap<T> remMinElt() {
		return this.right.merge(this.left);
	}

	@Override
	public boolean isBigger(T e) {
		return (this.data.compareTo(e)) >= 0;
	}

	// Testers
	public boolean isEmpty() {
		return false;
	}

	public boolean isHeap(){
		return this.left.isBigger(this.data) &&
				this.right.isBigger(this.data) &&
				this.left.isHeap() &&
				this.right.isHeap();
	}

	public boolean isAddValid(T e) {
		IHeap<T> h = this.addElt(e);
		LinkedList<T> origElems = this.toList();
		origElems.add(e);
		LinkedList<T> newElems = h.toList();
		// make sure that the original and new lists are identical,
		// not necessarily same order
		for(int i = 0; i < origElems.size(); i++){
			if(!newElems.contains(origElems.get(i)))
				return false;
			newElems.remove(origElems.get(i));
		}
		return newElems.isEmpty() &&
				h.isHeap();
	}

	public boolean isRemMinValid(){
		IHeap<T> h = this.remMinElt();
		LinkedList<T> origElems = this.toList();
		T min = origElems.getFirst();
		for(int i =1; i < origElems.size(); i++){
			if(min.compareTo(origElems.get(i)) > 0)
				min = origElems.get(i);
		}
		
		// now min is the minimum valued element in the original list
		origElems.remove(min);

		LinkedList<T> newElems = h.toList();
		// make sure that the original and new lists are identical,
		// not necessarily same order
		for(int i = 0; i < origElems.size(); i++){
			if(!newElems.contains(origElems.get(i)))
				return false;
			newElems.remove(origElems.get(i));
		}
		
		return newElems.isEmpty() &&
				h.isHeap();
	}

	public LinkedList<T> toList(){
		LinkedList<T> leftList = this.left.toList(), 
				rightList = this.right.toList();
		leftList.add(this.data);
		leftList.addAll(rightList);
		return leftList;
	}
}