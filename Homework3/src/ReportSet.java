package hw3;

import java.util.ArrayList;

public class ReportSet implements IReportSet {
	ArrayList<Report> reports = new ArrayList<Report>();
	
	//constructors
	ReportSet(){}
	ReportSet(Report report){
		reports.add(report);
	}
	ReportSet(Report... reports){
		for(Report r : reports){
			this.reports.add(r);
		}
	}
	
	public ReportSet addReport(Report r) {
		reports.add(r);
		return this;
	}
	
	public Report getReport(Date d) {
		for(Report r : reports){
			if(r.getDate().equals(d))
				return r;
		}
		// Report not found!
		throw new RuntimeException("Date not found!");
	}
	
	public double averageHigh(int year, int month) {
		double totalHigh = 0;
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
	
	public double averageLow(int year, int month) {
		double totalLow = 0;
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
