package arraysandstrings;

public class MergeTwoSortedArays {

	public static int[] merge(int[] a, int[] b) {

		int[] c = new int[a.length + b.length];

		int i = 0, j = 0, index = 0;
		

		// Note: for index, i and j, post increment operator is
		// being used, that is the values are increased only
		// after they have been used in the current iteration,
		// else not incremented at all
		while (i < a.length && j < b.length) {			
			c[index++] = a[i] < b[j] ? a[i++] : b[j++];
		}
				
		if (i == a.length) {
			while (j < b.length) {
				c[index++] = b[j++];
			}
		} else {
			while (i < a.length) {
				c[index++] = a[i++];
			}
		}

		return c;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 41 };
		int[] arr2 = { 5, 6, 7, 8, 9, 10, 11 };
		int[] c = merge(arr1, arr2);
		for (int i : c) {
			System.out.println(i);
		}

	}

}
