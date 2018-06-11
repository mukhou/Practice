package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class FindIntersectionOfArrays {

	public static void findIntersection(int[] arr1, int[] arr2){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr1.length - 1; i++){
			map.put(arr1[i], 0);
		}
		for(int i = 0; i < arr2.length - 1; i++){
			if(map.containsKey(arr2[i])){
				System.out.println("The intersection is at index "+i +" number is " + arr2[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {6, 9, 3, 0, 12};
		findIntersection(arr1, arr2);

	}

}
