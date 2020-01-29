/* 
User: Urmi
Date: 1/7/2020 
Time: 9:43 PM
*/

package dataStructures.stacksandqueues;

import java.util.Stack;

//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class MinStackWithNoExtraStack {

    Stack<Integer> stack;
    Integer min;

    public MinStackWithNoExtraStack(Stack<Integer> stack) {
        this.stack = new Stack<>();
    }

    void push(Integer x){
        if(stack.isEmpty()){
            stack.push(x);
            min = x;
        }else {
            if(x < min){
                stack.push((2 * x) - min);
                //update min
                min = x;
            }else {
                stack.push(x);
            }
        }
    }

    Integer pop(){
        if (stack.isEmpty()){
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }
        Integer x = stack.pop();
        // Minimum will change as the minimum element of the stack is being removed.
        if(x < min){
            int temp = min;
            //update min
            min = (2 * min) - x;
            return temp;
        }else {
            return x;
        }
    }

    Integer peek(){
        if (stack.isEmpty()){
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }

        Integer x = stack.peek();
        // If x < minEle means minEle stores value of x.
        if(x < min){
            return min;
        }else {
            return x;
        }



    }
}
