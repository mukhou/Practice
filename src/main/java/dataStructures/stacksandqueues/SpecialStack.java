/**
 * Design a Data Structure SpecialStack that supports all the stack operations 
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin() 
 * which should return minimum element from the SpecialStack. 
 * All these operations of SpecialStack must be O(1).
 * Solution: Use two stacks: one to store actual stack elements and other as an
 * auxiliary stack to store minimum values. The idea is to do push() and pop()
 * operations in such a way that the top of auxiliary stack is always the minimum.
 * We can push into the auxiliary stack only when the incoming element of 
 * main stack is smaller than or equal to top of auxiliary stack. 
 * Similarly during pop, if the pop off element equal to top of auxiliary stack,
 * remove the top element of auxiliary stack.
 */
package dataStructures.stacksandqueues;

public class SpecialStack extends StackUsingArray{
	
	StackUsingArray min;
	
	public void push(int x){
		if(isEmpty() == true){
			super.push(x);
			min.push(x);
		}else{
			super.push(x);
			int y = min.pop();
			min.push(y);
			/* push only when the incoming element of main stack is smaller 
	        than or equal to top of auxiliary stack */
			if(x < y){
				min.push(x);
			}
		}
	}
	
	public int pop(){
		int x = super.pop();
		int y = min.pop();
		/* Push the popped element y  back only if it is not equal to x */
		/*if(x != y){
			min.push(y);
		}*/
		return x;
	}
	
	/* SpecialStack's member method to get minimum element from it. */
	int getMin()
	{
	    int x = min.pop();
	    min.push(x);
	    return x;
	}

}
