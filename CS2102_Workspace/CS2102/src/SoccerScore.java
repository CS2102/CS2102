
public class SoccerScore implements Score {
	int goals1;
	int goals2; 
	boolean wentOvertime;
	
	SoccerScore(int goals1, int goals2, boolean wentOvertime){
		this.goals1 = goals1;
		this.goals2 = goals2;
		this.wentOvertime = wentOvertime;
	}
	
	public boolean isValid(){
		return (goals1 == goals2 && wentOvertime)
				|| (goals1 != goals2);
	}
}
