package threads;

import java.util.concurrent.*;

public class MyFuture<T> implements Future<T> {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private T result;

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        //Causes the current thread to wait until the latch has counted down to zero
        // unless the thread is
        countDownLatch.await();
        return result;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if(countDownLatch.await(timeout, unit)){
            return result;
        }else {
            throw new TimeoutException();
        }
    }

    void put(T value){
        result = value;
        //Decrements the count of the latch, releasing all waiting threads if the count reaches zero.
        //If the current count equals zero then nothing happens.
        countDownLatch.countDown();
    }
}
