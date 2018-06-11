/**
 * IMPORTANT: Use of LinkedHashMap is required here because we need to find
 * the "FIRST" non repeating character in the word provided.
 * So, we need to keep track of the order, that is we need to find the 
 * "FIRST"  non repeating in the word inserted into the collection,
 * hence the use of LinkedHashMap.
 * A Hashmap is unordered, so it won't serve the purpose.
 */

package arraysandstrings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInWord {

	// Use of LinkedHashMap
	public static void findNonRepeatingChar(String word){
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i = 0; i < word.length(); i ++){
			if(!map.containsKey(word.charAt(i))){
				map.put(word.charAt(i), 1);				
			}else{
				map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
			}
		}
		/*List<Integer> list = new ArrayList<Integer>(map.values());
		System.out.println(list.get(0));*/
		for(Map.Entry<Character, Integer> entrySet: map.entrySet()){
			if(entrySet.getValue() == 1){
				System.out.println(entrySet.getKey());
				break;
			}
		}
	}
	public static void main(String[] args) {
		String word = "aasbbcdecceefffg";
		findNonRepeatingChar(word);

	}

}
