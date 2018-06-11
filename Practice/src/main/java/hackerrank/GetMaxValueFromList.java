package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/19/18
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetMaxValueFromList {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        OptionalInt max1 = list.stream().mapToInt(Integer::intValue).max();
        Optional<Integer> max2 = list.stream().max(Comparator.naturalOrder());
        //reduction
        Optional<Integer> max3 = list.stream().reduce(Integer::max);
        //collector
        Optional<Integer> max4 = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        int max5 = list.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();





    }
}
