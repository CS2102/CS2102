import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class VoteData {
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
	
	public String getVotes() {
		return firstChoice.toString() + "\n" + secondChoice.toString() + "\n" + thirdChoice.toString() + "\n";
	}
}

class VotingMachine {
	Scanner keyboard = new Scanner(System.in);
	private VoteData vd;
	
	VotingMachine(String... candidates) {this.vd = new VoteData(candidates);}
	
	public void printBallot() {
		vd.printBallot();
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
}

class Examples {
	
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
	
	Examples() {
		VotingMachine v = new VotingMachine("Gompei", "Salisbury", "Husky");
		vote(v);
	}
}