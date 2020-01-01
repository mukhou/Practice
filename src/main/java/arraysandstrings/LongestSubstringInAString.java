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
		String s = "GEEKSFORGEEKS";
		//System.out.println(lengthOfLongestSubstring(s));
		 //longestSubstring(s);
		 System.out.println(lengthOfLongestSubstringInStrig(s));

		// System.out.println(lengthOfLongestSubstringInStrig1(s));
       // System.out.println(lengthOfLongestSubstringLeetcode(s));
		//System.out.println(lengthOfLongestSubstringInStrin(s));

	}

	// FOLLOW THIS: preferred approach (from geeksforgeeks)
    public static int lengthOfLongestSubstringInStrig(String s) {

        int lengthSoFar = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        //need this to also keep track of the longest string
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                //compare pre with all unique values so far in map
                lengthSoFar = Math.max(lengthSoFar, map.size());
                //next index to search for
                i = map.get(s.charAt(i));
                map.clear();
                //reset sb: keep the latest character arr[i] for next iteration
                for(int j = 0; j < i && j < sb.length(); j ++){
                    sb.deleteCharAt(j);
                }
            }
        }

        System.out.println(sb.toString());
        return Math.max(lengthSoFar, map.size());
    }
}
