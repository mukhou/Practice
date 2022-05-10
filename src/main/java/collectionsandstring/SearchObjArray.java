package collectionsandstring;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {

	
	public static void main(String[] args) {
		
		String[] sa = {"one", "two", "three", "four"};
		System.out.println("Sorted array");
		Arrays.sort(sa);
		// now the array sa has the elements in this order: four, one, three, two
		for(String s : sa){
			System.out.print(s + " ");				
			
		}
		// the binary search returns the index of the string one which is 1
		System.out.println("\none = "+ Arrays.binarySearch(sa, "one"));
		
		
		System.out.println("now reverse sort");
		ReSortComparator reSortComparator = new ReSortComparator();
		// Resort the array using the Comparator
		Arrays.sort(sa, reSortComparator);
		// now the array sa has the elements in this order: two, three, one, four
		for(String s : sa){
			System.out.print(s + " ");			
		}
		// Gives the wrong values since the array is not being searched using the Comparator
		// with which it was sorted
		System.out.println("\none = " + Arrays.binarySearch(sa,"one"));			
		// Produces the correct values since the array is being searched using the
		// Comparator with which it was sorted
		System.out.println("one = " + Arrays.binarySearch(sa, "one", reSortComparator));

	}
	
	static class ReSortComparator implements Comparator<String>{
		
		public int compare(String a, String b){
			// reverse comparison, used for reverse sorting
			return b.compareTo(a);
		}
		
	}

}


