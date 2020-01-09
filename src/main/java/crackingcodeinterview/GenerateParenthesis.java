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

//CTCI pg 371
public class GenerateParenthesis {

    public static List<String> generateParens(int n){
        char[] arr = new char[n * 2];
        List<String> list = new ArrayList<>();
        generateParens(list, n, n, arr, 0);
        return list;
    }

    private static void generateParens(List<String> list, int left, int right, char[] arr, int index) {
        //IMP
        if (left < 0 || right < left) return; // invalid state

        if(left == 0 && right == 0){
            list.add(String.copyValueOf(arr));
        }else{
            //add left and recurse
            arr[index] = '(';
            generateParens(list, left - 1, right, arr, index + 1);

            //add right and recurse
            arr[index] = ')';
            generateParens(list, left, right - 1, arr, index + 1);
        }
    }

    public static void main(String[] args){
        System.out.println(generateParens(3));
    }
}
