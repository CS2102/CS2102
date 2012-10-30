
public class TennisScore implements Score {
	TennisSet[] sets;
	MatchType type;
	
	
	TennisScore(MatchType type, TennisSet... sets){
		this.sets = sets;
		this.type = type;
	}
	
	public boolean isValid(){
		return (type == MatchType.men && sets.length <= 5)  ||
			   (type == MatchType.women && sets.length <= 3);
	}
}

enum MatchType {men, women};
