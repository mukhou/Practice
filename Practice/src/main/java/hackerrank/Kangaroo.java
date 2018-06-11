package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/25/17
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kangaroo {
        static String kangaroo(int x1, int v1, int x2, int v2) {
            boolean ans = false;
            if(x1==x2 && v1==v2) {
                ans = true;
            } else if (x1!=x2 && v1!=v2 && (x1-x2)/(v2-v1) > 0 && (x1-x2)%(v2-v1)==0) {
                ans = true;
            }
            return  ans?"YES":"NO";
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int x1 = in.nextInt();
            int v1 = in.nextInt();
            int x2 = in.nextInt();
            int v2 = in.nextInt();
            String result = kangaroo(x1, v1, x2, v2);
            System.out.println(result);
        }
}
