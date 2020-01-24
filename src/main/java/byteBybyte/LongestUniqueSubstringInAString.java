package byteBybyte;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// IMPORTANT
//check;
// http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
//OR
//http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
//IMP
//https://www.baeldung.com/java-longest-substring-without-repeated-characters
public class LongestUniqueSubstringInAString {

    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        //System.out.println(longestUniqueSubstring(s));
        System.out.println(getUniqueCharacterSubstring(s));
    }

    //FOLLOW THIS
    //ATM: TWO CONSECUTIVE IF BLOCKS, start = 0, end = 0
    private static String getUniqueCharacterSubstring(String str) {
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < str.length(); end++) {
            //IMP: get the character with index "end"
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                //fix max start and length
                start = Math.max(start, map.get(c) + 1);//IMP map.get(c) + 1
            }
            if (result.length() < end - start + 1) {
                result = str.substring(start, end + 1);//IMP: end + 1, as second index is 1 based
            }
            map.put(c, end);
        }

        return result;
    }

    // ALTHOUGH IT GIVES YOU THE LENGTH OF LONGEST SUBSTRING, YOU LOOSE TRACK OF START AND END OF IT
    public static int longestUniqueSubstring(String s) {

        int lengthSoFar = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                //compare pre with all unique values so far in map
                lengthSoFar = Math.max(lengthSoFar, map.size());
                //next index to search for
                i = map.get(s.charAt(i));
                map.clear();
            }
        }

        //IMP, return max
        //System.out.println(start);
        return Math.max(lengthSoFar, map.size());
    }




}
