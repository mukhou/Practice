package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternMatcher {
	
	public static void main(String args[]) {
		
		Pattern p = Pattern.compile("mi");//the expression to match
		Matcher m = p.matcher("UUUUUrmi  JJJJUrmi");//the source
		boolean b = false;
		while(b = m.find()){
			System.out.println(m.start()+ " ");
		}
	}

}
