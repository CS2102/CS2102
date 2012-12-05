package hwk5;

import java.util.HashMap;
import java.util.LinkedList;

class VoteData implements IVoteData {
	private LinkedList<String> ballot = new LinkedList<String>();
	private HashMap<String, Integer> firstChoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> secondChoice = new HashMap<String, Integer>();
	private HashMap<String, Integer> thirdChoice = new HashMap<String, Integer>();

	VoteData(String... candidates) {
		for (String c : candidates) {
			addCandidate(c);
		}
	}

	private void addCandidate(String name) {
		this.ballot.add(name);
		firstChoice.put(name, 0);
		secondChoice.put(name, 0);
		thirdChoice.put(name, 0);
	}
	
	/**
	 * Records the given vote in the VoteData structure
	 */
	public void processVote(String first, String second, String third) {
		firstChoice.put(first, firstChoice.get(first) + 1);
		secondChoice.put(second, secondChoice.get(second) + 1);
		thirdChoice.put(third, thirdChoice.get(third) + 1);
	}
	
	/**
	 * Prints the list of candidate names on the ballot.
	 */
	public void printBallot() {
		System.out.println("The candidates are: ");
		for (String c : ballot) {
			System.out.println(c);
		}
	}
	
	/**
	 * Returns a boolean indicating whether the given candidate is on the ballot
	 */
	public boolean candidateOnBallot(String candidate) {
		return ballot.contains(candidate);
	}
	
	/**
	 * Returns the winner of this election under the given scoring system
	 */
	public String findWinner(IScorer s) {
		int maxScore = 0;
		String topScorer = "";
		for (String c : ballot) {
			int score = s.computeScore(c, this);
			if (score > maxScore) {
				topScorer = c;
				maxScore = score;
			}
		}
		return topScorer;
	}


	/**
	 * Gets the number of first-choice votes for the given candidate
	 */
	@Override
	public int getFirstChoiceCount(String candidate) {
		return firstChoice.get(candidate);
	}


	/**
	 * Gets the number of second-choice votes for the given candidate
	 */
	@Override
	public int getSecondChoiceCount(String candidate) {
		return secondChoice.get(candidate);
	}


	/**
	 * Gets the number of third-choice votes for the given candidate
	 */
	@Override
	public int getThirdChoiceCount(String candidate) {
		return thirdChoice.get(candidate);
	}
}