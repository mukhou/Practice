/* 
User: Urmi
Date: 1/20/2020 
Time: 10:20 PM
*/

package dynamicprog;

import java.util.Arrays;

//https://www.geeksforgeeks.org/printing-longest-common-subsequence/
public class PrintLongestCommonSubsequenceInTwoStrings {
    private static String printLongestCommonSubsequence(String s1, String s2, int m, int n) {

        /* IMP: arr2 will be on the rows(i iteration), arr1(j iteration) will be on the columns.
        +1 to leave room at the left for the "".*/
        int[][] maxLengthTable = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    maxLengthTable[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {//IMP: check equality of chars at prev index
                    /*Characters match. Remove both and lengthen the best answer at the subproblem
                     * without either final character. That is the answer to this subproblem.*/
                    maxLengthTable[i][j] = maxLengthTable[i - 1][j - 1] + 1;
                } else {
                    /**Character mismatch. No +1 happens, we can't lengthen the lcs. But we do need
                     * compete subproblems to find the answer to this one.*/
                    maxLengthTable[i][j] = Math.max(maxLengthTable[i - 1][j], maxLengthTable[i][j - 1]);
                }
            }
        }

        //PRINT THE LONGEST COMMON SUBSEQUENCE
        int index = maxLengthTable[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index + 1];

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // If current character in both strings are same, then
            // current character is part of LCS
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // Put current character in result
                lcs[index - 1] = s1.charAt(i - 1);
                //keep going backwards
                i--;
                j--;
                index--;
            }
            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (maxLengthTable[i - 1][j] > maxLengthTable[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <= temp; k++) {
            sb.append(lcs[k]);
        }
        return sb.toString();

    }

    public static void main(String[] args){
        String  X = "ABCDGH";
        String Y = "AEDFHR";
        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Subsequence is "
                + printLongestCommonSubsequence(X, Y, m, n));
    }
}
