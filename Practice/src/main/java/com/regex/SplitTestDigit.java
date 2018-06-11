package com.regex;

public class SplitTestDigit {
	
	public static void main(String args[]) {
		
		/**
		 * the runtime input(command line input) is "ab5 ccc 45 @" "\d"
		 * where the source is ab5 ccc 45 @" "
		 * and the delimiter is \d (a digit)
		 */
		String str = "ab5 ccc 45 @" ;
		String str1 = "\\d";
		String [] tokens = str.split(str1);
		for(String s : tokens){
			System.out.println(">" + s + "<");
		}

	}

}
