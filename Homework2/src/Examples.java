import tester.*;

public class Examples {
	
	Queue Q = new QueueImplX();
	Stack S = new StackImplX();
	PriorityQueue P = new PriorityQueueImplX();
	
	AVLTree A = new EmptyAVLTree();
	
	ISet set = new EmptyAVLTree();
	
	// testing basic element containing
	boolean testAVL(Tester t){
		return t.checkExpect(A.addElem(4).addElem(6).addElem(3).addElem(5).hasElem(4),
				true);
	}
	
	// testing auto-balance feature
	boolean testAVL2(Tester t){
		A = new EmptyAVLTree();
		return t.checkExpect(((AVLTree)A.addElem(5).addElem(6).addElem(7)).height(),
				2);
	}
	
	// testing combination of add and remove
	boolean testAVL3(Tester t){
		A = new EmptyAVLTree();
		return t.checkExpect(A.addElem(8).addElem(14).addElem(4).addElem(3)
				.addElem(7).addElem(9).addElem(15).remElem(14).remElem(8).hasElem(3), 
				true);
	}
	
	// testing extremely unbalanced tree
	boolean testAVL4(Tester t){
		A = new EmptyAVLTree();
		return t.checkExpect(((AVLTree)A.addElem(1).addElem(2).addElem(3).addElem(4).addElem(5))
				.height(),  3);
	}
	
	boolean testAVLx(Tester t){
		// more tests...
		return true;
	}
	
	// --------------------------------------------------------------------------------------------
	
	boolean testQueue(Tester t) {
		return t.checkExpect(new QueueImplX().enqueue(3).dequeue(),
				new QueueImplX());
	}
	
	boolean testQueue2(Tester t) {
		return t.checkExpect(new QueueImplX().enqueue(7).enqueue(4).enqueue(5).dequeue(),
				new QueueImplX().enqueue(4).enqueue(5));
	}
	
	boolean testQueue3(Tester t) {
		return t.checkExpect(new QueueImplX().enqueue(4).enqueue(5).front(),
				4);
	}
	
	boolean testQueue4(Tester t) {
		return t.checkExpect(new QueueImplX().enqueue(4).enqueue(5).dequeue(),
				new QueueImplX().enqueue(5));
	}

// ------------------------------------------------------------------------------------------------
	
	boolean testStack(Tester t) {
		return t.checkExpect(new StackImplX().push(45).pop(),
				new StackImplX());
	}
	
	boolean testStack2(Tester t) {
		return t.checkExpect(new StackImplX().push(45).push(768).pop(),
				new StackImplX().push(45));
	}

	boolean testStack3(Tester t) {
		return t.checkExpect(new StackImplX().push(7).push(4).push(5).pop(),
				new StackImplX().push(7).push(4));
	}

	boolean testStack4(Tester t) {
		return t.checkExpect(new StackImplX().push(7).push(4).push(5).top(), 5);
	}

	boolean testStack5(Tester t) {
		return t.checkExpect(new StackImplX().push(7).push(4).push(5).pop().top(), 4);
	}
	
// ------------------------------------------------------------------------------------------------
	
	boolean testPQ(Tester t) {
		return t.checkExpect(new PriorityQueueImplX().addElt(5).remMinElt(), 
				new PriorityQueueImplX());
	}
	
	boolean testPQ2(Tester t) {
		return t.checkExpect(new PriorityQueueImplX().addElt(5).addElt(3).remMinElt(),
				new PriorityQueueImplX().addElt(5));
	}
	
	boolean testPQ3(Tester t) {
		return t.checkExpect(new PriorityQueueImplX().addElt(5).addElt(3).getMinElt(), 3);
	}
	
	boolean testPQ4(Tester t) {
		return t.checkExpect(new PriorityQueueImplX().addElt(7).addElt(4).addElt(5).remMinElt(),
				new PriorityQueueImplX().addElt(7).addElt(5));
	}

	boolean testPQ5(Tester t) {
		return t.checkExpect(new PriorityQueueImplX().addElt(7).addElt(4).addElt(5).remMinElt()
				.getMinElt(),  5);
	}
}

/*
class Examples {
  Examples(){}
  
  IBST b1 = new DataBST (5, new MtBST(), new MtBST());
  IBST b2 = b1.addElem(3).addElem(4).addElem(8).addElem(7);
  IBST b2no4 = b1.addElem(3).addElem(8).addElem(7);
  IBST b2no8 = b1.addElem(3).addElem(4).addElem(7);
  IBST b2rem5 = new DataBST(4, new MtBST(), new MtBST()).addElem(3).addElem(8).addElem(7);

  // does size work as expected?
  boolean test1 (Tester t) {
    return t.checkExpect(b2.size(), 5);
  }
  
  // do size and addElem interact properly on a new element?
  boolean test2 (Tester t) {
    return t.checkExpect(b1.addElem(7).size(), 2);
  }
    
  // do size and addElem interact properly on a duplicate element?
  boolean test3 (Tester t) {
    return t.checkExpect(b1.addElem(5).size(), 1);
  }
  
  // check removal in left subtree
  boolean test4 (Tester t) {
    return t.checkExpect(b2.remElem(4), b2no4);
  }
  
  // check removal in right subtree
  boolean test5 (Tester t) {
    return t.checkExpect(b2.remElem(8), b2no8);
  }

  // check removal of root
  boolean test6 (Tester t) {
    return t.checkExpect(b2.remElem(5), b2rem5);
  }

}
 */ 