/* 
User: Urmi
Date: 1/14/2020 
Time: 4:28 PM
*/

package threads;

public class TT extends Thread {

    public TT() {
        System.out.println("MyThread");
    }

    public void run(){
        System.out.println(" bar");
    }


    public void run(String s){
        System.out.println(" baz");
    }

}
