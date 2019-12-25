package crackingcodeinterview;

/**
 * Divide two numbers without using /
 * Time complexity: O(b)
 */
public class CalcDivision {

    //initialize sum to b. Keep adding b to the sum, until it is equal to a. the count will be the answer
    private static int divide(int a, int b){
        int count = 0;
        int sum = b;
        while(sum <= a){
            sum += b;
            count ++;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(divide(10, 2));
    }
}
