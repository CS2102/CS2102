import java.util.HashMap;

class Spreadsheet implements ISpreadSheet {
	HashMap<String, IFormula> cells;

	public Spreadsheet() {
		this.cells = new HashMap<String, IFormula>();
	}

	@Override
	public void editContents(String cell, IFormula formula) {
		cells.put(cell, formula);
	}

	@Override
	public Integer lookupValue(String cell) {
		IFormula f = cells.get(cell);
		return f.traverse(new ValueOf());
	}
}