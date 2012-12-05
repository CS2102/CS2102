package hwk5;

import java.util.Scanner;

class VotingMachine {
	Scanner keyboard = new Scanner(System.in);
	private IVoteData vd;


	VotingMachine(String... candidates){
		this.vd = new VoteData(candidates);
	}
	
	/**
	 * Prints the list of candidate names on the ballot.
	 */
	public void printBallot() {
		vd.printBallot();
	}
	
	/**
	 * Gets the results of the election using the given scoring system
	 * @param s
	 * @return the name of the winner of the election
	 */
	public String getResults(IScorer s){
		return vd.findWinner(s);
	}
	
	private void IO()
			throws DuplicateCandidateException, NonExistentCandidateException
	{
		this.printBallot();
		System.out.println("Who is your first choice?");
		String first = keyboard.next();
		if (!vd.candidateOnBallot(first)) {
			throw new NonExistentCandidateException(first);
		}

		System.out.println("Who is your second choice?");
		String second = keyboard.next();
		if (!vd.candidateOnBallot(second)) {
			throw new NonExistentCandidateException(second);
		}
		if (second.equalsIgnoreCase(first)) {
			throw new DuplicateCandidateException(first);
		}

		System.out.println("Who is your third choice?");
		String third = keyboard.next();
		if (!vd.candidateOnBallot(third)) {
			throw new NonExistentCandidateException(third);
		}
		if (third.equalsIgnoreCase(first) || third.equalsIgnoreCase(second)) {
			throw new DuplicateCandidateException(third);
		}

		vd.processVote(first, second, third);
	}
	
	/**
	 * Prompts the user for a vote, re-prompting if their vote is invalid
	 */
	public void screen(){
		try {
			IO();
		}

		catch (DuplicateCandidateException e) {
			System.err.println("Entered candidate " + e.name + " multiple times!\nPlease try again.");
			screen();
		}

		catch (NonExistentCandidateException e) {
			System.err.println("Candidate " + e.name + " does not exist!\nPlease try again.");
			screen();
		}
	}
	
	/**
	 * Forwards vote processing to the <code>VoteData</code> class
	 * @param f
	 * @param s
	 * @param t
	 */
	public void processVote(String f, String s, String t) { 
		// Forwarding for test purposes
		vd.processVote(f, s, t);
	}
}