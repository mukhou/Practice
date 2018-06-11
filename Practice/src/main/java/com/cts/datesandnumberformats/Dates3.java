package com.cts.datesandnumberformats;

import java.text.DateFormat;
import java.util.Date;

public class Dates3 {

	
	public static void main(String[] args) {		
		Date d1 = new Date();
		
		DateFormat[] df = new DateFormat[6];
		df[0] = DateFormat.getInstance();
		df[1] = DateFormat.getDateInstance();
		df[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		df[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		df[4] = DateFormat.getDateInstance(DateFormat.LONG);
		df[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		for(DateFormat df1 :df){
			System.out.println(df1.format(d1));
		}

	}

}
