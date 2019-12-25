package crackingcodeinterview;

import stacksandqueues.StackUsingArray;

import java.util.HashMap;
import java.util.Map;

//Time Complexity: O(n)
//Auxiliary Space: O(n) for stack.
//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class BalancedParenthesis {

   static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }


    public static boolean isValidParen(char[] expr){
        StackUsingArray stack = new StackUsingArray();
        for(int i = 0; i < stack.getSize(); i++){
            /*If the exp[i] is a starting
            parenthesis then push it*/
            if (expr[i] == '{' || expr[i] == '(' || expr[i] == '[') {
                stack.push(expr[i]);
            }
            /* If exp[i] is an ending parenthesis
             then pop from stack and check if the
             popped parenthesis is a matching pair*/
            if(expr[i] == '}' || expr[i] == ')' || expr[i] == ']'){
                /* If we see an ending parenthesis without
                 a pair then return false*/
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

    public static void main(String[] args)
    {
        char exp[] = {'{','(',')','}','[','['};
        if (isValidParen(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }


}