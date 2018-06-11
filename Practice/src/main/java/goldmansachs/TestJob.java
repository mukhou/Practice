package goldmansachs;

public class TestJob {
	
	static class Job extends Thread {
        private int counter;

        @Override
        public void run() {
            synchronized(this) {
                for(int i = 0; i < 100000; i++)
                    counter++;
                
                this.notifyAll();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Job job = new Job();
        job.start();
        // inserting this line causes the program to go into an infinite loop
        // since Job acquires the lock while main() sleeps
        // and calls notifyAll() even before main() gets a chance
        // to execute wait()
        /*try{
        	Thread.currentThread().sleep(10000);
        }catch(InterruptedException e){
        	
        }*/
        synchronized(job) {
            job.wait();
        }
        
        System.out.println(job.counter);
    }

}

