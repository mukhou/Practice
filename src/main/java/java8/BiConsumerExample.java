/* 
User: Urmi
Date: 1/29/2020 
Time: 12:11 PM
*/

package java8;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args){
        BiConsumer<String, String> biConsumer = (x, y) -> {
            System.out.println(x.toUpperCase() + " " + y.toUpperCase());
        };
        biConsumer.accept("urmi", "rini");
    }

}
