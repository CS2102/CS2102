import tester.*;

public class Examples {
	
	String hi = "hi";
	
	Score score = new SoccerScore(1, 0, false);
	
	SoccerContestant c1 = new SoccerContestant("name1", 2, 10, "cap1");
	SoccerContestant c2 = new SoccerContestant("name2", 3, 10, "cap2");
	SoccerContestant c3 = new SoccerContestant("name3", 4, 10, "cap3");
	SoccerContestant c4 = new SoccerContestant("name4", 5, 10, "cap4");
	SoccerContestant c5 = new SoccerContestant("name5", 6, 10, "cap5");
	SoccerContestant c6 = new SoccerContestant("name6", 7, 10, "cap6");
	SoccerContestant c7 = new SoccerContestant("name7", 8, 10, "cap7");
	SoccerContestant c8 = new SoccerContestant("name8", 9, 10, "cap8");
	
	Tournament t1 = new AdvanceMatch(new MatchData(
			c1, c2, score),
			new AdvanceMatch(new MatchData(
					c1, c3, score),
					new InitialMatch(new MatchData(
							c1, c5, score)),
					new InitialMatch(new MatchData(
							c3, c7, score))),
			new AdvanceMatch(new MatchData(
					c2, c4, score),
					new InitialMatch(new MatchData(
							c2, c6, score)),
					new InitialMatch(new MatchData(
							c4, c8, new SoccerScore(1, 1, false)))));
	
	
	boolean test1(Tester t){
		return t.checkExpect(hi, "hi");
	}
	
	boolean test2(Tester t){
		return t.checkExpect(t1.tourValid(), true);
	}
	
	boolean test3(Tester t){
		return t.checkExpect(t1.allScoresValid(), true);
	}
	
	
	// ... more tests ...
	boolean test4(Tester t){
		return t.checkExpect(true, true);
	}
	
	
	boolean test16(Tester t){
		TennisScore s = new TennisScore(MatchType.men,
				new TennisSet(5, 3),
				new TennisSet(4, 2),
				new TennisSet(3, 4),
				new TennisSet(5, 1),
				new TennisSet(3, 2),
				new TennisSet(2, 1));
		return t.checkExpect(s.isValid(), false);
	}
	
	boolean test17(Tester t){
		TennisScore s = new TennisScore(MatchType.women,
				new TennisSet(2, 3));
		return t.checkExpect(s.isValid(), true);
	}
	
	boolean test18(Tester t){
		TennisScore s = new TennisScore(MatchType.men,
				new TennisSet(4, 5));
		return t.checkExpect(s.isValid(), true);
	}
	
}
