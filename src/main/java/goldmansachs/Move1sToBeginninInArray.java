package goldmansachs;

import java.util.Arrays;

public class Move1sToBeginninInArray {

	// the algorithm keeps track of 2 pointers and
	// checks for the following combinations:
	//(1, 0), (0, 1), (0, 0), (1, 1)
	//takes O(n/2)
	public static void moveOnesToStart(int[] arr) {
		
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			if (arr[i] == 1 && arr[j] == 0) {
				i++;
				j--;
			} else if (arr[i] == 0 && arr[j] == 1) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			} else if (arr[i] == 0 && arr[j] == 0) {
				j--;
			} else if (arr[i] == 1 && arr[j] == 1) {
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1 };
		System.out.println(Arrays.toString(a));
		moveOnesToStart(a);
		System.out.println(Arrays.toString(a));
		

	}

}
