package arraysandstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindHighestOccurrenceOfChar {

	public static void findHighestOccurrence(String str){
		char[] chArr = str.toCharArray();
		// use LinkedHashMap to preserve the order of insertion
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        int maxOccurring = 0;
		

		for(char c : chArr){
			if(!map.containsKey(c)){
				map.put(c, 1);
			}else{
				map.put(c, map.get(c) + 1);
			}
            if(map.get(c) > maxOccurring){
                maxOccurring = map.get(c);
            }
		}



		for(Map.Entry<Character, Integer> entrySet : map.entrySet()){
			if(entrySet.getValue() == maxOccurring){
				System.out.println(entrySet.getKey() + " " + entrySet.getValue());
			}
		}

	}
	public static void main(String[] args) {
		String str = "12131";

		findHighestOccurrence(str);

	}

}
