/* 
User: Urmi
Date: 1/7/2020 
Time: 6:27 PM
*/

package byteBybyte;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    public static String solution(String S) {

        int number = Integer.parseInt(S);
        int remainder;
        String result = "";
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(number > 0){
            remainder = number % 16;
            result += hex[remainder];
            number /= 16;
        }
        System.out.println(result);

        return "";
    }

    public static void main(String[] args){
        solution("3");
    }
}
