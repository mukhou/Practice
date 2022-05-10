package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class ReturnDuplicatesInArray {

	public static void findDuplicates(int[] arr){
		// using map, check if the number exists in the map
		// if not, add it, else print it
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer i : arr){			
			if(!map.containsKey(i)){
				map.put(i, 1);
			}else{
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 5, 7, 9, 9};
		findDuplicates(arr);

	}

}
