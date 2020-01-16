/* 
User: Urmi
Date: 1/14/2020 
Time: 4:20 PM
*/

package threads;

public class TestThread {

    public static void main(String[] args) {
        TT tt = new TT(){
            @Override
            public void run() {
                System.out.println(" foo");
            }
        };
        tt.start();
    }

    public static void bad(){}
}
