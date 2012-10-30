
public class BaseballScore implements Score {
	int runs1;
	int runs2;
	int innings;
	
	BaseballScore(int runs1, int runs2, int innings){
		this.runs1 = runs1;
		this.runs2 = runs2;
		this.innings = innings;
	}
	
	public boolean isValid(){
		return (runs1 != runs2) && (innings >= 9);
	}
}
