import tester.*;

public class Examples {
	
	String hi = "hi";
	
	Score score = new SoccerScore(1, 0, false);
	Score score2 = new SoccerScore(3, 3, true);
	Score score3 = new SoccerScore(3, 3, false);
	
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
							c4, c8, score))));
	
	Tournament t1b = new AdvanceMatch(new MatchData(
			c1, c2, score2),
			new AdvanceMatch(new MatchData(
					c1, c3, score2),
					new InitialMatch(new MatchData(
							c1, c5, score2)),
					new InitialMatch(new MatchData(
							c3, c7, score2))),
			new AdvanceMatch(new MatchData(
					c2, c4, score2),
					new InitialMatch(new MatchData(
							c2, c6, score2)),
					new InitialMatch(new MatchData(
							c4, c8, score2))));
	
	Tournament t1c = new AdvanceMatch(new MatchData(
			c1, c2, score3),
			new AdvanceMatch(new MatchData(
					c1, c3, score3),
					new InitialMatch(new MatchData(
							c1, c5, score3)),
					new InitialMatch(new MatchData(
							c3, c7, score3))),
			new AdvanceMatch(new MatchData(
					c2, c4, score3),
					new InitialMatch(new MatchData(
							c2, c6, score3)),
					new InitialMatch(new MatchData(
							c4, c8, score3))));
	
	boolean test1(Tester t){
		return t.checkExpect(hi, "hi");
	}
	
	boolean test2(Tester t){
		return t.checkExpect(t1.tourValid(), true);
	}
	
	boolean test2b(Tester t){
		return t.checkExpect(t1b.tourValid(), true);
	}
	
	boolean test2c(Tester t){
		return t.checkExpect(t1c.tourValid(), false);
	}
	
	boolean test3(Tester t){
		return t.checkExpect(t1.allScoresValid(), true);
	}
	
	BaseballContestant b1 = new BaseballContestant("Team1", 20, "Cap1");
	BaseballContestant b2 = new BaseballContestant("Team2", 20, "Cap2");
	BaseballContestant b3 = new BaseballContestant("Team3", 20, "Cap3");
	BaseballContestant b4 = new BaseballContestant("Team4", 20, "Cap4");
	BaseballContestant b5 = new BaseballContestant("Team5", 20, "Cap5");
	BaseballContestant b6 = new BaseballContestant("Team6", 20, "Cap6");
	BaseballContestant b7 = new BaseballContestant("Team7", 20, "Cap7");
	BaseballContestant b8 = new BaseballContestant("Team8", 20, "Cap8");
	
	BaseballScore bScore = new BaseballScore(1, 0, 8);
	BaseballScore bScore2 = new BaseballScore(1, 0, 9);
	
	Tournament t2 = new AdvanceMatch(
			new MatchData(b1, b2, bScore),
				new AdvanceMatch(
					new MatchData(b1, b3, bScore),
					new InitialMatch(
						new MatchData(b3, b4, bScore)),
					new InitialMatch(
						new MatchData(b1, b5, bScore))),
				new AdvanceMatch(
					new MatchData(b2, b6, bScore),
					new InitialMatch(
						new MatchData(b2, b7, bScore)),
					new InitialMatch(
						new MatchData(b6, b8, bScore))));
	
	Tournament t3 = new AdvanceMatch(
			new MatchData(b1, b2, bScore2),
				new AdvanceMatch(
					new MatchData(b1, b3, bScore2),
					new InitialMatch(
						new MatchData(b3, b4, bScore2)),
					new InitialMatch(
						new MatchData(b1, b5, bScore2))),
				new AdvanceMatch(
					new MatchData(b2, b6, bScore2),
					new InitialMatch(
						new MatchData(b2, b7, bScore2)),
					new InitialMatch(
						new MatchData(b6, b8, bScore2))));
	
	boolean test4(Tester t) {
		return t.checkExpect(t2.tourValid(), false);
	}
	boolean test5(Tester t) {
		return t.checkExpect(t3.tourValid(), true);
	}
	
	boolean test6(Tester t){
		TennisScore s = new TennisScore(MatchType.men,
				new TennisSet(5, 3),
				new TennisSet(4, 2),
				new TennisSet(3, 4),
				new TennisSet(5, 1),
				new TennisSet(3, 2),
				new TennisSet(2, 1));
		return t.checkExpect(s.isValid(), false);
	}
	
	boolean test7(Tester t){
		TennisScore s = new TennisScore(MatchType.women,
				new TennisSet(2, 3));
		return t.checkExpect(s.isValid(), true);
	}
	
	boolean test8(Tester t){
		TennisScore s = new TennisScore(MatchType.men,
				new TennisSet(4, 5));
		return t.checkExpect(s.isValid(), true);
	}
	
}
