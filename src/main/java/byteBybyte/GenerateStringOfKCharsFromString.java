/* 
User: Urmi
Date: 2/2/2020 
Time: 9:04 PM
*/
/**
 * Given a string of n characters and a number k, generate all possible combinations for length k from the string
 */

package byteBybyte;

//Amazon question bank
public class GenerateStringOfKCharsFromString {

    private static void makeCombinations(String prefix, String remainder, int k){
        if(prefix.length() == k){
            System.out.println(prefix);
            return;
        }
        for(int i = 0; i < remainder.length(); i++){
            makeCombinations(prefix + remainder.charAt(i), remainder.substring(i + 1), k);
        }
    }

    public static void main(String[] args){
        makeCombinations("", "ABCDE", 3);
    }
}
