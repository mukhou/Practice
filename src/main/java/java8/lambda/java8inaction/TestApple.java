/* 
User: Urmi
Date: 11/3/2021 
Time: 8:08 AM
*/

package java8.lambda.java8inaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestApple {

    public static void main(String[] args){

        // below function is of signature Function<T, R>, where T is the integer which is passed as a
        // constructor argument to the Apple constructor. When invoked, it will result in a new instance of Apple
        // Note: there NEEDS to be a constructor in Apple which takes an Integer, without which
        // the below WON'T WORK
        Function<Integer, Apple> wtFunction = Apple::new;
        //apply to create an object
        Apple apple = wtFunction.apply(10);

        List<Integer> wts = Arrays.asList(3, 5, 10);
        List<Apple> apples = map(wts, Apple::new);

        // use of BiFunction to call the constructor of Apple,
        // which takes two arguments: Integer and String
        BiFunction<Integer, String, Apple> biFunction = Apple::new;
        String color = "green";
        Apple apple1 = biFunction.apply(10, color);

    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer wt : list){
            result.add(f.apply(wt));
        }
        return result;
    }
}

