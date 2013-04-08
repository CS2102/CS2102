public class TennisScore implements Score {
	int team1Scores[];
	int team2Scores[];
	
	TennisScore () {
		this.team1Scores = new int[0];
		this.team2Scores = new int[0];
	}
	
	public boolean isValid() {
		return true; // more complex - do later
	}
}
