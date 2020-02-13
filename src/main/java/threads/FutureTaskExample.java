/* 
User: Urmi
Date: 2/10/2020 
Time: 12:12 PM
*/

package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//JJava CIP: pg 78
public class FutureTaskExample {

    private final FutureTask<ProductInfo> future = new FutureTask<>(this::loadProductInfo);

    private ProductInfo loadProductInfo(){
        return new ProductInfo();
    }

    private final Thread thread = new Thread(future);
    public void start() { thread.start(); }
    public ProductInfo get() throws InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof InterruptedException)
                throw (InterruptedException) cause;
            else
                throw launderThrowable(cause);
        }
    }

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("Not unchecked", t);
    }
}

class ProductInfo{

}
