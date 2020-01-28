/* 
User: Urmi
Date: 1/6/2020 
Time: 9:42 AM
*/

package threads;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{
    //another example
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(()
            -> new SimpleDateFormat("yyyyMMdd HHmm"));


    @Override
    public void run() {
        System.out.println("Thread Name before change= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name after change= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i < 5; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }
}
