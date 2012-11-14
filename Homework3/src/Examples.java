package hw3;

import tester.*;

public class Examples {
	Examples() {}
	
	WeatherMonitor w = new WeatherMonitor(new ReportSet());
	
	boolean test1(Tester t) {
		ReadingSet r1 = new ReadingSet(new Reading(62.0, 12, 4), new Reading(40.6, 20, 16));
		ReadingSet r2 = new ReadingSet(new Reading(57.0, 12, 4), new Reading(34.3, 2, 32));
		ReadingSet r3 = new ReadingSet(new Reading(67.0, 12, 4), new Reading(42.9, 22, 56));
		ReadingSet r4 = new ReadingSet(new Reading(64.0, 12, 4), new Reading(32.3, 4, 24));
		ReadingSet r5 = new ReadingSet(new Reading(73.0, 8, 16), new Reading(60.0, 4 ,5));
		
		w.addDailyReport(1987, 5, 6, r1);
		w.addDailyReport(1987, 5, 7, r2);
		w.addDailyReport(1987, 5, 8, r3);
		w.addDailyReport(1987, 5, 9, r4);
		w.addDailyReport(1993, 6, 8, r5);

		ReadingSet testSet = new ReadingSet(new Reading(62.0, 12, 4), new Reading(40.6, 20, 16));
		return t.checkExpect(w.getReport(new Date(1987, 5, 6)),
				new Report(new Date(1987, 5, 6), testSet));
	}
	
	boolean test2(Tester t) {
	return t.checkExpect(w.getReport(new Date(1987, 5, 6)).calcLow(), 40.6);
	}

	boolean test3(Tester t) {
		return t.checkExpect(w.getReport(new Date(1987, 5, 6)).calcHigh(), 62.0);
	}

	boolean test4(Tester t) {
		return t.checkExpect(w.getReport(new Date(1993, 6, 8)).calcHigh(), 73.0);
	}

	boolean test5(Tester t) {
		return t.checkExpect(w.getReport(new Date(1993, 6, 8)).calcLow(), 60.0);
	}

	boolean test6(Tester t) {
		return t.checkInexact(w.averageHigh(1987, 5), 62.5, .0001);
	}

	boolean test7(Tester t) {
		return t.checkInexact(w.averageLow(1987, 5), 37.525, .0001);
	}
		
	boolean test8(Tester t) {
		return t.checkExpect(new Reading(62.0, 3, 4).getMinute(), 4);
	}

	boolean test9(Tester t) {
		return t.checkExpect(new Reading(62.0, 3, 4).getHour(), 3);
	}
}
