package dataStructures;

import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue<T> {

    private List<T> queue = new LinkedList<>();
    private int limit = 10;

    public MyBlockingQueue(int limit){
        this.limit = limit;
    }

    public synchronized void enqueue(T item) throws InterruptedException{
        while(this.queue.size() == limit){
            wait();
        }
        if(this.queue.size() == 0){
            notifyAll();
        }
        queue.add(item);

    }

    public synchronized T dequeue() throws InterruptedException{
        while(this.queue.size() == 0){
            wait();
        }
        if(this.queue.size() == limit){
            notifyAll();
        }
        return queue.remove(0);
    }
}
