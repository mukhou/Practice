package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternMatcher1 {

	
	public static void main(String[] args) {
		
		Pattern ptrnToMatch = Pattern.compile("s");
		Matcher toMatch = ptrnToMatch.matcher("This is a blue sky. Birds are flying");
		boolean b = false;
		while(b = toMatch.find()){
			System.out.println(toMatch.start()+" ");
		}

	}

}
