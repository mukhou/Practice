package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda2 {
    public static void main (String args[]){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        // old way
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.print(names);
        System.out.println();
        // with lambda
        Collections.sort(names, (a, b) -> b.compareTo(a));


        System.out.print(names);
    }
}
