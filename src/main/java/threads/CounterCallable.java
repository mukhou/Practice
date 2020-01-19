package threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

//worker class
public class CounterCallable implements Callable<String> {
    // count is an instance variable and it is marked atomicinteger
    // so it is stored on the main heap, thus any read write to it is atomic
    //hence the value after future2 increments it, is 2
    AtomicInteger count = new AtomicInteger();
    Integer i = 0;
    @Override
    public String call() throws Exception {
        //value of i will be 1 for both threads
        System.out.println("Integer is " + ++i);
        return Thread.currentThread().getName() + " is executing " + count.incrementAndGet();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + " executing ...");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CounterCallable cc = new CounterCallable();
        //create the futures(returned by a Callable)
        Future<String> f1 = executorService.submit(cc);//producer
        Future<String> f2 = executorService.submit(cc);//producer
        System.out.println(f1.get());
        System.out.println(f2.get());
        executorService.shutdown();



    }
}
