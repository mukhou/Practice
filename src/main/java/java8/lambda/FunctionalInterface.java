package java8.lambda;


import java.util.function.Function;

public class FunctionalInterface {
    public static void main (String args[]){
        //String to Integer, R = Integer, T = String
        //creating the interface
        Converter<Integer, String> converter = (from) -> Integer.valueOf(from);
        String str = "123";
        Integer i = converter.convert(str);
        Converter<Integer, String> converter1 = Integer::valueOf;
        Integer j = converter1.convert("34");
        System.out.println(i + " " + j);

        // Integer to String
        Converter<String, Integer> c1 = (from) -> Integer.toString(from);
        Converter<String, Integer> c = Object::toString;
        String s = c1.convert(new Integer(32));
        System.out.println(s);
        String s1 = c.convert(new Integer(32));
        System.out.println(s1);

        //define a function and invoke it by calling its apply method
        Function<Integer, Integer> function = x -> x + 1;
        Integer res = function.apply(5);
        System.out.println(res);

    }


}


@java.lang.FunctionalInterface
//ATM: Function: I/O => Input/Output
interface Converter<R, T>{
    R convert(T from);
}




