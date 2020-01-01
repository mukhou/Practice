/* 
User: Urmi
Date: 12/20/2019 
Time: 10:06 PM
*/

package crackingcodeinterview;

import static java.lang.Math.abs;

public class Operations {

   public static int multiply(int a, int b) {

        int absa = Math.abs(a);
        int absb = Math.abs(b);

        int res = (absa < absb) ? multiplyPos(absa, absb) : multiplyPos(absb, absa);
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return res;
        } else {
            return negateNum(res);
        }

    }

    private static int multiplyPos(int smaller, int larger) {
        int res = 0;
        for (int i = 0; i < smaller; i++) {
            res += larger;
        }
        return res;
    }

    /* Divide a by b by literally counting how many times b can go into
     * a. That is, count how many times you can add b to itself until you reach a. */
    public static int divide(int a, int b) throws java.lang.ArithmeticException {
        if (b == 0) {
            throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
        }

        int absa = abs(a);
        int absb = abs(b);

        //EXACTLY SAME LOGIC AS IN CalcDivision
        int res = 0, count = 0;
        while (res + absb <= absa){
            res += absb;
            count++;
        }
        
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return count;
        } else {
            return negateNum(count);
        }



    }

    private static int negateNum(int num) {
        int res = 0;
        int newSign = num < 0 ? 1 : -1;
        while (num != 0) {
            //increase/decrease final result by 1
            res += newSign;
            //increase/decrease original number by 1
            num += newSign;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divide(16, 2));
        System.out.println(multiply(31, 35));
    }
}
