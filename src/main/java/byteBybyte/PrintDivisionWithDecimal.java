/* 
User: Urmi
Date: 1/7/2020 
Time: 10:07 AM
*/
/**
 * Given a rational number in form a/b rational numbers, you have to print the number in its decimal format. If its recurring decimal you have to print the recurring part within parenthesis.
 * Eg 1, For 10/3 output should be 3.(3)
 * Eg 2, For 10/8 output should be 1.25
 */

package byteBybyte;

public class PrintDivisionWithDecimal {

    private static void computeDivision(int dividend, int divisor, int n){
        // Base cases
        if(divisor == 0){
            System.out.println("infinite");
            return;
        }
        if(dividend == 0){
            System.out.println("0");
            return;
        }
        if(n == 0){
            // Since n <= 0, don't compute after decimal
            System.out.println(dividend / divisor);
            return;
        }

        // Handling negative numbers
        if (((dividend > 0) && (divisor < 0)) || ((dividend < 0) && (divisor > 0))) {
            System.out.print("-");
            dividend = dividend > 0 ? dividend : -dividend;
            divisor = divisor > 0 ? divisor : -divisor;
        }

        int quotient = dividend / divisor;
        for(int i = 0; i <= n; i++ ){
            System.out.print(quotient);
            //set x to remainder
            dividend = dividend - (divisor * quotient);
            if(dividend == 0){
                break;
            }
            //remainder becomes dividend for next iteratoon
            dividend = dividend * 10;
            quotient = dividend / divisor;
            if(i == 0){
                System.out.print(".(");
            }
        }
        System.out.print(")");
    }

    public static void main(String[] args)
    {
        int x = 10, y = 3, n = 2;
        computeDivision(x, y, n);
    }
}
