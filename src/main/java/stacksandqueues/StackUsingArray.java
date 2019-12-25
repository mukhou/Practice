package stacksandqueues;

public class StackUsingArray {
	int top;
	int[] stack;
	int max = 100;
	
	public StackUsingArray(){
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
		if(top>=max) return;
		stack[++top] = item;
	}

	/**
	 * IMP: Sort a stack such that the smallest elements are on top.
	 * Can use additional stack
	 * Algorithm: See cracking code interview(new edition) page 249 for details
	 * Time complexity: O(n^2), Space complexity: O(n)
	 */
	public StackUsingArray sort(StackUsingArray s1){
		StackUsingArray s2 = new StackUsingArray();
		while(!s1.isEmpty()){
			int temp = s1.pop();
			while(!s2.isEmpty() && s2.top > temp){
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}

    public int getSize(){
        return top + 1;
    }

}
