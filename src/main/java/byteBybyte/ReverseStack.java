/* 
User: Urmi
Date: 1/3/2020 
Time: 4:24 PM
*/

/**
 * Reverse a stack without using any additional data structures
 */
package byteBybyte;

import java.util.Stack;

//https://www.byte-by-byte.com/reversestack/
public class ReverseStack {

    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        //IMP
        if(stack.isEmpty()){
            return stack;
        }

        int temp = stack.pop();
        //traverse till bottom
        reverseStack(stack);
        insertAtBottom(stack, temp);
        return stack;
    }

    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);
    }

}
