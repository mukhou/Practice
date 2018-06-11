package arraysandstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Find3MostRepeatedNumbersInArray {

	public static Map<Integer, Integer> findMostRepeatedNums(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = findMostRepeatedNums(new int[] { 1, 2, 1,
				3, 2, 4, 5, 5, 6, 6, 6, 6, 2, 2, 2 });
		
		System.out.println(map);

		List<Integer> list = new ArrayList<Integer>(map.values());
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2){
				return i2.compareTo(i1);
			}
		});
		System.out.println(list);
		int i = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue().equals(list.get(i))){
				System.out.println("key: " + entry.getKey() + " " +"value: " + entry.getValue());
				i++;
				if(i == 4) break;
			}
		}
		
		
		
		//System.out.println("unsorted map: " + map);

		
		/*Map<Integer, Integer> sortedMap = sortByComparator(map);
		printMap(sortedMap);*/

	}

	

	/*private static Map sortByComparator(Map<Integer, Integer> unsortMap) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());
		 
		// sort list based on comparator
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				
				return o2.getValue().compareTo(o1.getValue());
			}
			 
			
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
		
	}*/
	


}
