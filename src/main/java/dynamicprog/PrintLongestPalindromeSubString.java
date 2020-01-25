/* 
User: Urmi
Date: 1/25/2020 
Time: 10:42 AM
*/

package dynamicprog;

//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
public class PrintLongestPalindromeSubString {

    private static String printLongestPalindromeDynamic(String str){
        boolean table[][] = new boolean[str.length()][str.length()];

        for(int i=0; i < table.length; i++){
            table[i][i] = true;
        }
        int longestLength = 1;
        int start = 0, end = 0;
        for(int len = 2; len <= str.length(); len++){
            int lengthSoFar;
            //i from 0 -> first half
            for(int i = 0; i < str.length() - len + 1; i ++){
                int j = i + len - 1;
                lengthSoFar = 0;
                if(len == 2 && str.charAt(i) == str.charAt(j)){
                    table[i][j] = true;
                    lengthSoFar = 2;
                }else if(str.charAt(i) == str.charAt(j) && table[i+1][j-1]){
                    table[i][j] = true;
                    lengthSoFar = j - i + 1;
                }
                //SIMILAR TO PrintLongestCommonSubstringInTwoStrings
                if(lengthSoFar > longestLength){
                    longestLength = lengthSoFar;
                    start = i;
                    end = j;
                }
            }
        }
        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(printLongestPalindromeDynamic("forgeeksskeegfor"));
    }

}
