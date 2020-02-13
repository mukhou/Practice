package threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableLambda {

    public static void main(String[] args){

        ExecutorService es = Executors.newFixedThreadPool(1);
        AtomicInteger count = new AtomicInteger();

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }catch (InterruptedException e){
                e.printStackTrace();
                throw new IllegalStateException("task interrupted", e);
            }
        };

        //OR
        Callable<Integer> task1 = () ->  count.incrementAndGet();

        Future<Integer> future = es.submit(task);
        try {
            //Calling the method get() blocks the current thread (main)
            // and waits until the callable completes before returning the actual result 123.
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        finally {
            es.shutdown();
        }

    }
}
