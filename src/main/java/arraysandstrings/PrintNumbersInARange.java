/**
 * Given a positive int "N" and an array of numbers ranging from 0-9 
 * (say array name is arr), print all numbers from 0 to N which include
 *  any number from "arr".
 *  Example:
 *  i/p: N=33, arr= {3,6,8}
 *  o/p should be: 3,6,8,13,16,18,23,26,28,30,31,32,33 
 */
package arraysandstrings;


public class PrintNumbersInARange {
	
	public static void printNumbers(int[] arr, int N){
		//Arrays.sort(arr);		
		int min_index = finMinFromArray(arr);
		// add numbers from 0 -> index
		// to 0 -> arr.length
		for (int i = 0; i <= min_index; i++) {
			if(i == min_index){
				printRemainingNumbers(min_index, N);
				break;
			}
			for (int j = 0; j < arr.length; j++) {
				// print number iarr[j], eg 03, 06, 08, 13, 16, 18 etc
				int number = Integer.parseInt(i + "" + arr[j]);
				if (number <= N) {
					System.out.println(number);
				}
			}
		}
		
	}
	
	private static void printRemainingNumbers(int index, int N) {		
		for(int i = 0; i <= index; i ++){
			System.out.println(index + "" + i);
			/*int num = Integer.parseInt(index + "" + i);
			while(num < N){
				num = num + 1;
				System.out.println(num);
			}*/
			
		}
		
	}

	// find the minimum number from the array
	private static int finMinFromArray(int[] arr) {
		int min = arr[0];
		for (int p : arr) {
			if (p < min) {
				p = min;
			}
		}
		return min;
		
	}

	public static void main(String[]args){
		printNumbers(new int[]{3,6,8}, 33);
	}

}
