package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/4/18
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrimeFactorization {
    public static List<Integer> primeFactorization(int x){
        List<Integer> factors = new ArrayList<>();
        if(x <= 2){
            return factors;
        }
        for(int i = 2; i <= x; i++){
            if(x % i == 0){
                factors.add(i);
                x /=i;
                i--;
            }
        }
        return factors;
    }

    public static void main(String[] args){
        System.out.println(primeFactorization(35));

    }
}
