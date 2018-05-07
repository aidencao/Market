package cn.market.tools;

public class MonthDays {
	public static int getDays(int year,int month, int day)
	{
		int yearRest = year - 2017;
		int count = 0;
		int Feb = 0;
		for(int i = 2017; i< year; i++)
		{
			if((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
				count ++;
		}
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
			Feb = 29;
		}else{
			Feb = 28;
		}
			
		int days = 0;
		switch(month)
		{
			case 12:
				days += 30;
			case 11:
				days += 31;
			case 10:
				days += 30;
			case 9:
				days += 31;
			case 8:
				days += 31;
			case 7:
				days += 30;
			case 6:
				days += 31;
			case 5:
				days += 30;
			case 4:
				days += 31;
			case 3:
				days += Feb;
			case 2:
				days += 31;
			case 1:
				days += day;
		}
		days += 365 * yearRest + count;
		return days;
	}
}
