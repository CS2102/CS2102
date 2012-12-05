package hwk5;

public class DuplicateCandidateException extends Exception {
	String name;
	static final long serialVersionUID = 0L;
	/**
	 * @param name
	 */
	public DuplicateCandidateException(String name) {
		this.name = name;
	}
}
