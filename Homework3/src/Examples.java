import tester.*;

public class Examples {
	Examples() {}
	
	WeatherMonitor w = new WeatherMonitor();
	boolean test1(Tester t) {
		w.addReport(5, 6, 1987, new Reading(12, 4, 62));
		return t.checkExpect(w.getReport(new Date(5, 6, 1987)),
				new Report(new Date(5, 6, 1987), new Reading(12, 4, 62)));
	}
			
}
