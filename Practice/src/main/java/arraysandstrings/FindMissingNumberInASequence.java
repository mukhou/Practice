package arraysandstrings;

/**
 * ALGORITHM:
 * say the nos are x to y with 1 missing no 
 * temp1 = sum from 1 to y using the formula n(n+1)/2
 * temp2 = sum of 1 to x-1 using the formula n(n+1)/2
 * temp3 = sum of the given numbers
 * Missing no = temp1 - (temp3 + temp2)
 */

public class FindMissingNumberInASequence {

	// preferred approach:
	// http://www.careercup.com/question?id=57074
	public static int findMissingNum(int[] arr) {
		int first = arr[0];
		int last = arr[arr.length - 1];
		int temp3 = 0;
		int temp1 = (last * (last + 1)) / 2;
		int temp2 = ((first - 1) * ((first - 1) + 1)) / 2;
		for (Integer i : arr) {
			temp3 += i;
		}
		return temp1 - (temp2 + temp3);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5 };
		System.out.println("missing number is: " +findMissingNum(arr));
	}

}
