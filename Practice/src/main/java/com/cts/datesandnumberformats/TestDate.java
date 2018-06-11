package com.cts.datesandnumberformats;

import java.util.Date;

public class TestDate {

	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println("The date is "+date.toString());
		date.setTime(date.getTime()+360000);
		System.out.println("The date is "+date.toString());

	}

}
