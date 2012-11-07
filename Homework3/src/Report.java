import java.util.LinkedList;
public class Report {
	double[] readings;
	int year;
	int month;
	int day;
	double high = 0.0;
	double low = 9999.99;
	Report(int year, int month, int day, double[] readings) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.readings = readings;
		this.high = this.calcHigh();
		this.low = this.calcLow();
	}
	
	double calcHigh() {
		for (double reading : this.readings) {
			if (reading > high) {
				high = reading;
			}
		}
		return high;
	}

	double calcLow() {
		for (double reading : this.readings) {
			if (reading < low) {
				low = reading;
			}
		}
		return low;
	}
}
