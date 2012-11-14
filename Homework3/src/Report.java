public class Report {
	private IReadingSet readings;
	private Date date;
	// These are opposites to ensure they get overwritten
	private double high = Double.MIN_VALUE;
	private double low = Double.MAX_VALUE;
	
	Report(Date d, IReadingSet readings) {
		this.date = d;
		this.readings = readings;
		this.high = this.calcHigh();
		this.low = this.calcLow();
	}

	public double calcHigh() {
		return readings.getHigh();
	}

	public double calcLow() {
		return readings.getLow();
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
