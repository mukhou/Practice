/* 
User: Urmi
Date: 1/8/2020 
Time: 9:14 PM
*/

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 */
package byteBybyte;

//https://www.geeksforgeeks.org/longest-common-substring-dp-29/
//time complexity: O(m * n)
public class LongestCommonSubstringInTwoStrings {

    public static int longestCommonSubstring(char[] arr1, char[] arr2, int m, int n){
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that matrix[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        int matrix[][] = new int[m + 1][n + 1];

        int longestLength = 0;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    matrix[i][j] = 0;
                }else if(arr1[i - 1] == arr2[j - 1]){
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    longestLength = Math.max(longestLength, matrix[i][j]);

                }else {
                    matrix[i][j] = 0;
                }
            }
        }
        return longestLength;
    }

    public static void main(String[] args)
    {
        String X = "GeeksforGeeks";
        String Y = "GeeksQuiz";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of Longest Common Substring is "
                + longestCommonSubstring(X.toCharArray(), Y.toCharArray(), m, n));
    }

}
