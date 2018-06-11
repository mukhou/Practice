package com.regex;

public class SplitTestDot {
	
	public static void main(String args[]) {
		
		String src = "abc.def.ghi";
		String [] tokens = src.split("\\.");
		
		
		for(String s : tokens){
			System.out.println(">" + s + "<");
		}
	}

}
