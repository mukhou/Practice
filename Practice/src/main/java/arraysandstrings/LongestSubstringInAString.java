package arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;

// IMPORTANT
//check;
// http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
//OR
//http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
public class LongestSubstringInAString {

	public static void main(String[] args) {
		// System.out.println(findLongestSubstring("abcdefcd"));
		//String str = "urmiila";
		String s = "geeksfoergeeks";
		//System.out.println(lengthOfLongestSubstring(s));
		 //longestSubstring(s);
		 System.out.println(lengthOfLongestSubstringInStrig(s));
       // System.out.println(lengthOfLongestSubstringLeetcode(s));
		//System.out.println(lengthOfLongestSubstringInStrin(s));

	}

	// FOLLOW THIS: preferred approach (from geeksforgeeks)
    public static int lengthOfLongestSubstringInStrig(String s) {

	    //ATM CREATE CHARACTER ARRAY
        char[] arr = s.toCharArray();
        int lengthSoFar = 0;

        //declare the map
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                //compare pre with all unique values so far in map
                lengthSoFar = Math.max(lengthSoFar, map.size());
                //next index to search for
                i = map.get(arr[i]);
                map.clear();
            }
        }

        return Math.max(lengthSoFar, map.size());

    }


}
