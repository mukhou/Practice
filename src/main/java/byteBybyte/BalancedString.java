package byteBybyte;

import java.util.*;

/**
 * Sample inputs:
 * ({})
 * (({()})))
 * ({(){}()})()({(){}()})(){()}
 * {}()))(()()({}}{}
 * }}}}
 * ))))
 * {{{
 * (((
 * {}(){()}((())){{{}}}{()()}{{}{}}
 */

public class BalancedString {
    public static void main(String[] args) {
        System.out.println(1 % 2);
        System.out.println(isBalancedString("{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){["));

    }

    static Map<Character, Character> matchingPairs = new HashMap<Character, Character>();
    static{
        matchingPairs.put('}','{');
        matchingPairs.put(']','[');
        matchingPairs.put(')','(');
    }

    /**
     * IMPORTANT:
     * Dequeue interface should be used in preference to the legacy Stack class.
     * When a deque is used as a stack, elements are pushed and popped from the beginning of the deque.
     */
    public static boolean isBalancedString(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '('){
                stack.push(expression.charAt(i));
            }
            else{
                if(matchingPairs.get(expression.charAt(i)) != stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    // USING STACK
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else {
                if (!stack.isEmpty() && str.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (!stack.isEmpty() && str.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (!stack.isEmpty() && str.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }else {
                    break;
                }
            }

        }
        if(i==str.length() && stack.isEmpty()){
            return true;
        }
        return false;

    }



}
