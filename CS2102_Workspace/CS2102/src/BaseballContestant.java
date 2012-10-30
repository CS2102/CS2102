
public class BaseballContestant implements Contestant, Team {
	String teamName;
	int teamSize;
	String captainName;
	
	public BaseballContestant(String teamName, int teamSize, String captainName){
		this.teamName = teamName;
		this.teamSize = teamSize;
		this.captainName = captainName;
	}
	
	public String getName(){
		return teamName;
	}
	
	public int numPlayers(){
		return teamSize;
	}
	
	public String teamCaptain(){
		return captainName;
	}
}
