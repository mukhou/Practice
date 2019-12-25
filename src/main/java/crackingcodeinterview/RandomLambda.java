/* 
User: Urmi
Date: 12/19/2019 
Time: 5:46 PM
*/

package crackingcodeinterview;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomLambda {
    public static List<Integer> getRandomSubset(List<Integer> list){
        Random random = new Random();
        return list.stream().filter(k -> random.nextBoolean()).collect(Collectors.toList());
    }

    public static List<Integer> getRandomSubsetUsingPredicate(List<Integer> list){
        Predicate<Object> p = (k) -> new Random().nextBoolean();
        return list.stream().filter(p).collect(Collectors.toList());
    }
}
