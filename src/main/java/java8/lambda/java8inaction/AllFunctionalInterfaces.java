package java8.lambda.java8inaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/21/18
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllFunctionalInterfaces {
    //PREDICATE
    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }

    public static <T> List<T>  filter(List<T> list, Predicate<T> predicate){
        List<T> results = new ArrayList<>();
        for(T s : list){
            if(predicate.test(s)){
                results.add(s);
            }
        }
        return results;

    }

    //PREFERRED
    List<String> list1 = filter(
            Arrays.asList("lambdas", "in", "action"),
            (String s) -> !s.isEmpty() //the lambda is the implementation of the test method

    );
    //OR
    Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();
    List<String> list = filter(Arrays.asList("lambdas", "in", "action"), nonEmptyString);

    @FunctionalInterface
    public interface IntPredicate{
        boolean test(int t);
    }

    IntPredicate intPredicate = (int i ) -> (i % 2 == 0);



}
