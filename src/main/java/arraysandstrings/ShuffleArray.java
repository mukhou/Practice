package arraysandstrings;

import java.util.Random;

public class ShuffleArray {

	public static void shuffleArray(int[] arr) {
		int n = arr.length;
		Random random = new Random();
		// random.nextInt();
		for (int i = 0; i < n; i++) {
			int new_index = i + random.nextInt(n - i);
			swap(arr, i, new_index);
		}
	}

	private static void swap(int[] arr, int i, int change) {
		int temp = arr[i];
		arr[i] = arr[change];
		arr[change] = temp;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		shuffleArray(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
