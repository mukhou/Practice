/* 
User: Urmi
Date: 11/3/2021 
Time: 8:02 AM
*/

package java8.lambda.java8inaction;

import java.util.function.Function;

public interface AppleFunction {

    // below function is of signature Function<T, R>, where T is the integer which is passed as a
    // constructor argument to the Apple constructor, resulting in a new instance of Apple
    // Note: there NEEDS to be a constructor in Apple which takes an Integer, without which
    // the below WON'T WORK
    Function<Integer, Apple> wtFunction = Apple::new;

}
