
public class NonExistentCandidateException extends Exception {
	String name;

	/**
	 * @param name
	 */
	public NonExistentCandidateException(String name) {
		this.name = name;
	}
	
}
