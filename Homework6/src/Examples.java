import tester.*;

class Examples {
	Examples() {}
	
	Spreadsheet initS() {
		Spreadsheet s = new Spreadsheet();
		s.editContents("a10", new Num(5));
		s.editContents("b10", new Num(3));
		s.editContents("c10", new Plus(new CellRef("a10"),
				new CellRef("b10")));
		return s;
	}
	boolean testLookup(Tester t) {
		Spreadsheet s = initS();
		return t.checkExpect(s.lookupValue("c10"), 8);
	}

	boolean testLookup2(Tester t) {
		Spreadsheet s = initS();
	    s.editContents("a10", new Num(9));
		return t.checkExpect(s.lookupValue("c10"), 12);
	}
}