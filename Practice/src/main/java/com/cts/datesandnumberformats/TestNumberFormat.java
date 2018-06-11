package com.cts.datesandnumberformats;

import java.text.NumberFormat;
import java.text.ParseException;

public class TestNumberFormat {

	
	public static void main(String[] args) {
		float f1 = 123.45678f;
		NumberFormat nf = NumberFormat.getInstance();
		System.out.print(nf.getMaximumFractionDigits() + " ");
		System.out.print(nf.format(f1) + " ");
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(f1) + " ");
		try {
		System.out.println(nf.parse("1234.567"));
		nf.setParseIntegerOnly(true);
		System.out.println(nf.parse("1234.567"));
		} catch (ParseException pe) {
		System.out.println("parse exc");
		}

	}

}
