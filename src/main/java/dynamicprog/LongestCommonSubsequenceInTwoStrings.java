/* 
User: Urmi
Date: 1/16/2020 
Time: 5:04 PM
*/

/**
 * Given two sequences, find the length of the longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 */
package dynamicprog;

//https://www.youtube.com/watch?v=ASoaQq66foQ
//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
//https://github.com/bephrem1/backtobackswe/tree/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestCommonSubsequence
public class LongestCommonSubsequenceInTwoStrings {
    private static int longestCommonSubsequence(String s1, String s2, int m, int n) {

        /* IMP: arr2 will be on the rows(i iteration), arr1(j iteration) will be on the columns.
        +1 to leave room at the left for the "".*/
        int[][] maxLengthTable = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    maxLengthTable[i][j] = 0;
                } else if(s1.charAt(i - 1) == s2.charAt(j - 1)){//IMP: check equality of chars at prev index, because
                    //maxLengthTable[i][j] contains length of LCS of s1[0..i-1] and s2[0..j-1]
                    /*Characters match. Remove both and lengthen the best answer at the subproblem
                     * without either final character. That is the answer to this subproblem.
                    maxLengthTable[i][j] = maxLengthTable[i - 1][j - 1] + 1;
                } else {
                    /**Character mismatch. No +1 happens, we can't lengthen the lcs. But we do need
                     * compete subproblems to find the answer to this one.*/
                    maxLengthTable[i][j] = Math.max(maxLengthTable[i - 1][j], maxLengthTable[i][j - 1]);
                }
            }
        }

        //return the value present at the lengths of both strings
        return maxLengthTable[m][n];
    }

    // a simple recursive solution
    private static int longestCommonSubsequence1(String s1, String s2, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        } else if(s1.charAt(m - 1) == s2.charAt(n - 1)){
            return 1 + longestCommonSubsequence1(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(longestCommonSubsequence1(s1, s2, m - 1, n), longestCommonSubsequence1(s1, s2, m, n - 1));
        }
    }

    public static void main(String[] args){
        String  X = "ABCDGH";
        String Y = "AEDFHR";
        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Subsequence is "
                + longestCommonSubsequence(X, Y, m, n));
    }
}
