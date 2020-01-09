package threads;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FindMinUsingForkJoin extends RecursiveTask<Integer>
{
    //The ForkJoinPool is needed to start the entire process
    //We'll only need 1 for the entire project, hence the 'static'
    static final ForkJoinPool fjPool=new ForkJoinPool();

    int[] array;
    int lo,hi; //this represents the range considered by this instance.  Remember that we start at 'lo', and go to 'hi-1'
    static final int SEQUENTIAL_CUTOFF=1000;

    public FindMinUsingForkJoin(int[] a, int l, int h)
    {
        array = a;
        lo = l;
        hi = h;
    }

    @Override
    public Integer compute()
    {
        //first we check if it's at or below the sequential cutoff; if so, do it the easy way
        if(hi - lo <= SEQUENTIAL_CUTOFF)
        {
            int min=Integer.MAX_VALUE;
            for(int i = lo; i < hi; i ++){
                min=Math.min(min, array[i]);
            }
            return min;
        }
        else //otherwise, divide further
        {
            int mid = (lo + hi) / 2;
            FindMinUsingForkJoin left=new FindMinUsingForkJoin(array, lo, mid); //so the left starts at 'lo' and goes to 'mid-1'...
            FindMinUsingForkJoin right=new FindMinUsingForkJoin(array, mid, hi); //and the right starts at 'mid' and goes to 'hi-1'
            left.fork(); //start the left in its own process
            int rightMin=right.compute(); //compute the right in this process
            int leftMin=left.join(); //wait for the left to finish
            return Math.min(leftMin,rightMin);
        }
    }

    //this code is here to test out our above program
    public static void main(String[] args)
    {
        //first create an array of random numbers
        Random r=new Random();
        int arrSize=10000000;
        int[] arr=new int[arrSize];
        for(int i=0;i<arr.length;i++) arr[i]=r.nextInt(100000000);

        //now find the min; remember, we have to start off the whole thing with 'invoke'
        long startTime=System.currentTimeMillis();
        int min=fjPool.invoke(new FindMinUsingForkJoin(arr,0,arrSize));
        long endTime=System.currentTimeMillis();
        System.out.println("The min is "+min);
        System.out.println("Time taken: "+(endTime-startTime)+"ms");
    }
}