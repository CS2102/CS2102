package hwk6;


class Plus implements IFormula {
	IFormula left;
	IFormula right;

	Plus(IFormula left, IFormula right) {
		this.left = left;
		this.right = right;
	}

	public <R> R traverse(IProc<R> f) {
		if (this.left.equals(this.right))
		{
			R result = this.left.traverse(f);
			return f.processPlus(result, result);
		}
		else
			return f.processPlus(this.left.traverse(f), this.right.traverse(f));
	}
}