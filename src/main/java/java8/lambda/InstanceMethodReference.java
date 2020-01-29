package java8.lambda;


import java.lang.*;

public class InstanceMethodReference {
    // usual method
    String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }

    public static void main (String args[]){
        InstanceMethodReference something = new InstanceMethodReference();
        //pass reference of the "startsWith" method via the :: keyword.
        StringConverter<String, String> stringConverter = something::startsWith;
        String converted = stringConverter.convert("Java");
        System.out.println(converted);



    }
}


@java.lang.FunctionalInterface
interface StringConverter<T, F>{
    T convert(F from);
}

