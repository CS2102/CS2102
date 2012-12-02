
public interface IVoteData {
	void processVote(String a, String b, String c);
	
	void printBallot();
	boolean candidateOnBallot(String candidate);
	
	int getFirstChoiceCount(String candidate);
	int getSecondChoiceCount(String candidate);
	int getThirdChoiceCount(String candidate);
	
	String findWinner(IScorer s);
}
