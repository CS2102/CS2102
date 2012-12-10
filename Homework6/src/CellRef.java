
class CellRef implements IFormula {
	private String cellname;

	CellRef(String cellname) {
		this.cellname = cellname;
	}

	public <R> R traverse(IProc<R> f) {
		return f.processCellRef(this);
	}

	public String getCellName() {
		return this.cellname;
	}
}