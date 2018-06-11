package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDatePattern {

	
	public static void main(String[] args) {
		
		String str = "Today's date is 12/19/2012";// mm/dd/yyyy
		String pattern = "(0[1-9]|1[0-2])[/](0[1-9]|[12][0-9]|3[01])[/]\\d+";		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		// find method returns true if, and only if, a subsequence of the input sequence
		// matches this matcher's pattern
		boolean b = m.find();
		System.out.println(b);

	}

}
