/* 
User: Urmi
Date: 2/2/2020 
Time: 2:53 PM
*/

package byteBybyte;

public class SquareANumber {
    private static int square(int n){
        int res = 0;
        for(int i = 0; i < n; i ++){
            res += n;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(square(3));
    }
}
