package hw3;

public interface IReportSet {
	IReportSet addReport(Report r);
	Report getReport(Date d);
	double averageHigh(int y, int m);
	double averageLow(int y, int m);
}
