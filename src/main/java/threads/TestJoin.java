package threads;

public class TestJoin {
    public static void main(String...args) throws InterruptedException{
        System.out.println("In main() method");
        MyRunnable runnable=new MyRunnable();
        Thread thread1=new Thread(runnable);
        thread1.setName("A");
        Thread thread2=new Thread(runnable);
        thread2.setName("B");

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        System.out.println("end main() method");
    }

}

class MyRunnable implements Runnable{
    public void run(){
        System.out.println("in run() method");
        for(int i=0;i<5;i++){
            System.out.println("i="+i+" ,ThreadName="+Thread.currentThread().getName());
        }
    }
}
