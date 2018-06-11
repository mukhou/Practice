/**
 * Determine if a string contains all unique characters
 */

package arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringWithUniqueChars {
	
	// Preferred approach
	public static boolean checkUniqueChars(String str){
		Set<Character> set = new HashSet<Character>();
		boolean b = false;
		for(int i = 0; i < str.length(); i ++){
			if(!set.contains(str.charAt(i))){
				set.add(str.charAt(i));
				b = true;
			}else{
				b = false;
				break;
			}
		}
		return b;
	}
	
	public static boolean checkForUniqueChars(String str){
		boolean b = false;
		//outer:
		/*for(int i = 0; i < str.length(); i++){
			for(int k = i+1; k < str.length(); k++){
				if(str.charAt(i) == str.charAt(k)){
					b = false;
					break outer;
				}else{
					b = true;
				}
			}
			
		}*/
		Map<Character, Integer> map = new HashMap<Character, Integer>();		
		for(int i = 0; i < str.length(); i ++){
			char c = str.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
				b = true;
			}else{
				b = false;
				break;
			}
		}
		return b;
	}

	
	public static void main(String[] args) {
		
		//System.out.println(StringWithUniqueChars.checkForUniqueChars("urmmila"));
		System.out.println(checkUniqueChars("urmila"));
		
		

	}

}
