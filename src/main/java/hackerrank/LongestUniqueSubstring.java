package hackerrank;

import java.util.HashMap;

// IMPORTANT
//check;
// http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
//OR
//http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
public class LongestUniqueSubstring {

	public static void main(String[] args) {
		// System.out.println(findLongestSubstring("abcdefcd"));
		String str = "urmiila";
		String s = "GEEKSFORGEEKS";
		//System.out.println(lengthOfLongestSubstring(s));
		 //longestSubstring(s);
		 System.out.println(lengthOfLongestSubstringInStrig(s));
        //System.out.println(lengthOfLongestSubstringLeetcode(s));
		//System.out.println(lengthOfLongestSubstringInStrin(s));

	}

	// FOLLOW THIS: preferred approach (from geeksforgeeks)

    /**
     * ALGORITHM:
     * 1. if not duplicate, add to map
     * 2. else, find max length
     * 3. set index to where duplicate found
     * 4. clear map
     */

    public static int lengthOfLongestSubstringInStrig(String s) {

        int lengthSoFar = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                //add the character and the index to map
                map.put(s.charAt(i), i);
            } else {
                lengthSoFar = Math.max(lengthSoFar, map.size());
                //next index to search for
                i = map.get(s.charAt(i));
                map.clear();
            }
        }

        return Math.max(lengthSoFar, map.size());
    }

    // from leetcode
    public static int lengthOfLongestSubstringLeetcode(String s) {
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - start, result);

        return result;
    }

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		int i = 0, j = 0;
		int result = 0,  length_so_far = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while (j < s.length()) {
			// Integer c = new Integer(s.charAt(j));
			char c = s.charAt(j);
			if (!map.containsKey(c)) {
				map.put(c, j);
			} else {
				// find length till now
				 length_so_far = j - i;
				// update result
				if (result < length_so_far) {
					result = length_so_far;
				}
				int index = map.get(c);
				i = Math.max(i, index + 1);
				map.put(c, j);
			}
			j++;
		}

		if (result < length_so_far)
			return length_so_far;
		else
			return result;
	}
	

	

}
