package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/20/18
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class BonAppetit {
    // 4, 1, 7 {3 10 2 9}
    static int bonAppetit(int k, int b, int[] arr) {
        // Complete this function
        int charged = 0;
        for(int i = 0; i < arr.length; i ++){
            charged += arr[i];
        }
        charged = charged /2 ;//12
        int actual  =  charged - (arr[k] / 2);

        if(actual == b){
            System.out.println("Bon Appetit");
        }else {
            System.out.println(charged - actual);
        }
        return 0;

    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();*/
        int result = bonAppetit( 1, 12, new int[]{3, 10, 2, 9});
        //System.out.println(result);
    }
}
