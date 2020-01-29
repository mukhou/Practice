/* 
User: Urmi
Date: 1/29/2020 
Time: 9:22 AM
*/

package dataStructures.stacksandqueues;

import java.util.Stack;

public class QueueWithStack {

    Stack<Integer> s1, s2;

    public QueueWithStack(Stack<Integer> s1, Stack<Integer> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    private void enQueue(int value) {
        s1.push(value);
    }

    private int dequeue() {
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        QueueWithStack q = new QueueWithStack(s1, s2);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println(q.s1);
        System.out.println(q.dequeue());

    }
}
