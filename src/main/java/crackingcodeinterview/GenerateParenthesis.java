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
//Algorithm:
// On each recursive call, we have the index for a particular character in the string. We need to select either a
//left or a right paren. When can we use a left paren, and when can we use a right paren?
//1. left Paren: As iong as we haven't used up all the left parentheses, we can always insert a left paren.
//2. Right Paren: We can insert a right paren as long as it won't lead to a syntax error. When will we get a
//syntax error? We will get a syntax error if there are more right parentheses than left.
//So, we simply keep track of the number of left and right parentheses allowed. If there are left parens
//remaining, we'll insert a left paren and recurse. If there are more right parens remaining than left {i.e., if
//there are more left parens in use than right parens), then we'll insert a right paren and recurse.
public class GenerateParenthesis {

    public static List<String> generateParens(int n){
        char[] arr = new char[n * 2];
        List<String> list = new ArrayList<>();
        generateParens(list, n, n, arr, 0);
        return list;
    }

    private static void generateParens(List<String> list, int leftCount, int rightCount, char[] arr, int index) {
        //IMP
        if (leftCount < 0 || rightCount < leftCount) return; // invalid state

        if(leftCount == 0 && rightCount == 0){
            list.add(String.copyValueOf(arr));
        }else{
            //add left and recurse
            arr[index] = '(';
            generateParens(list, leftCount - 1, rightCount, arr, index + 1);

            //add right and recurse
            arr[index] = ')';
            generateParens(list, leftCount, rightCount - 1, arr, index + 1);
        }
    }

    public static void main(String[] args){
        System.out.println(generateParens(3));
    }
}
