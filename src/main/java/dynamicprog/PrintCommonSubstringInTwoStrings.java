/* 
User: Urmi
Date: 1/16/2020 
Time: 8:10 PM
*/

package dynamicprog;

import java.util.Arrays;

//exactly same as LongestCommonSubstringInTwoStrings, but instead of returning the length,
// it returns the longest common substring
public class PrintCommonSubstringInTwoStrings {

    private static String longestCommonSubstring(String s1, String s2, int m, int n){
        // Create a table to store lengths of longest common suffixes of
        // substrings. Note that matrix[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1].
        // IMP: The first row and first column entries have no logical meaning, they are used only
        // for simplicity of program
        int longestLengthTable[][] = new int[m + 1][n + 1];
        int longestLength = 0;
        int row = 0, col =  0;

        /* IMP: s2 will be on the rows(i iteration), s1(j iteration) will be on the columns.
        +1 to leave room at the left for the "".*/
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    longestLengthTable[i][j] = 0;
                }else if(s1.charAt(i - 1) == s2.charAt(j - 1)){//IMP: check equality of chars at prev index
                    longestLengthTable[i][j] = longestLengthTable[i - 1][j - 1] + 1;
                    //IMP: CHECK FOR LENGTH AND ONLY THEN DO REST OF STUFF
                    if(longestLength < longestLengthTable[i][j]){
                        longestLength = longestLengthTable[i][j];
                        //track end of both strings
                        row = i;
                        col = j;
                    }
                }else {
                    longestLengthTable[i][j] = 0;
                }
            }
        }

        // if true, then no common substring exists
        if (longestLength == 0) {
            System.out.println("No Common Substring");
            return "";
        }

        String str = "";
        // traverse up diagonally form the (row, col) cell until LCSuff[row][col] != 0
        while (longestLengthTable[row][col] != 0){
            str = s1.charAt(row - 1) + str; //or s2.charAt(col - 1)
            row --;
            col --;
        }
        return str;
    }

    public static void main(String[] args){
        /*String X = "GeeksforGeeks";
        String Y = "GeeksQuiz";
*/
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";
        int m = X.length();
        int n = Y.length();

        System.out.println("Longest Common Substring is "
                + longestCommonSubstring(X, Y, m, n));


    }
}
