/* 
User: Urmi
Date: 11/3/2021 
Time: 8:08 AM
*/

package java8.lambda.java8inaction;

import java.util.function.Function;

public class TestApple {

    public static void main(String[] args){

        // below function is of signature Function<T, R>, where T is the integer which is passed as a
        // constructor argument to the Apple constructor. When invoked, it will result in a new instance of Apple
        // Note: there NEEDS to be a constructor in Apple which takes an Integer, without which
        // the below WON'T WORK
        Function<Integer, Apple> wtFunction = Apple::new;
        //apply to create an object
        wtFunction.apply(10);
    }
}

