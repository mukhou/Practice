package stacksandqueues;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Algorithm:
 * Queues - Q1, Q2
 * 1. For push operation: if Q1 has space , enqueue the value into it. Else throw exception
 * 2. For pop operation: If Q1 is empty , an underflow has occurred , throw an error
 *    Else , we copy all but the last element of Q1 to Q2 , we return the last element copied .
 * 3. We then copy back the elements from Q2 to Q1.
 * Link: http://www.algo-faq.com/Stacks-and-Queues/How-to-implement-a-Stack-using-two-Queues.php
 */
public class StackUsingQueue {

    //q1 used for push and pop, q2 for temp storage
    QueueUsingArray q1, q2;

    public void push(int value){
        if(q1.isFull()){
            System.out.println("Overflow");
        }else {
            q1.enQueue(value);
        }
    }


    public int pop(){
        if(q1.isEmpty()){
            System.out.println("Underflow");
            return -1;
        }else {
            while(q1.getSize() != 1){
                q2.enQueue(q1.deQueue());
            }
            //Now only last element left in q1 , this is the one that needs to be pushed to Stack
            int stackValue = q1.deQueue();

            // reload Q1
            while (!q2.isEmpty()){
                q1.enQueue(q2.deQueue());
            }
            return stackValue;
        }
    }

    public static void main(String[] args){
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.q1 = new QueueUsingArray();
        stackUsingQueue.q2 = new QueueUsingArray();
        /*stackUsingQueue.q1.enQueue(1);
        stackUsingQueue.q1.enQueue(2);
        stackUsingQueue.q1.enQueue(3);
        stackUsingQueue.q1.enQueue(4);
        stackUsingQueue.q1.enQueue(5);*/
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        stackUsingQueue.push(3);
        stackUsingQueue.push(4);
        stackUsingQueue.push(5);
        System.out.println(stackUsingQueue.q1.getSize());
        System.out.println(Arrays.toString(stackUsingQueue.q1.data));



    }

}
