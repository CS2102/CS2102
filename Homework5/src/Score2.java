
public class Score2 implements IScorer {
	@Override
	public int computeScore(String name, IVoteData vd) {
		return
				(vd.getFirstChoiceCount(name) * 3) +
				(vd.getSecondChoiceCount(name) * 2) +
				vd.getThirdChoiceCount(name);
	}
	
}