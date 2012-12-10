
interface ISpreadSheet {
	void editContents(String cellname, IFormula expr) throws CircularRefsException;
	Integer lookupValue(String forcell);
}