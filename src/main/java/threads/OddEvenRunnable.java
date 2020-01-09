/* 
User: Urmi
Date: 1/7/2020 
Time: 5:01 PM
*/

package threads;

public class OddEvenRunnable implements Runnable{

    public int PRINT_NUMBERS_UPTO = 10;
    //IMP: static fields
    static int counter = 1;
    static Object lock = new Object();

    int remainder;//either 1 or 0

    OddEvenRunnable(int remainder){
        this.remainder=remainder;
    }

    @Override
    public void run() {
        while (counter < PRINT_NUMBERS_UPTO) {//terminating condition
            synchronized (lock) {
                while (counter % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + counter);
                counter++ ;
                lock.notifyAll();
            }
        }
    }
}