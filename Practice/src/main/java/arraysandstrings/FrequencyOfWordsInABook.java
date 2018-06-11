/**
 * Design a method to find the frequency of occurrences of any given word in a book.
 */

package arraysandstrings;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class FrequencyOfWordsInABook {

	public static int findSingleWordCount(String[] wordList, String word){
		
		// for one word
		int count = 0;		
		for(String aWord : wordList){
			if(aWord.equals(word)){
				count ++;
			}
		}
		return count;
	}
	
	// for multiple words
	public static HashMap<String, Integer> findMultipleWordount(String[] wordList){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word : wordList){
			word = word.toLowerCase();
			if(word.trim() != ""){
				if(!map.containsKey(word)){
					map.put(word, 1);
				}else{
					map.put(word, map.get(word)+1);
				}
			}
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		String[] wordList = new String[]{"the", "world", "the", "best"}; 
		//System.out.println(findSingleWordCount(wordList, "the"));
		//System.out.println(findMultipleWordount(wordList));
		HashMap<String, Integer> result = findMultipleWordount(wordList);
		/*Enumeration<String> keys = result.keys();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			System.out.println("Key: " + key + " Value: " + result.get(key));
		}*/
		for(Map.Entry<String, Integer> entrySet : result.entrySet()){
			 System.out.println(entrySet.getKey() + " = " + entrySet.getValue());
		}
			
		}
		

	}


