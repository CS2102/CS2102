package hwk5;

public interface IScorer {
	/**
	 * Computes a score for the given candidate name, using the vote data to determine 
	 * the proper result
	 * @param name
	 * @param vd
	 * @return
	 */
	int computeScore(String name, IVoteData vd);
}
