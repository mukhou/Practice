/**
 * Design a Data Structure MinStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin() 
 * which should return minimum element from the MinStack.
 * All these operations of MinStack must be O(1).
 * Solution: Use two stacks: one to store actual stack elements and other as an
 * auxiliary stack to store minimum values. The idea is to do push() and pop()
 * operations in such a way that the top of auxiliary stack is always the minimum.
 * We can push into the auxiliary stack only when the incoming element of 
 * main stack is smaller than or equal to top of auxiliary stack. 
 * Similarly during pop, if the pop off element equal to top of auxiliary stack,
 * remove the top element of auxiliary stack.
 */
package stacksandqueues;

public class MinStack extends StackUsingArray {
	
	StackUsingArray min;
	
	public void push(int x){
		super.push(x);
		if(isEmpty()){
			min.push(x);
		}else{
			int y = min.top;

			/* push only when the incoming element of main stack is smaller 
	        than or equal to top of auxiliary stack */
			if(x < y){
				min.push(x);
			}
		}
	}
	
	public int pop(){
		int x = super.pop();
		int y = min.top;
		/* Push the popped element y  back only if it is not equal to x */
		if(x == y){
			min.pop();
		}
		return x;
	}

	/* MinStack's member method to get minimum element from it. */
	int getMin()
	{
	    if(isEmpty()){
	    	return Integer.MAX_VALUE;
		}
		return min.top;
	}

}
