/* 
User: Urmi
Date: 1/29/2020 
Time: 8:54 AM
*/

package dataStructures.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    Queue<Integer> q1, q2;

    public StackWithQueue(Queue<Integer> q1, Queue<Integer> q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    private void push(int value){
        q1.add(value);
    }

    private int pop(){
        if(q1.isEmpty()){
            System.out.println("Underflow");
            return -1;
        }else {
            while (q1.size() != 1){
                q2.add(q1.remove());
            }
            int value = q1.remove();
            //reload q1
            while (!q2.isEmpty()){
                q1.add(q2.remove());
            }
            return value;
        }
    }

    public static void main(String[] args){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        StackWithQueue stackWithQueue = new StackWithQueue(q1, q2);
        stackWithQueue.push(1);
        stackWithQueue.push(2);
        stackWithQueue.push(3);
        stackWithQueue.push(4);
        System.out.println(stackWithQueue.q1);
        System.out.println(stackWithQueue.pop());
    }
}
