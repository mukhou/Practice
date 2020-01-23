package crackingcodeinterview;

import stacksandqueues.StackUsingArray;

import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(n)
//Auxiliary Space: O(n) for stack.
//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
//EXACTLY SAME AS BalancedString class
public class BalancedParenthesis {

   static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }


    public static boolean isValidParen(char[] expr){
        StackUsingArray stack = new StackUsingArray();
        for(int i = 0; i < expr.length; i++){
            /*If the exp[i] is a starting
            parenthesis then push it*/
            if (expr[i] == '{' || expr[i] == '(' || expr[i] == '[') {
                stack.push(expr[i]);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char c = (char) stack.pop();
                if(!map.get(expr[i]).equals(c)){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isValidParen1(char[] expr){
        StackUsingArray stack = new StackUsingArray();
        for(int i = 0; i < expr.length; i++){
            /*If the exp[i] is a starting
            parenthesis then push it*/
            if (expr[i] == '{' || expr[i] == '(' || expr[i] == '[') {
                stack.push(expr[i]);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char c = (char) stack.pop();
                if((expr[i] == '}' && c != '{') || (expr[i] == ')' && c != '(') ||
                (expr[i] == ']' && c != '[')){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args)
    {
        char exp[] = {'{','(',')','}','[',']'};
        if (isValidParen(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");

        if (isValidParen1(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }


}
