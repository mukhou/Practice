/* 
User: Urmi
Date: 12/20/2019 
Time: 1:55 PM
*/

package crackingcodeinterview;

import java.util.function.Function;
import java.util.function.Predicate;

public class  FizzBuzz implements Runnable{

    private Predicate<Integer> validate;
    private Function<Integer, String> printer;
    private int max;

    //IMP: static fields
    private static Object lock = new Object();
    private static int current = 1;


    public FizzBuzz(Predicate<Integer> validate, Function<Integer, String> printer, int max){
        this.validate = validate;
        this.printer = printer;
        this.max = max;
    }


    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if(current > max){
                    return;
                }
                if(validate.test(current)){
                    System.out.println(printer.apply(current));
                    current++;
                }

            }
        }


    }
}
