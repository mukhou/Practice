/**
 * Given a random array, sort it in descending order.
 * ALGORITHM:
 * Just reverse logic of Bubble Sort
 */
package arraysandstrings;

import java.util.Arrays;

public class ReverseOrderOfArray {

	public static int[] reverse(int[] a) {

		int n = a.length;
		int temp = 0;
		// Just reverse logic of Bubble Sort
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		return a;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(reverse(new int[] { 5, 1, 3, 9 })));

	}

}
