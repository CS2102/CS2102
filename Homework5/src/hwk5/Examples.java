package hwk5;

import tester.Tester;

public class Examples {
	Examples() {}
	
	VotingMachine initElection1(){
		VotingMachine v = new VotingMachine("A", "B", "C", "D");
		v.processVote("A", "B", "C");
		v.processVote("A", "B", "C");
		v.processVote("D", "B", "A");
		v.processVote("D", "B", "C");
		v.processVote("D", "B", "A");
		return v;
	}
	
	// Depending on how votes are weighted, results change
	boolean test1(Tester t) {
		VotingMachine v = initElection1();
		return t.checkExpect(v.getResults(new Score1()), "D");
	}

	boolean test2(Tester t) {
		VotingMachine v = initElection1();
		return t.checkExpect(v.getResults(new Score2()), "B");
	}
	
	// since the HashMaps are private, rather than testing their contents we test
	// simple results of the elections to make sure processVote is working properly
	boolean test3(Tester t){
		VotingMachine v = new VotingMachine("A", "B", "C", "D");
		v.processVote( "A", "B", "C");
		return t.checkExpect(v.getResults(new Score1()), "A");
	}
	
	boolean test4(Tester t){
		VotingMachine v = new VotingMachine("A", "B", "C", "D");
		v.processVote("A", "B", "D");
		v.processVote("C", "D", "B");
		v.processVote("A", "B", "B");
		return t.checkExpect(v.getResults(new Score1()), "A");
	}
	
}