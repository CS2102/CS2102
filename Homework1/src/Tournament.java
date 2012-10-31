
public interface Tournament { 
	boolean allScoresValid();
	// helper for allScoresValid()
	MatchData getData();
	
	boolean tourValid();
	// helpers for tourValid()
	boolean playersAlwaysAdvanced();
	InitialMatch[] getLeaves();
	
	int matchesPlayed(String name);
}
