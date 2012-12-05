package hwk5;

public interface IVoteData {
	/**
	 * Records the given vote in the VoteData structure
	 */
	void processVote(String a, String b, String c);
	/**
	 * Prints the list of candidate names on the ballot.
	 */
	void printBallot();
	/**
	 * Returns a boolean indicating whether the given candidate is on the ballot
	 * @param candidate
	 * @return
	 */
	boolean candidateOnBallot(String candidate);
	/**
	 * Gets the number of first-choice votes for the given candidate
	 */
	int getFirstChoiceCount(String candidate);
	/**
	 * Gets the number of second-choice votes for the given candidate
	 */
	int getSecondChoiceCount(String candidate);
	/**
	 * Gets the number of third-choice votes for the given candidate
	 */
	int getThirdChoiceCount(String candidate);
	/**
	 * Returns the winner of this election under the given scoring system
	 */
	String findWinner(IScorer s);
}
