
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
		return (this.runs1 != this.runs2) && (this.innings >= 9);
	}
}
