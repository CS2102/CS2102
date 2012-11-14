package hw3;

import java.util.ArrayList;
public class ReadingSet implements IReadingSet {
	private ArrayList<Reading> readings = new ArrayList<Reading>();
	
	//constructors
	public ReadingSet(Reading reading) {
		addReading(reading);
	}
	public ReadingSet(Reading... readings) {
		addReadings(readings);
	}
	
	private ReadingSet addReading(Reading r) {
		readings.add(r);
		return this;
	}
	
	private ReadingSet addReadings(Reading ... readings) {
		for (Reading r : readings) {
			this.readings.add(r);
		}
		return this;
	}
	
	public double getHigh() {
		// set high to minimum value to ensure it is overwritten
		double high = Double.MIN_VALUE;
		for (Reading reading : this.readings) {
			if (reading.getTemp() > high) {
				high = reading.getTemp();
			}
		}
		return high;
	}
	
	public double getLow() {
		// set low to maximum value to ensure it is overwritten
				double low = Double.MAX_VALUE;
				for (Reading reading : this.readings) {
					if (reading.getTemp() < low) {
						low = reading.getTemp();
					}
				}
				return low;
	}
}
