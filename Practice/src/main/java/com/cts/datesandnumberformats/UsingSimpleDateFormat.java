package com.cts.datesandnumberformats;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsingSimpleDateFormat {

	
	public static void main(String[] args) {
		
		String pattern = "MMM-dd-yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		// given a date in string
		Date today;
		try {
			today = df.parse("FEB-12-2012");
			System.out.println("date is "+df.format(today));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
