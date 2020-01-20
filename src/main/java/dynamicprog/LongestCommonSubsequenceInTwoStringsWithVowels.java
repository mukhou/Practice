/* 
User: Urmi
Date: 1/17/2020 
Time: 8:29 AM
*/

/**
 * Given two strings X and Y of length m and n respectively.
 * The problem is to find the length of the longest common subsequence of strings X and Y which contains all vowel characters.
 * Input : X = "aieef"
 *         Y = "klaief"
 * Output : aie
 */
package dynamicprog;

import java.util.Set;

import static byteBybyte.VowelsInString.createVowels;

//https://www.geeksforgeeks.org/length-of-longest-common-subsequence-containing-vowels/
public class LongestCommonSubsequenceInTwoStringsWithVowels {

    //Time Complexity: O(m*n).
    private static int longestCommonSubsequenceWithVowels(String s1, String s2, int m, int n){
        int[][] maxLengthTable = new int[m + 1][n + 1];
        Set<Character> allVowels = createVowels();
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 ||j == 0){
                    maxLengthTable[i][j] = 0;
                }else if(s1.charAt(i - 1) == s2.charAt(j - 1) &&
                        allVowels.contains(s1.charAt(i - 1))){
                    maxLengthTable[i][j] = maxLengthTable[i - 1][j - 1] + 1;
                }else {
                    maxLengthTable[i][j] = Math.max(maxLengthTable[i - 1][j], maxLengthTable[i][j - 1]);
                }
            }
        }
        return maxLengthTable[m][n];
    }


    public static void main(String[] args) {
        /*String X = "aieef";
        String Y = "klaief";*/

        String X = "geeksforgeeks";
        String Y = "feroeeks";
        int m = X.length();
        int n = Y.length();

        System.out.println(longestCommonSubsequenceWithVowels(X, Y, X.length(), Y.length()));
    }
}
