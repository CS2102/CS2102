package hw3;

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
	
	@Override public boolean equals(Object o){
		if(o == this)
			return true;
		if(!(o instanceof Date))
			return false;
		Date d = (Date) o;
		return
				d.year == year &&
				d.month == month &&
				d.day == day;
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
