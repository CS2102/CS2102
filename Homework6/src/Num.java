
class Num implements IFormula {
	int value;
	Num(int value) {
		this.value = value;
	}

	public <R> R traverse(IProc<R> f) {
		return f.processNum(this);
	}
}