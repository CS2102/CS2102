package hwk6;
import tester.*;

class Examples {
	Examples() {}

	Spreadsheet initS() throws CircularRefsException {
		Spreadsheet s = new Spreadsheet();
		s.editContents("a10", new Num(5));
		s.editContents("b10", new Num(3));
		s.editContents("c10", new Plus(new CellRef("a10"),
				new CellRef("b10")));
		return s;
	}

	boolean testLookup(Tester t) throws CircularRefsException {
		Spreadsheet s = initS();
		return t.checkExpect(s.lookupValue("c10"), 8);
	}

	boolean testLookup2(Tester t) throws CircularRefsException {
		Spreadsheet s = initS();
		s.editContents("a10", new Num(9));
		return t.checkExpect(s.lookupValue("c10"), 12);
	}

	boolean testCircularFailure(Tester t)
	{
		boolean hasCyclicRef = false;
		try {
			Spreadsheet s = initS();
			s.editContents("a10", new CellRef("b10"));
			s.editContents("b10", new CellRef("a10"));
			hasCyclicRef = false;
		}
		catch (CircularRefsException e)
		{
			hasCyclicRef = true;
		}
		return t.checkExpect(hasCyclicRef, true);
	}

	boolean testComplexCircularFailure(Tester t)
	{
		boolean hasCyclicRef = false;
		try {
			Spreadsheet s = initS();
			s.editContents("a10", new CellRef("b10"));
			s.editContents("b10", new CellRef("c10"));
			s.editContents("c10", new CellRef("d10"));
			s.editContents("d10", new CellRef("b10"));
			hasCyclicRef = false;
		}
		catch (CircularRefsException e)
		{
			hasCyclicRef = true;
		}
		return t.checkExpect(hasCyclicRef, true);
	}
}