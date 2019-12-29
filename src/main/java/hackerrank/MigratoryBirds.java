
package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/19/18
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 * 1, 4, 4, 4, 5, 3
 */
public class MigratoryBirds {
    static int migratoryBirds(int n, int[] arr) {
        int maxInd = 0;
        for (int i = 0; i < 5; ++i) {
            if (arr[maxInd] < arr[i]) {
                maxInd = i;
            }
        }

        return maxInd + 1;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }*/
        System.out.println(migratoryBirds(6, new int[]{1, 4, 4, 4, 5, 3}));

    }
}
