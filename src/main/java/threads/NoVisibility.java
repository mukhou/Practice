/* 
User: Urmi
Date: 2/9/2020 
Time: 9:33 AM
*/

package threads;

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args){
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
