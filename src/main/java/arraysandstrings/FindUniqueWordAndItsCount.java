package arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindUniqueWordAndItsCount {

	// preferred approach
	public static void findUniqueNumber(int[] arr){
		Set<Integer> set = new HashSet<Integer>();
		for(int x : arr){
			set.add(x);
		}
		System.out.println(set);
		System.out.println(set.size());
	}
	
	public static void main(String[] args) {
		// DO NOT USE MAP
		// USE A SET
		Map<String, Integer> map = new HashMap<String, Integer>();
		int[] arr = {1, 2, 2, 5, 3};
		findUniqueNumber(arr);
		
		String[] words = {"urmi", "rini", "rini", "jhini", "jhini", "jhini"};
		for(String s : words){
			if(!map.containsKey(s)){
				map.put(s, 1);
			}else{
				map.put(s, map.get(s)+1);
			}
		}
		
       //System.out.println(map.size() + " distinct words:");
       //System.out.println(map);
       //Iterator<String> it = map.keySet().iterator();
		Set<String> keys = map.keySet();
		keys.add("sjdhfjdksf");
		System.out.println(map);
       /*for(Map.Entry<String, Integer> entrySet : map.entrySet()){
    	   if(entrySet.getValue() > 1){
    		   //System.out.println(entrySet.getKey() + " = " + entrySet.getValue());
    	   }
       }*/
       

	}

}
