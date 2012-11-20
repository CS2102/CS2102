package hwk4;

import java.util.Random;


class TestHeap1<T extends Comparable<T>> extends DataHeap<T> {
	IHeap<T> left;
	IHeap<T> right;

	TestHeap1(T data, IHeap<T> left, IHeap<T> right) {
		super(data, left, right);
		this.left = left;
		this.right = right;
	}

	@Override
	public IHeap<T> addElt(T e) {
		return new TestHeap1<T> (e, this.left, this.right);
	}
}




class TestHeap2<T extends Comparable<T>> extends DataHeap<T> {
	IHeap<T> left;
	IHeap<T> right;

	TestHeap2 (T data, IHeap<T> left, IHeap<T> right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}

	@Override
	public IHeap<T> remMinElt() {
		if (this.left.height() == 0 || this.right.height() == 0) {
			return super.remMinElt();
		} else {
			return new TestHeap2<T> (data, this.left, this.right.remMinElt());
		}
	}
}



class TestHeap3<T extends Comparable<T>> extends DataHeap<T> {
	IHeap<T> left;
	IHeap<T> right;

	TestHeap3(T data, IHeap<T> left, IHeap<T> right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isBigger(T e) {
		// Had to "fix" this so code would compile, as '<' is not defined for type T
		return (this.data.compareTo(e)<0);
	}
}




class TestHeap4<T extends Comparable<T>> extends DataHeap<T> {
	IHeap<T> left;
	IHeap<T> right;

	TestHeap4(T data, IHeap<T> left, IHeap<T> right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public IHeap<T> addElt(T e) {
		return this.merge(new DataHeap<T>(e, new DataHeap<T>(e, new MtHeap<T>(), new MtHeap<T>()), new MtHeap<T>()));
	}
}


//Forced this to be a integer, as testheap5 is used specifically in this file to store integers
class TestHeap5 extends DataHeap<Integer> {
	IHeap<Integer> left;
	IHeap<Integer> right;

	TestHeap5(Integer data, IHeap<Integer> left, IHeap<Integer> right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public IHeap<Integer> remMinElt() {
		return new TestHeap5 (0, this.right, this.left);
	}
}



class TestHeap6 extends DataHeap<Integer> {
	IHeap<Integer> left;
	IHeap<Integer> right;

	TestHeap6(Integer data, IHeap<Integer> left, IHeap<Integer> right) {
		super (data, left, right);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public IHeap<Integer> addElt(Integer e) {
		Random newElt = new Random();
		return new TestHeap5 (newElt.nextInt(), this.right, this.left);
	}
}