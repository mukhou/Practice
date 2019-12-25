package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/2/18
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciLite {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.print(fiboLite(num));
    }

    private static int fiboLite(int num) {
        if(num <= 1){
            return num;
        }else {
            return fiboLite(num - 1) + fiboLite( num - 2);
        }
    }
}
