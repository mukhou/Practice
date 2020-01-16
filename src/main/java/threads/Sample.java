/* 
User: Urmi
Date: 1/14/2020 
Time: 4:18 PM
*/

package threads;
 class Sample implements Runnable {
    private String threadName;
    private Thread t;

    public Sample(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true)
            System.out.println(threadName);

    }

    public void start(){
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }


}
