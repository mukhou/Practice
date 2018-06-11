package interview.qsns;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SearchObjArray {

	public static void main(String[] args) {
		
		String []myArray = {"Asia", "South America", "Europe", "Russia", "North America"};
		
		Arrays.sort(myArray);
		System.out.print("The sorted array is: ");
		for(String s: myArray){
			System.out.println(s+" ");
		}
		System.out.println("\nEurope =" + Arrays.binarySearch(myArray, "Europe"));
		
		System.out.println("Reverse Sort");
		
		ReverseSortComparator comparator = new ReverseSortComparator();
		
		//Sorting using the comparator
		Arrays.sort(myArray, comparator);
		for(String s: myArray){
			System.out.print(s+" ");
		}
		
		//Alternatively
		// gives same output without using the ReverseSortComparator class		
		Comparator<String> comp = null;
		comp = Collections.reverseOrder();
		Arrays.sort(myArray, comp);
		System.out.println("Without using the comarator class");
		for(String s: myArray){
			System.out.print(s+" ");
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
