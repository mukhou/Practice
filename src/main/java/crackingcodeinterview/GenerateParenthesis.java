/**
 * Given a number n, generate all possible permutations of valid parenthesis.
 * Eg: n = 3:
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 */
package crackingcodeinterview;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParens(int n){
        char[] str = new char[n * 2];
        List<String> list = new ArrayList<>();
        generateParens(list, n, n, str, 0);
        return list;
    }

    private static void generateParens(List<String> list, int left, int right, char[] str, int index) {

        if (left < 0 || right < left) return; // invalid state
        if(left == 0 && right == 0){
            list.add(String.copyValueOf(str));
        }else{
            //add left and recurse
            str[index] = '(';
            generateParens(list, left - 1, right, str, index);

            //add right and recurse
            str[index] = ')';
            generateParens(list, left, right - 1, str, index);
        }
    }
}
