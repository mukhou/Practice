/* 
User: Urmi
Date: 1/13/2020 
Time: 5:58 PM
*/

package dynamicprog;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/string/LongestPalindromeSubstring.java
public class LongestPalindromeSubString {

    //FOLLOW THIS - EXACTLY LIKE LongestPalindromeSubsequence
    private static int longestPalindromeDynamic(String str){
        boolean maxLengthTable[][] = new boolean[str.length()][str.length()];

        for(int i = 0; i < maxLengthTable.length; i++){
            maxLengthTable[i][i] = true;
        }
        int longestLength = 1;
        for(int len = 2; len <= str.length(); len++){
            //i from 0 -> first half
            for(int i = 0; i < str.length() - len + 1; i ++){
                //j starts from second half
                int j = i + len - 1;
                //initialize lengthSoFar for iteration of i
                int lengthSoFar = 0;
                if(len == 2 && str.charAt(i) == str.charAt(j)){
                    maxLengthTable[i][j] = true;
                    lengthSoFar = 2;
                    //chars match AND diagonal value is also true
                }else if(str.charAt(i) == str.charAt(j) && maxLengthTable[i+1][j-1]){
                        maxLengthTable[i][j] = true;
                        lengthSoFar = j - i + 1;
                }
                longestLength = Math.max(longestLength, lengthSoFar);
            }
        }
        return longestLength;
    }

    /*//confusing due to reverse index operations
    public static String longestPalindrome(String input) {
        if (input.isEmpty()) {
            return "";
        }
        int n = input.length();
        int longestSoFar = 0, start = 0, end = 0;
        boolean[][] palindromeTable = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindromeTable[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (input.charAt(j) == input.charAt(i) && (i - j <= 2 || palindromeTable[j + 1][i - 1])) {
                    palindromeTable[j][i] = true;
                    if (i - j + 1 > longestSoFar) {
                        longestSoFar = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        System.out.println("Starting index of longest palindrome is: " + start);
        return input.substring(start, end + 1);
    }

*/



    public static void main(String[] args) {
     //   System.out.println(longestPalindromeString("GEEKSFORGEEKS"));
        System.out.println(longestPalindromeDynamic("forgeeksskeegfor"));
       // System.out.println(longestPalindrome("forgeeksskeegfor"));
       //  System.out.println(longestPalindrome("forgeeksskeegfor"));
       /* System.out.println(longestPalindromeString("9912321456"));
        System.out.println(longestPalindromeString("9912333321456"));
        System.out.println(longestPalindromeString("12145445499"));
        System.out.println(longestPalindromeString("1223213"));*/
        // System.out.println(longestPalindrome("abb"));
        // System.out.println(longestPalindromeString("forgeeksskeegfor"));

    }


}

