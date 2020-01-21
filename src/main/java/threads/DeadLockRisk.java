/* 
User: Urmi
Date: 1/21/2020 
Time: 5:31 PM
*/

package threads;

public class DeadLockRisk {
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(new ThreadA(sharedResource));
        Thread t2 = new Thread(new ThreadB(sharedResource));
        t1.start();
        t2.start();
    }

}

class Resource {
    int value;
}

class SharedResource {
    private Resource a = new Resource();
    private Resource b = new Resource();

    public int read() {
        synchronized (a) {
            System.out.println("in read() " + Thread.currentThread().getName() + " waiting for write");
            synchronized (b) {
                return a.value + b.value;
            }
        }
    }
    public void write(int valueA, int valueB) {
        synchronized (b) {
            System.out.println("in write() " + Thread.currentThread().getName() + " waiting for read");
            synchronized (a) {
                a.value = valueA;
                b.value = valueB;
            }
        }
    }
}

class ThreadA implements Runnable{

    private SharedResource sharedResource;

    public ThreadA(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.read();
    }
}

class ThreadB implements Runnable{

    private SharedResource sharedResource;

    public ThreadB(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.write(10, 12);
    }
}
