package com.cts.datesandnumberformats;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates4 {
	
	public static void main(String[] args) {
		
		Date d1 = new Date();
		System.out.println("d1 = "+d1.toString());
		
		/*String output;
		String pattern = "yyyy-mm-dd hh:mm";
		SimpleDateFormat format  = new SimpleDateFormat(pattern);
		output = format.format(d1);
		System.out.println(output);
		
		
	}*/
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		String s = df.format(d1);
		System.out.println(s);
		
		try{
			Date d2 = df.parse(s);
			System.out.println("The parsed date is "+d2.toString());
		}catch(ParseException ps){
			
		}
	}

}
