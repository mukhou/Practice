package dataStructures.stacksandqueues;


/**
 * Algorithm:
 * Stacks s1, s2
 * 1. For push operation: s1 will be ordered with the newest elements on the top, while s2 will have the oldest elements on the top.
 * 2. For pop operation: We push the new elements onto s1, and peek and pop from s2.
 * When s2 is empty, we’ll transfer all the elements from s1 onto s2, in reverse order.
 */
public class QueueUsingStack {

    //s1 is used for push, s2 for pop
    StackUsingArray s1, s2;

    public void enQueue(int value){
        if(s1.isFull()){
            System.out.println("Overflow");
        }else {
            s1.push(value);
        }
    }

    public int deQueue(){
        if(!s2.isEmpty()){
            return s2.pop();
        }else {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public int peek(){
        if(!s2.isEmpty()){
            return s2.top();
        }else {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.top;
        }

    }

    public static void main(String[] args){
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.s1 = null;
    }
}
