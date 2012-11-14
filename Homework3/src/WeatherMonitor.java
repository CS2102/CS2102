package hw3;

public class WeatherMonitor {
	
	private IReportSet reports;
	
	/**
	 * @param reports
	 */
	public WeatherMonitor(IReportSet reports) {
		this.reports = reports;
	}
	
	// methods
	public Report getReport(Date d){
		return reports.getReport(d);
	}
	
	public WeatherMonitor addDailyReport(int year, int month, int day, IReadingSet readingSet) {
		this.reports.addReport(new Report(new Date(year, month, day), readingSet));
		return this;
	}
	
	public double averageHigh(int year, int month) {
		return reports.averageHigh(year, month);
	}
	
	public double averageLow(int year, int month) {
		return reports.averageLow(year, month);
	}
}
