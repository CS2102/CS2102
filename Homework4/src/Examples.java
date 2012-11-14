import tester.Tester;


public class Examples {
	Examples() {}
	DataHeap h = new DataHeap(5, new MtHeap(), new DataHeap(2));
	boolean test1(Tester t) {
		return t.checkExpect(true, true);
	}
}
