package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortAMap {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 5);
		map.put('b', 6);
		map.put('c', 9);
		map.put('d', 8);
		map.put('e', 9);
		List<Integer> list = new LinkedList<Integer>(map.values());
		//ONE WAY
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2){
				return i2.compareTo(i1);
			}
		});
		System.out.println(list);
		for(Map.Entry<Character, Integer> entrySet : map.entrySet()){
			int i = 0;
				System.out.println(entrySet.getKey() + " " + entrySet.getValue());
			
		}

		//OTHER WAY
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
		entries.sort(Map.Entry.comparingByValue());
		

	}

}
