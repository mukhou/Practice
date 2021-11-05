/* 
User: Urmi
Date: 11/5/2021 
Time: 8:08 AM
*/

package java8.lambda.java8inaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestNumbers {

    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> sq = list.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println(sq);
        //find max number
        Optional<Integer> max = list.stream().reduce(Integer::max);
    }

    /*Given two lists of numbers, how would you return all pairs of numbers? For example, given a
    list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
    simplicity, you can represent a pair as an array with two elements.*/
    public static List<int[]> pair(List<Integer> l1, List<Integer> l2) {
        return l1.stream().flatMap(i -> l2.stream()
                .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }

    /*extend the previous example to return only pairs whose sum is divisible by 3?*/
    public static List<int[]> pairBy3(List<Integer> l1, List<Integer> l2) {
        return l1.stream().flatMap(i -> l2.stream()
                .filter(j -> (i + j) % 3 ==0)
                .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
    }
}
