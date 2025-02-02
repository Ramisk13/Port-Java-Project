package Final;

public class Date {
	private int day;
	private int years;
	private int month;
	
	public Date(int day, int month, int years) {
		if(day<1 || day>31)
			this.day = 1;
		else
			this.day = day;
		
		if(month<1 || month > 12)
			this.month = 1;
		else
			this.month = month;
		
		if(years < 1970 || years > 2030)
			this.years = 2023;
		else 
			this.years = years;
		
		if(month == 2 && day>28)
			this.day = 1;
	}
	
	public int getYears() {
		return this.years;
	}
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	
	
	public String toString() {
		return this.day + "/" + this.month + "/" +this.years;
	}
}
