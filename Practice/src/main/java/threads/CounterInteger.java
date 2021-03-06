package threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterInteger implements Callable<Integer> {
    AtomicInteger count = new AtomicInteger();

    @Override
    public Integer call(){
        System.out.println("Inside " + Thread.currentThread().getName());
        return count.incrementAndGet();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + " executing ...");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //create an instance of Callable
        CounterInteger counterInteger = new CounterInteger();
        //submit tasks
        Future<Integer> f1 = executorService.submit(counterInteger);
        Future<Integer> f2 = executorService.submit(counterInteger);
        int x = f1.get();
        int y = f2.get();
        System.out.println(x + " " + y);
        executorService.shutdown();

    }
}
