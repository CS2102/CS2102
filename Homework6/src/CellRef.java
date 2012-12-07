
class CellRef implements IFormula {
	String cellname;

	CellRef(String cellname) {
		this.cellname = cellname;
	}

	public <R> R traverse(IProc<R> f) {
		return f.processCellRef(this);
	}
}