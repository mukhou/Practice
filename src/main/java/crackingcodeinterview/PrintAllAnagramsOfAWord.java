package crackingcodeinterview;

import java.util.HashSet;
import java.util.Set;

//also find all permutations of a string
public class PrintAllAnagramsOfAWord {

    public static Set<String> permute(String chars) {
        // Use sets to eliminate semantic duplicates (aab is still aab even if you
        //switch the two 'a's)
        // Switch to HashSet for better performance
        //NO ARRAY CONVERSION
        Set<String> set = new HashSet<>();

        // Termination condition: only 1 permutation for a string of length 1
        if (chars.length() == 1) {
            set.add(chars);
        } else {
            // Give each character a chance to be the first in the permuted string
            for (int i = 0; i < chars.length(); i++) {
                // Remove the character at index i from the string
                String first = chars.substring(0, i);//0 -> i
                String rest = chars.substring(i + 1);// i + 1 -> end
                String remaining = first + rest;

                // Recursive call: to find all the permutations of the remaining chars
                for (String permutation : permute(remaining)) {
                    //Concatenate the first character from original string with the permutations
                    //of the remaining chars
                    set.add(chars.charAt(i) + permutation);
                }
            }
        }

        return set;
    }


    public static void main(String[] args) {

        System.out.println(permute("abc"));


    }

}
