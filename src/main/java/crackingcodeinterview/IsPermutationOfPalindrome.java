package crackingcodeinterview;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Given a string, write a function to check if it is a permutation of
 * a palindrome.
 */
public class IsPermutationOfPalindrome {

    private static boolean isPerm(String str){
        Map<Character, Integer> map = Maps.newHashMap();
        int countOdd = 0;
        for(Character c : str.toCharArray()){
            map.merge(c, 1, Integer::sum);
            if(map.get(c) % 2 == 1){
                countOdd ++;
            }
            else {
                countOdd --;
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args){
        System.out.println(isPerm("tacat"));
    }
}
