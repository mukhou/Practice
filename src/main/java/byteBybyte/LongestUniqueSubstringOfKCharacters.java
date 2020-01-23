/* 
User: Urmi
Date: 1/13/2020 
Time: 10:10 AM
*/

/**
 * Find the longest substring with k unique characters in a given string
 */

package byteBybyte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.techiedelight.com/find-longest-substring-containing-k-distinct-characters/
//https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
public class LongestUniqueSubstringOfKCharacters {

    //Similar LongestUniqueSubstringInAString
    public static String longestSubstr(String str, int k) {
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();
        for (int start = 0, end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            //add to window and map
            window.add(c);
            map.merge(c, 1, Integer::sum);
            // if window size is more than k, remove characters from the left
            while (window.size() > k) {
               //start removing from leftmost character
                char t = str.charAt(start);
                int count = map.get(t);
                if(--count == 0){
                    window.remove(t);
                    map.remove(t);
                }
                start++;
            }
            //EXACTLY LIKE LongestUniqueSubstringInAString
            if (result.length() < end - start + 1) {
                result = str.substring(start, end + 1);
            }
        }

        System.out.println("result is " + result);
        // return longest substring found at str[begin..end]
        return result;
    }

    //NO NOT FOLLOW - DOES NOT RETURN THE SUBSTRING ITSELF
    public static int lengthOfLongestSubstringKDistinct1(String s, int k) {
        int longestLength = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
            if (map.size() <= k) {
                longestLength = Math.max(longestLength, i - start + 1);
            } else {
                while (map.size() > k) {
                    char l = s.charAt(start);
                    int count = map.get(l);
                    if (count == 1) {
                        map.remove(l);
                    } else {
                        map.put(l, count - 1);
                    }
                    start++;
                }
            }
        }

        System.out.println("start is " + start);
        return longestLength;
    }

    public static void main(String[] args) {

        //"abcadcacacaca", "abac";
        String s = "abcbdbdbbdcdabd";
        /*int[] arr = lengthOfLongestSubstringKDistinct(s, 3);
        System.out.println("longest length: " + arr[0]);
        System.out.println("longest starting index: " + arr[1]);
        int longestLength = arr[0], start = arr[1];
        while (longestLength != 0) {
            System.out.print(s.charAt(start++));
            longestLength--;
        }
        System.out.println();*/
        //System.out.println(lengthOfLongestSubstringKDistinct1(s, 2));
        System.out.println(longestSubstr(s, 3));


    }

}
