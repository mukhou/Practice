package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 5/4/15
 * Time: 8:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortList {
    public static void main (String args[]){
        List<String> list = Arrays.asList("urmi", "jhini","rini", "sharmi");
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        list.forEach(System.out::println );
        //OR
        Arrays.asList("urmi", "jhini","rini").sort((s1, s2) -> s1.compareTo(s2));



    }
}
