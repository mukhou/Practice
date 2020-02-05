/* 
User: Urmi
Date: 1/29/2020 
Time: 5:55 PM
*/

package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//read: file:D://ebooks//Java books//08-threadsandlockspart2.pdf
public class ProducerConsumerLock {
    public static void main(String[] args){
        Queue<Integer> sharedQueue = new LinkedList<>();
        Lock lock = new ReentrantLock();
        //A condition instance is intrinsically bound to a lock.
        // We need to keep threads in separate wait-sets so that we can use the optimization of
        // only notifying a single thread at a time when items or spaces become
        // available in the buffer. This can be achieved using two Condition instances.
        //producerCondition
        Condition producerCondition = lock.newCondition();
        //consumerCondition
        Condition consumerCondition = lock.newCondition();

        ProducerLock producer = new ProducerLock(sharedQueue,lock,producerCondition,consumerCondition);
        ConsumerLock consumer = new ConsumerLock(sharedQueue,lock,producerCondition,consumerCondition);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }
}


class ProducerLock implements Runnable {
    private final Random theRandom = new Random();

    Queue<Integer> sharedQueue;
    private int SIZE = 10;

    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;

    public ProducerLock(Queue<Integer> sharedQueue, Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (sharedQueue.size() == SIZE) {
                System.out.println(Thread.currentThread().getName()
                        + " : Buffer is full, waiting");
                producerCondition.await();
            }

            int number = theRandom.nextInt();
            boolean isAdded = sharedQueue.offer(number);
            if (isAdded) {
                System.out.printf("%s added %d into queue %n", Thread
                        .currentThread().getName(), number);

                // signal consumer thread that, buffer has element now
                System.out.println(Thread.currentThread().getName()
                        + " : Signalling that buffer is no more empty now");
                consumerCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}

class ConsumerLock implements Runnable {
    Queue<Integer> sharedQueue;

    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;

    public ConsumerLock(Queue<Integer> sharedQueue, Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }


    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (sharedQueue.size() == 0) {
                System.out.println(Thread.currentThread().getName()
                        + " : Buffer is empty, waiting");
                consumerCondition.await();
            }

            Integer value = sharedQueue.poll();
            if (value != null) {
                System.out.printf("%s consumed %d from queue %n", Thread
                        .currentThread().getName(), value);

                // signal producer thread that, buffer may be empty now
                System.out.println(Thread.currentThread().getName()
                        + " : Signalling that buffer may be empty now");
                producerCondition.signalAll();
            }

        } finally {
            lock.unlock();
        }
    }
}