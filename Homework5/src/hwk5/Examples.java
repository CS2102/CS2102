package hwk5;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import tester.Tester;

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

	public void processVote(String f, String s, String t) {
		firstChoice.put(f, firstChoice.get(f) + 1);
		secondChoice.put(s, secondChoice.get(s) + 1);
		thirdChoice.put(t, thirdChoice.get(t) + 1);
	}

	public void printBallot() {
		System.out.println("The candidates are: ");
		for (String c : ballot) {
			System.out.println(c);
		}
	}

	public boolean candidateOnBallot(String candidate) {
		return ballot.contains(candidate);
	}

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



	@Override
	public int getFirstChoiceCount(String candidate) {
		return firstChoice.get(candidate);
	}



	@Override
	public int getSecondChoiceCount(String candidate) {
		return secondChoice.get(candidate);
	}



	@Override
	public int getThirdChoiceCount(String candidate) {
		return thirdChoice.get(candidate);
	}
}

class VotingMachine {
	Scanner keyboard = new Scanner(System.in);
	private IVoteData vd;


	VotingMachine(String... candidates) {this.vd = new VoteData(candidates);}

	public void printBallot() {
		vd.printBallot();
	}

	String getResults(IScorer s){
		return vd.findWinner(s);
	}

	public void screen()
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
	
	public void processVote(String f, String s, String t) { // Forwarding for test purposes
		vd.processVote(f, s, t);
	}
}

public class Examples {

	void vote(VotingMachine v) {
		try {
			v.screen();
		}

		catch (DuplicateCandidateException e) {
			System.err.println("Entered candidate " + e.name + " multiple times!\nPlease try again.");
			vote(v);
		}

		catch (NonExistentCandidateException e) {
			System.err.println("Candidate " + e.name + " does not exist!\nPlease try again.");
			vote(v);
		}
	}

	Examples() {}
	
	// Depending on how votes are weighted, results change
	boolean test1(Tester t) {
		VotingMachine v = new VotingMachine("A", "B", "C", "D");
		v.processVote("A", "B", "C");
		v.processVote("A", "B", "C");
		v.processVote("D", "B", "A");
		v.processVote("D", "B", "C");
		v.processVote("D", "B", "A");
		return t.checkExpect(v.getResults(new Score1()), "D");
	}

	boolean test2(Tester t) {
		VotingMachine v = new VotingMachine("A", "B", "C", "D");
		v.processVote("A", "B", "C");
		v.processVote("A", "B", "C");
		v.processVote("D", "B", "A");
		v.processVote("D", "B", "C");
		v.processVote("D", "B", "A");
		return t.checkExpect(v.getResults(new Score2()), "B");
	}
	
}