/**
 * You are given an array of numbers. Find out the array index or position
 * where sum of numbers preceding the index is equals to
 * sum of numbers succeeding the index.
 * Algotirhm:
 * We calculate the sum of the whole array except the first element in right_sum, considering it to be the partitioning element.
 * Now, we traverse the array from left to right, subtracting an element from right_sum and adding an element to left_sum.
 * The point where right_sum equals left_sum, we get the partition.
 */
package byteBybyte;

//https://www.geeksforgeeks.org/find-element-array-sum-left-array-equal-sum-right-array/
public class FindEqualLeftRightSumForArray {
	
	public static int findMiddleIndex(int[] arr) {
		int leftSum = 0, rightSum = 0;

		//Computing right_sum
		for(int i = 1; i < arr.length; i ++){
			rightSum += arr[i];
		}

		// Checking the point of partition
		// i.e. left_Sum == right_sum
		for(int i = 0, j = 1; i < arr.length; i ++, j++){
			leftSum += arr[i];
			rightSum -= arr[j];
			if(leftSum == rightSum){
				return arr[i + 1];
			}
		}
		return  -1;
	}
	
	public static void main(String[] args) {
		int[] num = { 1, 4, 2, 5 };
        System.out.println(findMiddleIndex(num));

	}

}
