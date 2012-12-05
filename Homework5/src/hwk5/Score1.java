package hwk5;
//Scoring Implementations
public class Score1 implements IScorer {

	@Override
	public int computeScore(String name, IVoteData vd) {
		return vd.getFirstChoiceCount(name);
	}
	
}

