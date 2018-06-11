package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/17/18
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.hackerrank.com/challenges/maximum-element/problem
 */
public class StackOperations {
    int top;
    int[] stack;
    int max = 100;

    public StackOperations(){
        stack = new int[100];
        top = -1;
    }



    public int top(){
        return stack[top];
    }

    //Time: O(1)
    public int pop(){
        if(top < 0) return -1;
        return stack[top--];
    }

    public boolean isEmpty(){
        if(top == -1)
            return true;
        return false;
    }

    public boolean isFull()	{
        if(top == max - 1)
            return true;
        return false;
    }

    //Time: O(1)
    public void push(int item){
        if(top>=100) return;
        stack[++top] = item;
    }

    public int getSize(){
        return top + 1;
    }


}
