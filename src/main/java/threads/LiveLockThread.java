package threads;

/**
 * LiveLock example in Java
 * This is an example of thread LiveLock situation. Here the boy would say "Hello" to the girl
 * only when she first address him "Hello". So the boy checks back after some Sleep.
 * Similarly the girl expects the same and does the same. Here, the both the threads waits
 * for some action from the other and livelock situation arises.
 * In this situation, unlike deadlock, the execution of threads doesn't stop, instead they run forever.
 */
public class LiveLockThread {

    private static class Human {
        String gender;
        Object lock ;
        Human(String gender, Object lock) {
            this.gender = gender;
            this.lock = lock;
        }

        String word = "!";

        public void sayHello(Human stranger) {
            System.out.println("word is " + word);
            synchronized (lock){
                while (!stranger.word.equals("Hello")) {
                    try {
                        System.out.println("Sleeping " + this.gender + " as " + stranger.gender + " hasn't said hello");
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                this.word = "Hello";
                lock.notifyAll();
            }

        }

    }

    private static class HelloThread implements Runnable {
        Human human;
        Human stanger;

        public HelloThread(Human human, Human stanger) {
            this.human = human;
            this.stanger = stanger;
        }

        @Override
        public void run() {
            human.sayHello(this.stanger);
        }
    }

    public static void main(String[] args) {

        Object lock = new Object();
        LiveLockThread.Human boy = new LiveLockThread.Human("boy", lock);
        LiveLockThread.Human girl = new LiveLockThread.Human("girl", lock);

        LiveLockThread.HelloThread boyThread = new LiveLockThread.HelloThread(boy, girl);
        LiveLockThread.HelloThread girlThread = new LiveLockThread.HelloThread(girl, boy);
        new Thread(boyThread).start();
        new Thread(girlThread).start();

    }
}
