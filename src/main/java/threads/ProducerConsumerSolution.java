/**
 * Can also be implemented using a BlockingQueue.
 * A Queue that additionally supports operations that wait for the queue
 * to become non-empty when retrieving an element, and wait for space 
 * to become available in the queue when storing an element.
 */
package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerSolution {
	
	public static void main(String args[]){
		BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(1024);
		int size = 4;
		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
	}

}

 class Producer implements Runnable{

	private final BlockingQueue<Integer> sharedQueue;


    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
	
	@Override
	public void run() {
		try{
			for(int i = 0; i < 10; i ++){
				sharedQueue.put(1);
				Thread.sleep(1000);
			}
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
	}

	
}

class Consumer implements Runnable {
	
	private final BlockingQueue<Integer> sharedQueue;


    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


	@Override
	public void run() {
		try{
			while(true){
				sharedQueue.take();
			}
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
	}

	
}
