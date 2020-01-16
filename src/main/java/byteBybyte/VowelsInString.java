/* 
User: Urmi
Date: 1/14/2020 
Time: 4:33 PM
*/

package byteBybyte;

import java.util.HashSet;
import java.util.Set;

public class VowelsInString {

    static int findSubstring(String str) {
        //to store the vowels
        Set<Character> hash = new HashSet<>();
        //result set
        Set<String> result = new HashSet<>();
        Set<Character> allVowels = createVowels();

        // Outer loop picks starting character and
        // inner loop picks ending character.
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // If current character is not vowel,
                // then no more result substrings
                // possible starting from str[i].
                if (!allVowels.contains(str.charAt(j))) {
                    break;
                }
                // If vowel, then we insert it in hash
                hash.add(str.charAt(j));
                // If all vowels are present in current
                // substring
                if (hash.size() == 5) {
                    result.add(str.substring(i, j + 1));
                }
            }
            hash.clear();
        }

        System.out.println("all substrings are: " + result);

        return result.size();
    }

    private static Set<Character> createVowels() {
        Set<Character> allVowels = new HashSet<>();
        allVowels.add('a');
        allVowels.add('e');
        allVowels.add('i');
        allVowels.add('o');
        allVowels.add('u');
        return allVowels;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "aaeiouxa";
        System.out.println(findSubstring(str));
    }

}
