package com.cts.test;

import java.util.Arrays;

public class Sorting {
	
	private static void sortIntArray(){
		
		int []arr = new int[]{5,7,2,78,13};
		Arrays.sort(arr);
		
		for(int x :arr){
			System.out.println(x);
		}
	}
	
	private static void sortStringArray(){
		
		String [] strArr = new String[]{"Urmi", "Jhini", "Rini", "Sharmi"};
		Arrays.sort(strArr);
		
		for(String s: strArr){
			System.out.println(s);
		}
		
	}

	
	public static void main(String[] args) {
		
		sortIntArray();
		sortStringArray();
		

	}

}
