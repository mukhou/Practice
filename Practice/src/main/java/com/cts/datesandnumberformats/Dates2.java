package com.cts.datesandnumberformats;

import java.util.Calendar;
import java.util.Date;

public class Dates2 {
	
	public static void main(String[] args) {
		
		Date d1 = new Date();
		System.out.println("Today's date is "+d1.toString());
		// the method getInstance() is an overloaded static factory method
		Calendar c = Calendar.getInstance();
		c.setTime(d1);
		
		if(c.SUNDAY == c.getFirstDayOfWeek()){
			System.out.println("Sunday is the first day of the week");
			System.out.println("Today's day of week is "+c.get(c.DAY_OF_WEEK));
		}
		
		c.add(Calendar.MONTH, 1);
		
		Date d2 = c.getTime();
		System.out.println("The new date is "+d2.toString());
		
	}

}
