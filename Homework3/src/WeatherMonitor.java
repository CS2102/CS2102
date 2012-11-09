import java.util.LinkedList;

public class WeatherMonitor {
	LinkedList<Report> reports;
	WeatherMonitor () {}
	
	WeatherMonitor addReport(int year, int month, int day, Reading ... readings) {
		this.reports.add(new Report(new Date(year, month, day), readings));
		return this;
	}
	
	
	double averageHigh(int month, int year) {
		int totalHigh = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.getMonth() == month && r.getYear() == year) {
				totalDays++;
				totalHigh += r.high;
			}
		}
		return (totalHigh / totalDays);
	}
	
	double averageLow(int month, int year) {
		int totalLow = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.getMonth() == month && r.getYear() == year) {
				totalDays++;
				totalLow += r.low;
			}
		}
		return (totalLow / totalDays);
	}
}
