package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterRunnable implements Runnable{
    AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing " + count.incrementAndGet());
    }

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName() + " is executing..." );
        CounterRunnable counterRunnable = new CounterRunnable();
        Thread t = new Thread(counterRunnable);
        t.setName("counterrunnable");
        t.start();
    }
}
