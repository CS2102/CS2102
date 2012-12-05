package hwk5;

public class NonExistentCandidateException extends Exception {
	String name;
	
	static final long serialVersionUID = 0L;
	
	/**
	 * @param name
	 */
	public NonExistentCandidateException(String name) {
		this.name = name;
	}
	
}
