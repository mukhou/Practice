package arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicatesInString {
	
	// Using Set: Preferred approach
	 public static void RemoveDups(String str){
		 StringBuilder sb = new StringBuilder();
		 Set<Character> set = new HashSet<Character>();
		 for(int i = 0; i < str.length(); i++){
			// String s = "" + str.charAt(i);
			 if(!set.contains(str.charAt(i))){
				 set.add(str.charAt(i));
				 sb.append(Character.toString(str.charAt(i)));				 
			 }
		 }
		 // iterate over a set
		 for(Character c : set){
			 System.out.println(c);
		 }
		 System.out.println(sb.toString());
	 }
	

	// Using Map
	 public static void RemoveDuplicates(String input) {
			//Loop through the elements in order
			StringBuilder sb = new StringBuilder();
			Map <String, Integer> uniqueSMap = new HashMap<String, Integer>();

			for(int i = 0; i < input.length(); i++) {
				// in java an empty string with any primitive turns it into a string
			    String s = "" + input.charAt(i);
			    // OR
			    // String s = Character.toString(input.charAt(i));
			    if(!uniqueSMap.containsKey(s)) {
				sb.append(s);
				uniqueSMap.put(s,i);
			    }
			}
			System.out.println(sb.toString());
		    }
	 
	 
	public static void main(String[] args) {
		RemoveDuplicatesInString.RemoveDups("urmuuuuuiiiuuu");
		
		

	}

}
