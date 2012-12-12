package hwk6;

import java.util.HashMap;

class Spreadsheet implements ISpreadSheet {
	private HashMap<String, IFormula> cells;

	public Spreadsheet() {
		this.cells = new HashMap<String, IFormula>();
	}

	@Override
	public void editContents(String cell, IFormula formula) throws CircularRefsException {
		// saves the old value
		IFormula old = cells.put(cell, formula);
		if(formula.traverse(new ValidateRefs(this)))
		{
			return;
		}
		else 
		{
			cells.put(cell, old);
			throw new CircularRefsException();
		}
	}

	@Override
	public Integer lookupValue(String cell) {
		IFormula f = cells.get(cell);
		return f.traverse(new ValueOf(this));
	}

	/**
	 * Handles traversal on specified key with specified procedure
	 * @param key
	 * @param procedure
	 * @return
	 */
	public<R> R traverse(String key, IProc<R> procedure)
	{
		return cells.get(key).traverse(procedure);
	}
}