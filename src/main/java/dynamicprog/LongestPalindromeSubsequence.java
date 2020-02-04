/* 
User: Urmi
Date: 1/24/2020 
Time: 5:37 PM
*/

/**
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 */
package dynamicprog;


import java.util.Arrays;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java
//watch this video: https://www.youtube.com/watch?v=yZWmS6CXbQc
public class LongestPalindromeSubsequence {

    private static int longestPalindromeSubsequence(String str){
        int[][] maxLengthTable = new int[str.length()][str.length()];
        //set all diagonals to i, as each character by itself is a longest palindrome of length 1
        for(int i = 0; i < str.length(); i++) {
            maxLengthTable[i][i] = 1;
        }
        //len starts from 2 as length 1 is already covered above
        for(int len = 2; len <= str.length(); len ++){
            //i goes from 0 to first half, j starts from second half
            for(int i = 0; i < str.length() - len + 1; i ++){
                int j = i + len - 1;
                if(len == 2 && str.charAt(i) == str.charAt(j)){
                    maxLengthTable[i][j] = 2;
                }else if(str.charAt(i) == str.charAt(j)){
                    //if chars match, set the value to 2 + value at diagonal
                    //    0 1 2 3 4 5
                    //eg: a d b b c a; i = 0, j = 5: both are a, so now we need to find
                    //the longest length between [d b b c] => [1 -> 4] => [i + 1, j - 1] and
                    //add 2 to it
                    maxLengthTable[i][j] = maxLengthTable[i + 1][j - 1] + 2;
                }else {
                    //i = 1, j = 4: chars NOT MATCH. so max length b/w [d b b c] will be
                    //max(max length b/w [d b b] and [b b c] => [1, 3] and [2, 4]
                    maxLengthTable[i][j] = Math.max(maxLengthTable[i][j - 1], maxLengthTable[i + 1][j]);
                }
            }
        }

        for(int i = 0; i < maxLengthTable.length; i++){
            System.out.println(Arrays.toString(maxLengthTable[i]));
        }
        //result will be the last column of first row
        return maxLengthTable[0][str.length() - 1];
    }

    public static void main(String[] args) {
        String seq = "asdbbd";//"adbbca";
        System.out.println("String is " + seq);
        System.out.printf("The length of the LPS is %d", longestPalindromeSubsequence(seq));

    }
}
