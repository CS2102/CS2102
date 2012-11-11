import tester.*;

public class Examples {
	Examples() {}
	
	WeatherMonitor w = new WeatherMonitor();
	
	boolean test1(Tester t) {
		w.addReport(1987, 5, 6, new Reading(62.0, 12, 4), new Reading(40.6, 20, 16));
		w.addReport(1987, 5, 7, new Reading(57.0, 12, 4), new Reading(34.3, 2, 32));
		w.addReport(1987, 5, 8, new Reading(67.0, 12, 4), new Reading(42.9, 22, 56));
		w.addReport(1987, 5, 9, new Reading(64.0, 12, 4), new Reading(32.3, 4, 24));
		w.addReport(1993, 6, 8, new Reading(73.0, 8, 16), new Reading(60.0, 4 ,5));
		return t.checkExpect(w.getReport(new Date(1987, 5, 6)),
				new Report(new Date(1987, 5, 6), new Reading(62.0, 12, 4), new Reading(40.6, 20, 16)));
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
		return t.checkExpect(w.averageHigh(1987, 5), 62.5F);
	}

	boolean test7(Tester t) {
		return t.checkExpect(w.averageLow(1987, 5), 37.525F);
	}
		
	boolean test8(Tester t) {
		return t.checkExpect(new Reading(62.0, 3, 4).getMinute(), 4);
	}

	boolean test9(Tester t) {
		return t.checkExpect(new Reading(62.0, 3, 4).getHour(), 3);
	}
}
