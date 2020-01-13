/* 
User: Urmi
Date: 12/19/2019 
Time: 5:46 PM
*/

/**
 * Using Lambda expressions, write a function List <Integer>
 * getRandomSubset(List<Integer> list ) that returns a random subset of arbitrary size. All
 * subsets (including the empty set) should be equally likely to be chosen.
 */
package crackingcodeinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RandomLambda {

    //old Java way
    List<Integer> getRandomSubset1(List<Integer> list) {
        List<Integer> subset = new ArrayList<Integer>();
        Random random = new Random();
        for (int item : list)
            /* Flip coin. */
            if (random.nextBoolean()) {
                subset.add(item);
            }
        return subset;
    }



    public static List<Integer> getRandomSubset(List<Integer> list) {
        Random random = new Random();
        return list.stream().filter(k -> random.nextBoolean()).collect(Collectors.toList());
    }

    public static List<Integer> getRandomSubsetUsingPredicate(List<Integer> list) {
        Predicate<Object> p = (k) -> new Random().nextBoolean();
        return list.stream().filter(p).collect(Collectors.toList());
    }
}
