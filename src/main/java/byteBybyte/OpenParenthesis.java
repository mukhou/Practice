/* 
User: Urmi
Date: 1/10/2020 
Time: 11:25 AM
*/

/**
 * Find index of closing bracket for a given opening bracket in an expression
 */

package byteBybyte;

import java.util.Stack;

public class OpenParenthesis {
    public static long solution(String parentheses, long index) {

        if(parentheses.charAt((int)index) != '('){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for( int i = (int) index; i < parentheses.length(); i++){
            if(parentheses.charAt(i) == '('){
                stack.push(parentheses.charAt(i));
            }else if (parentheses.charAt(i) == ')') {
                stack.pop();
                if (stack.empty()) {
                    return i;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args){
        System.out.println(solution("((())())", 0L));
    }
}