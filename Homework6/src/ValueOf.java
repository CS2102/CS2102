
class ValueOf implements IProc<Integer> {
	private Spreadsheet spread;

	/**
	 * @param spread The spreadsheet from which all cell references will be evaluated
	 */
	public ValueOf(Spreadsheet spread) {
		this.spread = spread;
	}

	public Integer processNum(Num n) {
		return n.value;
	}

	public Integer processCellRef(CellRef c) {
		return spread.traverse(c.getCellName(), this);
	}

	public Integer processPlus(Integer leftres, Integer rightres) {
		return leftres + rightres;
	}
}