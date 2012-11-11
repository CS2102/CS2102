public class Report {
	private Reading[] readings;
	private Date date;
	// These are opposites to ensure they get overwritten
	private double high = Double.MIN_VALUE;
	private double low = Double.MAX_VALUE;
	
	Report(Date d, Reading ... readings) {
		this.date = d;
		this.readings = readings;
		this.high = this.calcHigh();
		this.low = this.calcLow();
	}

	public double calcHigh() {
		for (Reading reading : this.readings) {
			if (reading.getTemp() > high) {
				high = reading.getTemp();
			}
		}
		return high;
	}

	public double calcLow() {
		for (Reading reading : this.readings) {
			if (reading.getTemp() < low) {
				low = reading.getTemp();
			}
		}
		return low;
	}
	
	/**
	 * @return the readings
	 */
	public Reading[] getReadings() {
		return readings;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}

	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}
}
