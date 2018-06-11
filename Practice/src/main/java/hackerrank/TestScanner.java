package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/8/17
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestScanner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split("\\t");
        System.out.println(Arrays.toString(strArr));
    }
}
