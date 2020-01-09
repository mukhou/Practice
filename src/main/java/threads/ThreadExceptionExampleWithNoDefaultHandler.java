/* 
User: Urmi
Date: 1/8/2020 
Time: 8:22 AM
*/

package threads;

public class ThreadExceptionExampleWithNoDefaultHandler {
    public static void main(String[] args){
        Thread t1 = new Thread(() -> {
            throw new RuntimeException("Thread Exception Example");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("In thread 2");
        });
        t2.start();

        while(true){
            System.out.println("ThreadDemo.main()");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
