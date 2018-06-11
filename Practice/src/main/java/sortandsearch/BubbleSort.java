package sortandsearch;

/**
 * Time complexity:
 *  Best: Ω(n)
 *  Worst: O(n^2)
 *  Average: θ(n^2)
 */

public class BubbleSort {

	public static int[] bubbleSort(int[] arr){
		int temp;
		for(int i = 0; i < arr.length; i ++){
			for(int j = i + 1; j < arr.length; j ++){
				if(arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			for(int x : arr){
				System.out.print(x + " ");
			}
			System.out.println();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {42, 5, 1, 25, 19};
		System.out.println("Unsorted");
		
		for(int x : arr){
			System.out.print(x + " ");
		}
		System.out.println("iteration");
		System.out.println();
		int[] temp = bubbleSort(arr);
		
		System.out.println("Sorted");
		for(int x : temp){
			System.out.print(x+ " ");
		}

	}

}
