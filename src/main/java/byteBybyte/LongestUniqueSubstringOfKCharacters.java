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

//https://www.techiedelight.com/find-longest-substring-containing-k-distinct-characters/
//https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
public class LongestUniqueSubstringOfKCharacters {

    //FOLLOW THIS, SIMILAR LOGIC LIKE LongestUniformSubstring
    public static int[] lengthOfLongestSubstringKDistinct(String s, int k) {

        //to track length and track starting point for removal
        int longestLength = 0, longestStart = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //get and put
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);

            if (map.size() > k) {
                //get longest
                longestLength = Math.max(longestLength, i - longestStart);
                while (map.size() > k) {
                    char t = s.charAt(longestStart ++);
                    int count = map.get(t);
                    if (count > 1) {
                        map.put(t, count - 1);
                    } else {
                        //frequency of leftmost character, so remove it from map
                        map.remove(t);
                    }
                }
            }
        }

        //IMP check max
        longestLength = Math.max(longestLength, s.length() - longestStart);
        return new int[]{longestLength, longestStart};
    }

    public static void main(String[] args) {

        //"abcadcacacaca", "abac";
        String s = "abcadcacacaca";
        int[] arr = lengthOfLongestSubstringKDistinct(s, 3);
        System.out.println("longest length: " + arr[0]);
        System.out.println("longest starting index: " + arr[1]);
        int temp = arr[0], temp1 = arr[1];
        while (temp != 0) {
            System.out.print(s.charAt(temp1++));
            temp--;
        }
        System.out.println();


    }

}
