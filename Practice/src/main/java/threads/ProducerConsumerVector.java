package threads;

import java.util.LinkedList;
import java.util.Vector;

public class ProducerConsumerVector {

    public static void main(String args[]) {
        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new ProducerVector(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new ConsumerVector(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();
    }
}



    class ProducerVector implements Runnable{
        private final Vector sharedQueue;
        private final int SIZE;

        ProducerVector(Vector sharedQueue, int size){
            this.sharedQueue = sharedQueue;
            this.SIZE = size;
        }

        @Override
        public void run(){
            for(int i = 0; i < 10; i++){
                try {
                    produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void produce(int i) throws InterruptedException {
            while (sharedQueue.size() == SIZE){
                synchronized (sharedQueue){
                    System.out.println("Queue size is full " + sharedQueue.size());
                    sharedQueue.wait();
                }

            }
            synchronized (sharedQueue){
                sharedQueue.add(i);
                sharedQueue.notifyAll();
            }
        }
    }



    class ConsumerVector implements Runnable{

        private final Vector sharedQueue;
        private final int SIZE;

        ConsumerVector(Vector sharedQueue, int size) {
            this.sharedQueue = sharedQueue;
            this.SIZE = size;
        }

        @Override
        public void run(){
            while(true){
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            while(sharedQueue.size() == 0){
                synchronized (sharedQueue){
                    System.out.println("Queue is empty");
                    sharedQueue.wait();
                }
            }
            synchronized (sharedQueue){
                System.out.println(sharedQueue.remove(0));
                sharedQueue.notifyAll();

            }
        }
    }

