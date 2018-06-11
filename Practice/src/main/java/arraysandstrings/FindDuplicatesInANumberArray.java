package arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicatesInANumberArray {
	
	public static void findDuplicates(int[] arr){
		Set<Integer> set = new HashSet<Integer>();
		for(int n : arr){
			if(!set.contains(n)){
				set.add(n);
			}else{
				System.out.println(n);
			}
		}
	}

	// anubrata's method
	private static void check(int[] arr) {
		int[] temp = new int[30];

		for (int i = 0; i < arr.length; i++) {
			if (temp[arr[i]] > 1) {
				System.out.println(arr[i]);
				return;
			}
			temp[arr[i]]++;
		}

	}

	public static void findDups(int[] arr){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n : arr){
			if(!map.containsKey(n)){
				map.put(n, 1);
			}else{
				map.put(n, map.get(n) + 1);
			}
		}
		// IMPORTANT: How to iterate thorugh a Map
		/*Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			// Cast it to Map.Entry
			Map.Entry me = (Map.Entry)it.next();
			// use methods of Map.Entry
			if((Integer)me.getValue() > 1){
				System.out.println("the number " + me.getKey() +" occurs" + " "+ me.getValue() + " times");
			}
			
		}*/
		for(Map.Entry<Integer, Integer> entrySet : map.entrySet()){
			if(entrySet.getValue() > 1){
				System.out.println("the number " + entrySet.getKey() +" occurs" + " "+ entrySet.getValue() + " times");
			}
		}
	}
	public static void main(String[] args) {
		int[] test = new int[] { 1, 1, 1, 2, 2, 3, 4, 5, 6 };
		findDups(test);
		//check(test);
		//findDuplicates(test);
		

	}

}
