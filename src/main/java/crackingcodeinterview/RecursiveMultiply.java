/**
 * Write a recursive function to multiply two positive integers without using
 * the * operator (or / operator}. You can use addition, subtraction, and bit shifting, but you should
 * minimize the number of those operations.
 */

package crackingcodeinterview;

//see explanation on Ch 8, problem 5 of CTCI
public class RecursiveMultiply {

    public static int mult(int a, int b){
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;
        return multHelper(smaller, bigger);
    }

    private static int multHelper(int smaller, int bigger) {

        if(smaller == 0){
            return  0;
        }else if(smaller == 1){
            return bigger;
        }

        int res;
        int temp = smaller / 2;
        //recuse
        int halfprod = multHelper(temp, bigger);

        if(smaller % 2 == 0){
            res = halfprod + halfprod;
        }else {
            res = halfprod + halfprod + bigger;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(mult(31, 35));

    }

}
