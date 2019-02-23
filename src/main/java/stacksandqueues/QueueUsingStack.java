package stacksandqueues;


public class QueueUsingStack {
    StackUsingArray s1, s2;
    public void enQueue(int value){
        if(s1.isFull()){
            System.out.println("Overflow");
        }else {
            s1.push(value);
        }
    }

    public int deQueue(){
        if(s1.isEmpty()){
            System.out.println("Underflow");
            return 0;
        }else {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            // obtaining the value to return
            int value = s2.pop();
            // copying the values back to s1
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

            return value;
        }
    }
}
