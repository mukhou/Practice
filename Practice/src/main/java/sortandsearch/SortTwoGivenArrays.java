/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end
 *  to hold B. Write a method to merge B into A in sorted order.
 */

package sortandsearch;

// SEE CLASS MergeTwoSortedArays
public class SortTwoGivenArrays {

	public static void merge(int[] a, int [] b, int m, int n){
		int k = m + n -1;
		int i = n - 1;
		int j = m - 1;
		
		// start comparing from the last element and merge a and b
		
		while(i >= 0 && j >=0){
			a[k--] = a[i] > b[j] ? a[i--] : b[j--];
		}
		
		while(j >= 0){
			a[k--] = b[j--];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
