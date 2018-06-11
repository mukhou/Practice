/**
 * Given an unsorted array of non-negative integers,
 * find a continuous sub array which adds to a given number.
 */
package arraysandstrings;

public class ContinuousSubArraySum {
	
	public static int subArraySum(int[] arr, int sum){
		/* Initialize curr_sum as value of first element
	       and starting point as 0 */
		
	    int curr_sum = arr[0], start = 0;
	    
	    // go till one index more than the length of the array to check the value of curr_sum
	    for (int i = 1; i <= arr.length; i++){
	    	
	    	// If curr_sum becomes equal to sum, then return true
	        if (curr_sum == sum)
	        {
	            System.out.println("Sum found between indexes and "+
	            		String.valueOf(start) +" "+ String.valueOf(i - 1));
	            return 1;
	        }
	    	// else, add if i < arr.length
	    	if(i < arr.length){
		    	curr_sum = curr_sum + arr[i];
		    }
		 
	     // If curr_sum exceeds the sum, then remove the starting elements
	        while (curr_sum > sum && start < i-1)
	        {
	            curr_sum = curr_sum - arr[start];
	            start++;
	        }

	    }// for ends
	    return 0;
	    
	    	    
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
		int arr[] = {16, 5, 23, 1, 19};
	    //int n = 15;
	    int sum = 24;
	    subArraySum(arr, sum);
	    

	}

}
