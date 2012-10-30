
public class InitialMatch implements Tournament {
	MatchData data;
	
	InitialMatch(MatchData data){
		this.data = data;
	}
	
	public MatchData getData(){
		return data;
	}
	
	public boolean allScoresValid(){
		return this.data.score.isValid();
	}
	
	// always true since there are no feeder matches to check against
	public boolean matchesValid(){
		return true;
	}
	
	// always true since one Contestant would be in the top half,
	// and the other Contestant would be in the bottom half
	public boolean tourValid(){
		return true;
	}
	
	// get all leaves
	public InitialMatch[] getLeaves(){
		return new InitialMatch[]{ this };
	}
	
	public int matchesPlayed(String name){
		if(this.data.contestant1.getName().equals(name) ||
			this.data.contestant2.getName().equals(name))
			return 1;
		else 
			return 0;
	}
}
