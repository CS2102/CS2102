import java.util.LinkedList;

public class WeatherMonitor {
	private LinkedList<Report> reports = new LinkedList<Report>();
	
	/**
	 * @param reports
	 */
	public WeatherMonitor() {}
	
	public WeatherMonitor(LinkedList<Report> reports) {
		this.reports = reports;
	}
	
	public WeatherMonitor addReport(int year, int month, int day, Reading ... readings) {
		this.reports.add(new Report(new Date(year, month, day), readings));
		return this;
	}
	
	public Report getReport(Date d) {
		for (Report r : this.reports) {
			if (r.getDate().equals(d)) {
				return r;
			}
		}
		throw new RuntimeException("Date not found");
	}
	
	public double averageHigh(int month, int year) {
		int totalHigh = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.getDate().getMonth() == month && r.getDate().getYear() == year) {
				totalDays++;
				totalHigh += r.getHigh();
			}
		}
		return (totalHigh / totalDays);
	}
	
	public double averageLow(int month, int year) {
		int totalLow = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.getDate().getMonth() == month && r.getDate().getYear() == year) {
				totalDays++;
				totalLow += r.getLow();
			}
		}
		return (totalLow / totalDays);
	}
}
