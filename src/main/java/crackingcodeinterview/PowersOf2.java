package crackingcodeinterview;

/**
 * Given a number n, generate all powers of 2 upto that number
 */
// CTCI pg 67
// time complexity: O(log n)
// Explanation::
// For n = 50 we can divide 50 (or n) by 2 until we get down to the base case (1).
// the number of times we can halve n until we get 1
public class PowersOf2 {

    static int powers0f2(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            //recurse
            int prev = powers0f2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }


    }
    public static void main(String[] args){
        powers0f2(33);

    }
}
