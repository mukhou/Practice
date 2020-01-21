/* 
User: Urmi
Date: 1/15/2020 
Time: 9:51 PM
*/

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 */
package dynamicprog;

//https://www.geeksforgeeks.org/edit-distance-dp-5/
public class EditDistanceString {

    //Time Complexity: O(m x n)
    //Auxiliary Space: O(m x n)
    private static int editDyn(String str1, String str2, int m, int n) {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                // If first string is empty, only option is to
                // insert all characters of second string
                if(i == 0){
                    dp[i][j] = j;//Min. operations = j
                }else if(j == 0){
                    // If second string is empty, only option is to
                    // remove all characters of second string
                    dp[i][j] = i;//Min. operations = i
                }
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    //both chars same, so at this stage, the no of operations will be same as the
                    //previous subproblem, i.e. at he previous set of chars in both strings
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    // If the last character is different, consider all
                    // possibilities and find the minimum
                    //assumption: the sub problems at dp[i][j - 1], dp[i - 1][j] and dp[i - 1][j - 1]
                    //are already calculated, so just use them
                    dp[i][j] = 1 + min(dp[i][j - 1],//insert
                            dp[i - 1][j], //remove
                            dp[i - 1][j - 1]);//replace
                }
            }
        }

        return dp[m][n];
    }


    //brute force approach
    //worst case time complexity: O(3^m), m is length of str1
    private static int editBrute(String str1, String str2){
        return editBrute(str1, str2, str1.length(), str2.length());
    }

    private static int editBrute(String str1, String str2, int m, int n) {
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if(str1.charAt(m - 1) == str2.charAt(n - 1)){
            return editBrute(str1, str2, m - 1, n - 1);
        }

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(editBrute(str1, str2, m, n - 1),
                editBrute(str1, str2, m - 1, n),
                editBrute(str1, str2, m - 1, n - 1));
    }

    private static int min(int x, int y, int z){
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String args[]){
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDyn(str1, str2, str1.length(), str2.length()));
    }
}
