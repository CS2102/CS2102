
public class Date {
	private int year;
	private int month;
	private int day;

	/**
	 * @param year
	 * @param month
	 * @param day
	 */
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * @return boolean
	 * if dates are same
	 */
	public boolean equals(Date d) {
		return this.year == d.year && this.month == d.month && this.day == d.day; 
	}
	 
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
}
