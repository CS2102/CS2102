
public class Reading {
	private double temp;
	private int hour;
	private int minute;
	
	/**
	 * @param temp
	 * @param hour
	 * @param minute
	 */
	public Reading(double temp, int hour, int minute) {
		this.temp = temp;
		this.hour = hour;
		this.minute = minute;
	}

	/**
	 * @return the temp
	 */
	public double getTemp() {
		return this.temp;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return this.minute;
	}
}
