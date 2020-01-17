/* 
User: Urmi
Date: 1/8/2020 
Time: 9:14 PM
*/

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */
package dynamicprog;

import java.util.Arrays;

//https://www.geeksforgeeks.org/longest-common-substring-dp-29/
//time complexity: O(m * n)
public class LongestCommonSubstringInTwoStrings {

    //IMP: watch this video for clarity: https://www.youtube.com/watch?v=ASoaQq66foQ
    private static int lengthOfLongestCommonSubstring(String s1, String s2, int m, int n){
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that matrix[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1].
        // IMP: The first row and first column entries have no logical meaning, they are used only
        // for simplicity of program
        int longestLengthTable[][] = new int[m + 1][n + 1];
        int longestLength = 0;

        /* IMP: s2 will be on the rows(i iteration), s1(j iteration) will be on the columns.
        +1 to leave room at the left for the "".*/
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    longestLengthTable[i][j] = 0;
                }else if(s1.charAt(i - 1) == s2.charAt(j - 1)){//IMP: check equality of chars at prev index
                    longestLengthTable[i][j] = longestLengthTable[i - 1][j - 1] + 1;
                    longestLength = Math.max(longestLength, longestLengthTable[i][j]);
                }else {
                    longestLengthTable[i][j] = 0;
                }
            }
        }


        for(int p = 0; p < longestLengthTable.length; p++){
            System.out.println(Arrays.toString(longestLengthTable[p]));
        }
        return longestLength;
    }

    public static void main(String[] args){
        /*String X = "GeeksforGeeks";
        String Y = "GeeksQuiz";*/

        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is "
                + lengthOfLongestCommonSubstring(X, Y, m, n));


    }

}
