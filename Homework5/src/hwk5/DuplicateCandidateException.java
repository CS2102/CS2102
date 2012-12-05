package hwk5;

public class DuplicateCandidateException extends Exception {
	String name;
	/**
	 * @param name
	 */
	public DuplicateCandidateException(String name) {
		this.name = name;
	}
}
