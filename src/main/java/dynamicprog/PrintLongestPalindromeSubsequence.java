/* 
User: Urmi
Date: 1/25/2020 
Time: 11:17 AM
*/

package dynamicprog;

//https://www.geeksforgeeks.org/print-longest-palindromic-subsequence/
//Algorithm:
//1) Reverse the given sequence and store the reverse in another array say rev[0..n-1]
//2) LCS of the given sequence and rev[] will be the longest palindromic sequence.
//3) Once we have found LCS, we can print the LCS.
public class PrintLongestPalindromeSubsequence {

    private static String printLongestPalindromeSubsequence(String str){
        return printLongestPalindromeSubsequence(str, reverse(str));
    }

    private static String printLongestPalindromeSubsequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] maxLengthTable = new int[m + 1][n + 1];

        //logic to find LCS
        for(int i = 0; i <= m; i ++){
            for(int j = 0; j <= n; j ++){
                if(i == 0 || j == 0){
                    maxLengthTable[i][j] = 0;
                }else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    maxLengthTable[i][j] = maxLengthTable[i - 1][j - 1] + 1;
                }else {
                    maxLengthTable[i][j] = Math.max(maxLengthTable[i - 1][j], maxLengthTable[i][j - 1]);
                }
            }
        }
        //print LCS
        String res = "";
        int i = m, j = n;
        while( i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                res = str1.charAt(i - 1) + res;
                i --;
                j --;
            }else if(maxLengthTable[i - 1][j] > maxLengthTable[i][j - 1]){
                i --;
            }else {
                j --;
            }
        }

        return res;
    }

    private static String reverse(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args){
        System.out.println(printLongestPalindromeSubsequence("GEEKSFORGEEKS"));
    }
}
