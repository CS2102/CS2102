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
	
	public float averageHigh(int year, int month) {
		float totalHigh = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.getDate().getMonth() == month && r.getDate().getYear() == year) {
				totalDays++;
				totalHigh += r.getHigh();
			}
		}
		if (totalDays != 0) {
			return totalHigh / totalDays;
		}
		else {
			throw new RuntimeException("No data for given month");
		}
	}
	
	public float averageLow(int year, int month) {
		float totalLow = 0;
		int totalDays = 0;
		for (Report r : reports) {
			if (r.getDate().getMonth() == month && r.getDate().getYear() == year) {
				totalDays++;
				totalLow += r.getLow();
			}
		}
		if (totalDays != 0) {
			return totalLow / totalDays;
		}
		else {
			throw new RuntimeException("No data for given month");
		}
	}
}
