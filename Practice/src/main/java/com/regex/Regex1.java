package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

	
	public static void main(String[] args) {
		Pattern p = Pattern.compile("ab");
		Matcher m = p.matcher("abaaaba");
		boolean b = false;
		while(b = m.find()){
			System.out.println(m.start() + " ");
		}

	}

}
