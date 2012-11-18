import tester.Tester;


public class Examples {
	Examples() {}
	
	
	boolean test1(Tester t) {
		MtHeap<Integer> h = new MtHeap<Integer>();
		return t.checkExpect(h.isAddValid(5), true);
	}
	
	boolean test2(Tester t) {
		DataHeap<Integer> h = new DataHeap<Integer>(5, 
				new MtHeap<Integer>(), new DataHeap<Integer>(2));
		return t.checkExpect(h.isHeap(), false);
	}
	
	boolean test3(Tester t) {
		DataHeap<Integer> h = new DataHeap<Integer>(3, new MtHeap<Integer>(), new MtHeap<Integer>());
		return t.checkExpect(h.isRemMinValid(), true);
	}
}
