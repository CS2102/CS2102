import java.util.LinkedList;

public class WeatherMonitor {
	LinkedList<Report> reports;
	WeatherMonitor () {}
	
	WeatherMonitor addReport(Report report) {
		this.reports.add(report);
		return this;
	}
	
	
	double averageHigh(int month, int year) {
		int totalHigh = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.month == month && r.year == year) {
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
			if (r.month == month && r.year == year) {
				totalDays++;
				totalLow += r.low;
			}
		}
		return (totalLow / totalDays);
	}
}
