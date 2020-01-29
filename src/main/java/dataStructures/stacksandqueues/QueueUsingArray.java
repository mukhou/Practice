package dataStructures.stacksandqueues;

public class QueueUsingArray {

    int max = 100;
    public int[] data = new int[max];

    int front, back;

    public QueueUsingArray(){
        front = back - 1;
    }
    public void enQueue(int val){
        if(isFull()){
            return;
        }else {
            data [++ back] = val;
            // queue is empty
            if(front == -1){
                front ++;
            }
        }
    }

    public int deQueue(){
        if(isEmpty()){
            return  0;
        }else {
            int value = data[front ++];
            // there was originally just one element present in the queue
            // so now queue is empty setting the queue back to its original state
            if(front < back){
                front = back - 1;
            }
            return value;
        }
    }

    public boolean isFull(){
        return back == max - 1 ;
    }

    public boolean isEmpty(){
        return back == -1;
    }

    public int getSize(){
        if(isEmpty()){
            return 0;
        }else {
            return back - front;
        }
    }


}
