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

   private static class Human{
        Human(String s) {
            this.gender = s;
        }

        String gender;
        String word = "!";
        public void sayHello(Human h) {
            while(!h.word.equals("Hello")) {
                try {
                    System.out.println("Sleeping " +this.gender + " as " + h.gender+" hasn't said hello");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
            this.word = "Hello";
        }

    }

    private static class HelloThread implements Runnable {
        Human h;
        Human stanger;

        void setHuman(Human hu) {
            this.h=hu;
        }

        void setStranger(Human hu) {
            this.stanger = hu;
        }

        @Override
        public void run() {

            h.sayHello(this.stanger);
        }
    }
    public static void main(String[] args) {

        final LiveLockThread.Human boy = new LiveLockThread.Human("boy");
        final LiveLockThread.Human girl = new LiveLockThread.Human("girl");
        LiveLockThread.HelloThread ht1 = new LiveLockThread.HelloThread();
        ht1.setHuman(boy);
        ht1.setStranger(girl);

        LiveLockThread.HelloThread ht2 = new LiveLockThread.HelloThread();
        ht2.setHuman(girl);
        ht2.setStranger(boy);
        new Thread(ht1 ).start();
        new Thread(ht2).start();

    }
}
