package algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 9/4/15
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContiguousMaxSubArraySum {

    public static int maxSubArray(int[] A) {
        int newsum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
            newsum=Math.max(newsum+A[i],A[i]);
            max= Math.max(max, newsum);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2, -1, 2, 3, 4, -5};
        System.out.println(maxSubArray(arr));

    }
}
