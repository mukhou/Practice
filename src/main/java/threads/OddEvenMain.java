/* 
User: Urmi
Date: 1/7/2020 
Time: 4:58 PM
*/

package threads;

public class OddEvenMain {
    public static void main(String[] args){
        OddEvenRunnable oddNumbers = new OddEvenRunnable(1);
        OddEvenRunnable evenNumbers = new OddEvenRunnable(0);

        Thread t1=new Thread(oddNumbers,"Odd");
        Thread t2=new Thread(evenNumbers,"Even");

        t1.start();
        t2.start();
    }
}
