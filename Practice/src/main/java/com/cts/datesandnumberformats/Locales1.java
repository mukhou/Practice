package com.cts.datesandnumberformats;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Locales1 {

	
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		c.set(2010, 11, 04);
		
		Date d1 = c.getTime();
		
		Locale locIT = new Locale("it", "IT");
		//Locale locPR = new Locale("pt");
		Locale locBR = new Locale("pt", "BR");
		Locale locIN = new Locale("hi", "IN");
		//Locale locJA = new Locale("ja");
		
		DateFormat dfUS = DateFormat.getInstance();
		System.out.println("US   "+dfUS.format(d1));
		
		DateFormat dfUSFULL = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("US full "+dfUSFULL.format(d1));
		
		DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
		System.out.println("Italian "+dfIT.format(d1));
		
		DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
		System.out.println("Brazilian "+dfBR.format(d1));
		
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
		System.out.println("Indian "+dfIN.format(d1));
		
		//Using methods getDisplayCountry() and getDisplayLanguage()
		
		System.out.println("default "+locIN.getDisplayCountry());
		System.out.println("India "+locIN.getDisplayCountry(locIN));
		System.out.println("Ind def "+locIN.getDisplayLanguage());
		System.out.println("Ind lang "+locIN.getDisplayLanguage(locIN));

	}

}
