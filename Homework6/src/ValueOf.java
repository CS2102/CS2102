
class ValueOf implements IProc<Integer> {
	public Integer processNum(Num n) {
		return n.value;
	}

	public Integer processCellRef(CellRef c) {
		throw new RuntimeException("Cell Refs unsupported");
	}

	public Integer processPlus(Integer leftres, Integer rightres) {
		return leftres + rightres;
	}
}