//Code Created by Mary Danielle C. Amora

public class Date{

	private int year;
	private int month;
	private int day;

	
	public void Checking(){
		if (year <= 0){
			throw new IllegalArgumentException("Invalid year!");
		}
		if (month > 12 || month <= 0){
			throw new IllegalArgumentException("Invalid month!");
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			if (day <= 0 || day > 31){
				throw new IllegalArgumentException("Invalid day!");
			}
		}
		else if (month == 2){
			if ((day <= 0 || day > 28) && year % 4 != 0){
				throw new IllegalArgumentException("Invalid day!");
			}
			if (year % 4 == 0 && (day <= 0 || day > 29)){
				throw new IllegalArgumentException("Invalid day!");

			}
		}
		else{
			if (day <= 0 || day > 30){
				throw new IllegalArgumentException("Invalid day!");
			}
		}
		
	}

	public Date(int year, int month, int day){
		
		this.year = year;
		this.month = month;
		this.day = day;
		Checking();
		
	}

	public int getYear(){
		return year;
		
	}

	public int getMonth(){
		return month;

	}

	public int getDay(){
		return day;
	
	}

	public void setYear(int year){
		this.year = year;
		Checking();

	}

	public void setMonth(int month){
		this.month = month;
		Checking();
		
	}

	public void setDay(int day){
		this.day = day;
		Checking();
		
	}

	public String toString(){
		return String.format("%02d / %02d / %02d" ,day,month,year);
		
	}

	public void setDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
		Checking();

	}


}
