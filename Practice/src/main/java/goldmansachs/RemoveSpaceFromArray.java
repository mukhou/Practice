package goldmansachs;

import java.util.Arrays;

public class RemoveSpaceFromArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] arr = { 'a', 'a', 'b', ' ', ' ', 'c', ' ', ' ', 'd', 'e' };
		for (int i = 0, j = 0; j <= arr.length - 1; ++j) {
			if (arr[j] != ' ')
				arr[i++] = arr[j];
				

			
		}
		System.out.println(Arrays.toString(arr));

	}
}
