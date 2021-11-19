package goldmansachs;

public class FindMissingNumberFromLargeArray {
	/*If i have the Previous array with me say A[MILLION] and the new array is A'[]
	then i can apply the following method: 
		For i = 1 to MILLION 
			{ set A[i] = A'[i] - A[i] 
			if (A[i] != 0) 
			break; 
			}
	now scan through the array A[] , the only non zero entry will indicate the position
	 of the changed element. 
	 Adding this to A'[i] will give you the original element as well. 

	complexity : N

	
	*/

}
