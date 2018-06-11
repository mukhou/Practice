package threads;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 6/27/15
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i % 10) == 0) {
                System.out.println("Value of i is " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

    public static void main(String[] args) {
        TestThread1 t = new TestThread1();
        Thread th = new Thread(t);
        th.setName("count thread");
        th.start();

    }

}

