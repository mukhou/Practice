package com.cts.test;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {

	public static void main(String[] args) {
		
		String []myArray = {"Asia", "South America", "Europe", "Russia", "North America"};
		
		Arrays.sort(myArray);
		System.out.println("The sorted ayyary is: ");
		for(String s: myArray){
			System.out.println(s+" ");
		}
		System.out.println("\nEurope =" + Arrays.binarySearch(myArray, "Europe"));
		
		System.out.println("Reverse Sort");
		
		ReverseSortComparator comparator = new ReverseSortComparator();
		
		//Sorting using the comparator
		Arrays.sort(myArray, comparator);
		for(String s: myArray){
			System.out.println(s+" ");
		}
		
		//Binary search without using the comparator(which fails)
		System.out.println("\nEurope ="+ Arrays.binarySearch(myArray, "Europe"));
		
		//Binary search using the comparator
		System.out.println("\nEurope ="+Arrays.binarySearch(myArray, "Europe", comparator));

	}
	
	static class ReverseSortComparator implements Comparator<String>{		
		public int compare(String a, String b){
			
			return b.compareTo(a);
		}
	}

}
