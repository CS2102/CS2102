package hwk6;

import java.util.LinkedList;

class ValidateRefs implements IProc<Boolean> {
	private Spreadsheet spread;
	private LinkedList<CellRef> visited = new LinkedList<CellRef>();

	public ValidateRefs(Spreadsheet spread)
	{
		this.spread = spread;
	}

	public Boolean processNum(Num n) {
		return true;
	}

	public Boolean processCellRef(CellRef c) {
		if (visited.contains(c))
			return false;
		//else
		visited.add(c);
		return spread.traverse(c.getCellName(), this);
	}

	public Boolean processPlus(Boolean leftres, Boolean rightres) {
		return leftres && rightres;
	}
}