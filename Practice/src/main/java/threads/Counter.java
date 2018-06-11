package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends Thread{
    AtomicInteger count = new AtomicInteger();

    public void run(){
        System.out.println(Thread.currentThread().getName() + " is executing " + count.incrementAndGet());

    }

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName() + " is executing..." );
        Counter counter = new Counter();
        counter.setName("counter thread");
        counter.start();


    }

}
