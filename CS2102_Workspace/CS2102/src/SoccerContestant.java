
public class SoccerContestant implements Contestant, Team, Ranked {
	String name;
	int ranking;
	int teamSize;
	String captainName;
	
	public SoccerContestant(String name, int ranking, int teamSize, String captainName){
		this.name = name;
		this.ranking = ranking;
		this.teamSize = teamSize;
		this.captainName = captainName;
	}
	
	public String getName(){
		return name;
	}
	
	public int numPlayers(){
		return teamSize;
	}
	
	public String teamCaptain(){
		return captainName;
	}
	
	public int getRanking(){
		if(ranking >= 1)
			return 2;
		else 
			return ranking;
	}
	
	public boolean hasBetterRanking(Ranked second){
		return this.getRanking() < second.getRanking();
	}
	
}
