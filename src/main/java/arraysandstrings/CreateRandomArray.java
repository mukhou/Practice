package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateRandomArray {

	// creates random array of elements of value 0 to n-1
	public static int[] randomIntArray(int length, int n) {
		int[] a = { 1, 2, 3, 4 };
		Random random = new Random();
		/*
		 * int max = a.length; int min = 0;
		 */
		// for each item in the list
		for (int i = 0; i < a.length; i++) {
			// create a new random number and populate the
			// current location in the list with it
			int tempIndex = random.nextInt(a.length);
			int temp = a[i];
			a[i] = a[tempIndex];
			a[tempIndex] = temp;

		}
		return a;
	}
	
	public static List get(int[] numbers, int noOfRandomNumbers) {
        List list = Arrays.asList(numbers);
        List randomList = new ArrayList();

        Random rd = new Random();
        for (int i = 0; i < noOfRandomNumbers; i++) {
                int index = (int) (rd.nextDouble() * list.size());
                randomList.add(list.get(index));
                list.remove(index);
        }
        return randomList;
}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 3 };
		
		int[] temp = randomIntArray(arr.length, 4);
		List<Integer> list = get(arr, 4);
		System.out.println(list);
		// int[] temp = randomIntArrayCreate(arr.length, 4);
		for (int i : temp) {
			//System.out.println(i);
		}

		/*
		 * String str = "abcde"; String str1 = "bd";
		 * System.out.println(str.contains(str1));
		 */

	}

}
