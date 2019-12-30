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

    private static boolean isPerm1(String str){
        int[] table = new int[128];
        int countOdd = 0;
        for(Character c : str.toCharArray()){
            int val = Character.getNumericValue(c);
            if(val != -1){
                table[val] ++;
            }
            if(table[val] % 2 == 1){
                countOdd ++;
            }else {
                countOdd --;
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args){
        System.out.println(isPerm("tacat"));
        System.out.println(isPerm1("tacau"));

    }
}
