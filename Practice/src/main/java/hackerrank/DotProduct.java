package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/31/18
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class DotProduct {
    public static void main (String args[]){
        int[] arr1 = {1, 2};
        int[] arr2 = {2, 3};
        int result = dotProduct(arr1, arr2);
        System.out.println(result);
    }

    private static int dotProduct(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length){
            throw new IllegalArgumentException("bad input");
        }
        int result = 0;
        for(int i = 0; i < arr1.length; i ++){
            result += arr1[i] * arr2[i];
        }
        return result;
    }
}
