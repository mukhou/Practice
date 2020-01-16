/* 
User: Urmi
Date: 1/13/2020 
Time: 5:58 PM
*/

package byteBybyte;

public class LongestPalindromeInString {

    //FOLLOW THIS
    public static String longestPalindromeString(String s) {
        if (s == null) {
            return null;
        }

        int start, end, longestStart = -1;
        String longest = s.substring(0, 1);
        //IMP i goes up to s.length() - 1
        for (int i = 0; i < s.length() - 1; i++) {
            //odd cases like 121
            int[] arr = intermediatePalindrome(s, i, i);
            start = arr[0];
            end = arr[1];
            String palindrome = s.substring(start, end);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
                longestStart = start;
            }
            //even cases like 1221
            arr = intermediatePalindrome(s, i, i + 1);
            start = arr[0];
            end = arr[1];
            palindrome = s.substring(start, end);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
                longestStart = start;
            }
        }

        System.out.println("Starting index of longest palindrome is: " + longestStart);
        return longest;
    }

    static public int[] intermediatePalindrome(String s, int left, int right) {
        if (left > right){
            return null;
        }
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }


    /*static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }*/

    //confusing due to all index operations
    public static String longestPalindrome(String input) {
        if (input.isEmpty()) {
            return "";
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindromTable = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            palindromTable[j][j] = true;
            for (int i = 0; i < j; i++) {
                if (input.charAt(i) == input.charAt(j) && (j - i <= 2 || palindromTable[i + 1][j - 1])) {
                    palindromTable[i][j] = true;
                    if (j - i + 1 > longestSoFar) {
                        longestSoFar = j - i + 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        System.out.println("Starting index of longest palindrome is: " + startIndex);
        return input.substring(startIndex, endIndex + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindromeString("forgeeksskeegfor"));
        //System.out.println(longestPalindrome("1234"));
       //  System.out.println(longestPalindrome("forgeeksskeegfor"));
       /* System.out.println(longestPalindromeString("9912321456"));
        System.out.println(longestPalindromeString("9912333321456"));
        System.out.println(longestPalindromeString("12145445499"));
        System.out.println(longestPalindromeString("1223213"));*/
        // System.out.println(longestPalindrome("abb"));
        // System.out.println(longestPalindromeString("forgeeksskeegfor"));

    }


}

