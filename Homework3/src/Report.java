public class Report {
	Reading[] readings;
	Date date;
	double high = Double.MIN_VALUE;
	double low = Double.MAX_VALUE;
	
	Report(Date d, Reading ... readings) {
		this.date = d;
		this.readings = readings;
		this.high = this.calcHigh();
		this.low = this.calcLow();
	}
	
	double calcHigh() {
		for (Reading reading : this.readings) {
			if (reading.getTemp() > high) {
				high = reading.getTemp();
			}
		}
		return high;
	}

	double calcLow() {
		for (Reading reading : this.readings) {
			if (reading.getTemp() < low) {
				low = reading.getTemp();
			}
		}
		return low;
	}
	
	int getYear() {
		return this.date.getYear();
	}
	
	int getMonth() {
		return this.date.getMonth();
	}

	int getDay() {
		return this.date.getDay();
	}
}
