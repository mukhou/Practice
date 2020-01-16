/* 
User: Urmi
Date: 1/3/2020 
Time: 11:56 AM
*/

package byteBybyte;

import java.util.Stack;

//https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
//to do infixtoprefix, just reverse the final result
public class InfixToPostFix {

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    static int Prec(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    static String infixToPostfix(String exp){
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i){
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } else if (c == '(') { // If the scanned character is an '(', push it to the stack.
                stack.push(c);
            }else if (c == ')'){// If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // invalid expression
                }else {//IMP
                    result +=stack.pop();
                }
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    if(stack.peek() == '('){
                        return "Invalid Expression";
                    }
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    // Driver method
    public static void main(String[] args)
    {
        String exp = "A+B*C";//"A*B-C/D+E";//"a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("postfix is " + infixToPostfix(exp));
        String res = infixToPostfix(exp);
        String rev = new String();
        for(int i = res.length() - 1; i >= 0; i--){
            rev += res.charAt(i);
        }
        System.out.println("prefix is " + rev);
    }


}
