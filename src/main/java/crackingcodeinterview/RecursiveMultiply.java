/**
 * Write a recursive function to multiply two positive integers without using
 * the * operator (or / operator}. You can use addition, subtraction, and bit shifting, but you should
 * minimize the number of those operations.
 */

package crackingcodeinterview;

//see explanation on CTCI, pg 364
public class RecursiveMultiply {

    public static int mult(int a, int b){
        int absa = Math.abs(a);
        int absb = Math.abs(b);
        int smaller = absa < absb ? absa : absb;
        int bigger = absa < absb ? absb : absa;
        int res =  multHelper(smaller, bigger);
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return res;
        } else {
            return negateNum(res);
        }
    }

    private static int multHelper(int smaller, int bigger) {

        if(smaller == 0){
            return  0;
        }else if(smaller == 1){
            return bigger;
        }
        //or right shift smaller: temp = smaller >> 1
        int temp = smaller / 2;
        int halfprod = multHelper(temp, bigger);//recurse
        int res;

        if(smaller % 2 == 0){
            res = halfprod + halfprod;
        }else {
            res = halfprod + halfprod + bigger;
        }

        return res;
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

    //ALTERNATIVE WAY: BAD APPROACH: TIME CONSUMING
    static int multiplyRecursive(int x, int y){
        if(y == 0){
            return 0;
        }else if(y == 1){
            return x;
        }

        if(y > 0){
            return (x + multiplyRecursive(x, y - 1));
        }
        if(y < 0){
            return  -multiplyRecursive(x, -y);
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(mult(8, 4));
       // System.out.println(multiplyRecursive(-30, 35));

    }

}
