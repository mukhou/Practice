/* 
User: Urmi
Date: 1/8/2020 
Time: 8:30 AM
*/

package threads;

public class UncaughtExceptionHandlerExample {
    public static void main(String ar[]) {

        //Register Global Exception Handler for all Threads
        Thread.setDefaultUncaughtExceptionHandler((t, e) ->
                System.out.println("Default Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage()));

        ThreadGroup tr = new ThreadGroup("MyGroup") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("ThreadGroup Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage());
            }
        };

        Thread t1 = new Thread(tr, new WorkerThread());
        t1.setName("T1");
        t1.start();

        //will use exception handler of type tr(ThreadGroup)
        Thread t2 = new Thread(tr, new WorkerThread());
        t2.setName("T2");
        t2.start();

        Thread t3 = new Thread(new WorkerThread());
        t3.setName("T3");

        //creates an instance of UncaughtExceptionHandler and invokes its method:
        //uncaughtException(Thread t, Throwable e)
        t3.setUncaughtExceptionHandler((t, e) ->
                System.out.println("Thread Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage()));

        t3.start();

        //no exception handler set, hence will use the default one
        Thread t4 = new Thread(new WorkerThread());
        t4.setName("T4");
        t4.start();

        Thread t5 = new Thread(() -> {
           while (true){
               try{
                   System.out.println("I am printing");
                   Thread.sleep(1000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });
        t5.setName("T5");
        t5.start();

    }
}

class WorkerThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Thread Exception Example");
    }
}

