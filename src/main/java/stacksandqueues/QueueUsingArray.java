package stacksandqueues;

public class QueueUsingArray {
    public int[] data = new int[10];
    int front, rear;

    public QueueUsingArray(){
        front = rear - 1;
    }
    public void enQueue(int val){
        if(isFull()){
            return;
        }else {
            data [++ rear] = val;
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
            if(front < rear){
                front = rear - 1;
            }
            return value;
        }
    }

    public int getSize(){
        if(isEmpty()){
            return 0;
        }else {
            return rear - front;
        }
    }

    public boolean isFull(){
        return rear == 10 - 1 ;
    }

    public boolean isEmpty(){
        return rear == -1;
    }
}
