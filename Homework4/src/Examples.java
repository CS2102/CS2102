import tester.Tester;


public class Examples {
	Examples() {}
	DataHeap<Integer> h = new DataHeap<Integer>(5, new MtHeap<Integer>(), new DataHeap<Integer>(2));
	boolean test1(Tester t) {
		return t.checkExpect(true, true);
	}
}
