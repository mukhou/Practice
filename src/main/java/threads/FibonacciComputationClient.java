package threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciComputationClient {
    public static void main(String[] args){
        //to calculate 20th element of Fibonacci-Series
        int number = 20;
        int poolSize = Runtime.getRuntime().availableProcessors();
        ForkJoinPool f = new ForkJoinPool(poolSize);
        int result = f.invoke(new FibonacciComputation(number));
        System.out.println("Final result is " + result);
    }
}

class FibonacciComputation extends RecursiveTask<Integer> {
    private final int number;
    public FibonacciComputation(int n){
        number = n;
    }
    @Override
    protected Integer compute() {
        if(number <= 1){
            return number;
        }
        FibonacciComputation f1 = new FibonacciComputation(number - 1);
        f1.fork();
        System.out.println("current thread is "+ Thread.currentThread().getName());
        FibonacciComputation f2 = new FibonacciComputation(number - 2);
        return f2.compute() + f1.join();
    }
}
