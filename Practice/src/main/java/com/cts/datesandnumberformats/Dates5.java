package com.cts.datesandnumberformats;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates5 {


	
	public static void main(String[] args) {
		
		//Date d = new Date();
		
		Calendar c = Calendar.getInstance();
		c.set(1984, 11, 21);
		
		System.out.println("the date is "+c.toString());
		
		Date d = c.getTime();
		
		System.out.println(d.toString());
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("formatted date is "+df.format(d));
		
		
		

	}

}
