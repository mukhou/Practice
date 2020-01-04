/* 
User: Urmi
Date: 12/24/2019 
Time: 10:47 AM
*/

package crackingcodeinterview;

/**
 * Add two numbers without using + operator
 */
public class AddWithoutPlus {

    public static int add1(int a, int b){
        if(b == 0){
            return a;
        }
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        return add1(partialSum, carry);


    }

    public static int add(int x, int y){
        while(y != 0){
            //only carry value
            // carry now contains common
            // set bits of x and y
            int carry = (x & y) << 1;

            //only sum value
            // Sum of bits of x and
            // y where at least one
            // of the bits is not set
            x = x ^ y;
            // Carry is shifted by
            // one so that adding it
            // to x gives the required sum
            y = carry;
        }
        return x;
    }

    public static void main(String[] args){
        System.out.println(add(4, 3));
        System.out.println(add1(4, 3));
    }
}
