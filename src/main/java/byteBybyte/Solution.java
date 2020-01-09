/* 
User: Urmi
Date: 1/7/2020 
Time: 5:27 PM
*/

package byteBybyte;

public class Solution {
    public static int solution(int X) {
        int fibo = 1;
        int fiboPrev = 0;
        int lower = fiboPrev, upper = fibo;
        while(X <= 1000000){
            int temp = fibo;//store the value of fibo
            fibo += fiboPrev;
            fiboPrev = temp;
            if(fibo > X){
                lower = fiboPrev;
                upper = fibo;
               // System.out.println(fiboPrev + " " + fibo);
                break;
            }

        }


        int diff = X - lower;
        int diff1 = upper - X;

        return Math.min(diff, diff1);
    }
    public static void main(String[] args){
        System.out.println(solution(30));

    }
}
