/* 
User: Urmi
Date: 1/27/2020 
Time: 5:38 PM
*/

package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableLambda {

    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(123);
            }catch (InterruptedException e){
                e.printStackTrace();
                throw new IllegalStateException("task interrupted", e);
            }
        };
        for(int i = 0; i < 5; i++){
            es.execute(task);
        }
        es.shutdown();
    }

}
