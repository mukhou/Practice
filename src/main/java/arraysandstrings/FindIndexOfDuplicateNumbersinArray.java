package arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class FindIndexOfDuplicateNumbersinArray {
	
	private static void findDupPos(int[] arr){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i ++){
			if(!set.contains(arr[i])){
				set.add(arr[i]);
			}else{
				System.out.println("duplicate number " + arr[i] + " " + "in " + i );
			}
		}
	}
	

	/*public static void findDuplicatePosition(int[] arr) {
		int index = 0;
		int current_element;
		while (index < arr.length) {
			current_element = arr[index];
			for (int i = 0; i < arr.length; i++) {
				if (current_element == arr[i] && i > index) {
					System.out.println("Duplicate for " + current_element
							+ " in " + i);
					break;
				}
			}
			index++;
		}
	}
	*/
	

	public static void main(String[] args) {
		int[] arr = { 0, 7, 9, 1, 5, 8, 1, 7, 4, 7, 3, 1 };
		//findDuplicatePosition(arr);
		findDupPos(arr);

	}

}
