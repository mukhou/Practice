package stacksandqueues;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/2/18
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxStack extends StackUsingArray{
    StackUsingArray max;

    public void push(int x){
        if(isEmpty() == true){
            super.push(x);
            max.push(x);
        }else{
            super.push(x);
            int y = max.top;

			/* push only when the incoming element of main stack is greater
	        than or equal to top of auxiliary stack */
            if(x > y){
                max.push(x);
            }
        }
    }

    public int pop(){
        int x = super.pop();
        int y = max.pop();
		/* Push the popped element y  back only if it is not equal to x */
        if(x != y){
            max.push(y);
        }
        return x;
    }

    /* maxStack's member method to get maximum element from it. */
    int getMax()
    {
        int x = max.pop();
        max.push(x);
        return x;
    }


}
