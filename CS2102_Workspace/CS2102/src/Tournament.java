
public interface Tournament { 
	boolean allScoresValid();
	// helper for allScoresValid()
	MatchData getData();
	
	boolean tourValid();
	// helpers for tourValid()
	boolean matchesValid();
	InitialMatch[] getLeaves();
	
	int matchesPlayed(String name);
}
