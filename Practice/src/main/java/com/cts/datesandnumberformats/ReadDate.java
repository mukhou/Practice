package com.cts.datesandnumberformats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadDate {

	public static void main(String[] args) {

		String s;
		System.out.println("Please enter the date in dd/mm/yyyy format :");
		s = args[0];

		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		try {
			Date convertedDate = format.parse(s);
			System.out.println("The date entered is: " + convertedDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

}
