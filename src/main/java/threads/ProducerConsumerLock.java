/* 
User: Urmi
Date: 1/29/2020 
Time: 5:55 PM
*/

package threads;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLock {
    public static void main(String[] args){
        List<Integer> sharedQueue = new LinkedList<Integer>();
        Lock lock = new ReentrantLock();
        //producerCondition
        Condition producerCondition = lock.newCondition();
        //consumerCondition
        Condition consumerCondition = lock.newCondition();

        ProducerLock producer = new ProducerLock(sharedQueue,lock,producerCondition,consumerCondition);
        ProducerLock consumer = new ProducerLock(sharedQueue,lock,producerCondition,consumerCondition);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }
}

class ProducerLock implements Runnable{

    private List<Integer> sharedQueue;
    private int maxSize=2;

    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;

    public ProducerLock(List<Integer> sharedQueue, Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                produce(i);
            }catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }

    private void produce(int i) throws InterruptedException{
        lock.lock();

        // if sharedQuey is full producer await until consumer consumes.
        if(sharedQueue.size() == maxSize){
            producerCondition.await();
        }
        System.out.println("Produced : " + i);
        // as soon as producer p
        sharedQueue.add(i);
        consumerCondition.signal();
        lock.unlock();
    }
}

class ConsumerLock implements Runnable{

    private List<Integer> sharedQueue;
    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;

    public ConsumerLock(List<Integer> sharedQueue, Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            try {
                consume();
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }

    private void consume() throws InterruptedException{
        lock.lock();
        if(sharedQueue.size() == 0){
            consumerCondition.await();
        }
        System.out.println("consumed " + sharedQueue.remove(0));
        producerCondition.signal();
        lock.unlock();
    }
}
